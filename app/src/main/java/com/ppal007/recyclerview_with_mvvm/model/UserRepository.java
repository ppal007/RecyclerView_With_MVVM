package com.ppal007.recyclerview_with_mvvm.model;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserRepository {

    private Application application;
    private User[] users;
    private MutableLiveData<User[]> mutableLiveData;

//    constructor......................................................................................
    public UserRepository(Application application) {
        this.application = application;
    }


    public MutableLiveData<User[]> getUserData(){

        if (mutableLiveData == null){
            mutableLiveData = new MutableLiveData<>();
        }

        final String url = "https://api.github.com/users";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        users = gson.fromJson(response, User[].class);
                        mutableLiveData.setValue(users);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(application, ""+error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(application);
        requestQueue.add(stringRequest);

        return mutableLiveData;


    }

}
