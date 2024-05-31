package com.example.luckynumberapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LuckyNumberActivity extends AppCompatActivity {

    private TextView luckyNumberText;
    private TextView numberDisplay;
    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        luckyNumberText = findViewById(R.id.luckyNumberText);
        numberDisplay = findViewById(R.id.numberDisplay);
        shareButton = findViewById(R.id.shareButton);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("USER_NAME");
        int luckyNumber = intent.getIntExtra("LUCKY_NUMBER", 0);

        luckyNumberText.setText(userName + "'s Lucky Number");
        numberDisplay.setText(String.valueOf(luckyNumber));

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String shareText = userName + "'s lucky number is " + luckyNumber;
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                startActivity(Intent.createChooser(shareIntent, "Share your lucky number using"));
            }
        });
    }
}
