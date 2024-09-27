package com.example.question2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        Double output = intent.getDoubleExtra("Z", 0.0);

        // Set Output TextView
        TextView textView = findViewById(R.id.show_data);

        String outputString;

        int OutputFormat = (int) Math.floor(output);

        // Based on the answer is double or int
        if (output != OutputFormat) {
            outputString = String.valueOf(output);
        } else {
            outputString = String.valueOf(OutputFormat);
        }

        textView.setText(outputString);
    }
}