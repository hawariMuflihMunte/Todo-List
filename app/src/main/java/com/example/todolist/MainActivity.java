package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Button sayHelloButton;
    private TextView sayHelloTextView;

    private void checkFingerprint() {
        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
            Log.i("FEATURE", "Fingerprint mode is available");
        } else {
            Log.w("FEATURE", "Fingerprint mode is not available");
        }
    }

    private void initComponents() {
        nameEditText = findViewById(R.id.nameEditText);
        sayHelloButton = findViewById(R.id.sayHelloButton);
        sayHelloTextView = findViewById(R.id.sayHelloTextView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world);

        initComponents();

        Resources r = getResources();

        sayHelloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                sayHelloTextView.setText(getResources().getString(R.string.result_say_hello, name));

                Log.i("sayHelloButton", "Clicked with name: " + name);

                String[] strArr = r.getStringArray(R.array.str_arr);

                for (String item : strArr) {
                    Log.i("String Array: ", item);
                }

                Log.i("Color", String.valueOf(getResources().getColor(R.color.background)));
                Log.i("MaxPaging", String.valueOf(getResources().getInteger(R.integer.maxPaging)));
                Log.i("Numbers Value", Arrays.toString(getResources().getIntArray(R.array.numbers)));

                sayHelloButton.setBackgroundColor(getResources().getColor(R.color.background));

                try {
                    InputStream inputStream = getResources().openRawResource(R.raw.sample);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                    StringBuilder stringBuilder = new StringBuilder();
                    String line;

                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }

                    String jsonValue = stringBuilder.toString();

                    Log.i("sample.json: ", jsonValue);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                checkFingerprint();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
