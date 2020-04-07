package com.ppal007.recyclerview_with_mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ppal007.recyclerview_with_mvvm.R;
import com.ppal007.recyclerview_with_mvvm.adapter.UserAdapter;
import com.ppal007.recyclerview_with_mvvm.model.User;
import com.ppal007.recyclerview_with_mvvm.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

//        finding xml.................................................................................
        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainActivityViewModel.getAllUserData().observe(MainActivity.this, new Observer<User[]>() {
            @Override
            public void onChanged(User[] users) {
                recyclerView.setAdapter(new UserAdapter(users));
            }
        });
    }
}
