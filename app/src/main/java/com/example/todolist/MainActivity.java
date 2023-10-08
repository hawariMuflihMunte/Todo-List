package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set padding for home_page_wrapper
        View homePageWrapper = findViewById(R.id.home_page_wrapper);
        homePageWrapper.setPadding(26, 26, 26, 26);
    }
}