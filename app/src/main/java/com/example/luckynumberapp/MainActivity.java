package com.example.luckynumberapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Button wishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        wishButton = findViewById(R.id.wishButton);

        wishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = nameEditText.getText().toString().trim();

                if (TextUtils.isEmpty(userName)) {
                    // Display an error message if the name is empty
                    nameEditText.setError("Please enter your name");
                    nameEditText.requestFocus();
                } else {
                    // Generate a random number and proceed to the next activity
                    int luckyNumber = new Random().nextInt(100) + 1;

                    Intent intent = new Intent(MainActivity.this, LuckyNumberActivity.class);
                    intent.putExtra("USER_NAME", userName);
                    intent.putExtra("LUCKY_NUMBER", luckyNumber);
                    startActivity(intent);
                }
            }
        });
    }
}
