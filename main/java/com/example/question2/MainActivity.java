package com.example.question2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // X + Y = Z
    private String X_String = "";

    private String Y_String = "";

    private double Z = 0;

    // Data that show to user
    private String TextX = "";
    private String TextY = "";

    // Data That save +-*/
    private String process = "";

    public void button_click(View input){
        String btn_Id = input.getResources().getResourceEntryName(input.getId());
        // Data that show which button user click
        String btn_process = "";
        if (X_String.isEmpty()) {
            switch (btn_Id) {
                case "one_btn":
                    btn_process = "1";
                    break;
                case "two_btn":
                    btn_process = "2";
                    break;
                case "three_btn":
                    btn_process = "3";
                    break;
                case "four_btn":
                    btn_process = "4";
                    break;
                case "five_btn":
                    btn_process = "5";
                    break;
                case "six_btn":
                    btn_process = "6";
                    break;
                case "seven_btn":
                    btn_process = "7";
                    break;
                case "eight_btn":
                    btn_process = "8";
                    break;
                case "nine_btn":
                    btn_process = "9";
                    break;
                case "zero_btn":
                    if (!TextX.isEmpty() && !TextX.equals("-")) {
                        btn_process = "0";
                    }
                    break;
                case "dot_btn":
                case "dot2_btn":
                    if (TextX.isEmpty()) {
                        btn_process = "0.";
                    } else if (!TextX.contains(".")) {
                        btn_process = ".";
                    }
                    break;
                case "clear_btn":
                    TextX = "";
                    X_String = "";
                    Y_String = "";
                    process = "";
                    TextY = "";
                    Z = 0;
                    break;
                case "back_btn":
                    if (!TextX.isEmpty() && !TextX.equals("0.")) {
                        TextX = TextX.substring(0, TextX.length() - 1);
                    } else if (TextX.equals("0.")) {
                        TextX = "";
                    }
                    break;
                case "plus_btn":
                    if (!TextX.isEmpty()) {
                        X_String = TextX;
                        process = "+";
                    }
                    break;
                case "minus_btn":
                    if (!TextX.isEmpty() && !TextX.equals("-")) {
                        X_String = TextX;
                        process = "-";
                    } else if (TextX.isEmpty()) {
                        btn_process = "-";
                    }
                    break;
                case "times_btn":
                    if (!TextX.isEmpty()) {
                        X_String = TextX;
                        process = "*";
                    }
                    break;
                case "divide_btn":
                    if (!TextX.isEmpty()) {
                        X_String = TextX;
                        process = "/";
                    }
                    break;
                case "equal_btn":                            // equal BTN
                    if (!TextX.isEmpty()){
                        X_String = TextX;
                        Z = Double.parseDouble(X_String);
                        break;
                    }
            }

            TextX += btn_process;

        }else if (Y_String.isEmpty()) {
            switch (btn_Id) {
                case "one_btn":
                    btn_process = "1";
                    break;
                case "two_btn":
                    btn_process = "2";
                    break;
                case "three_btn":
                    btn_process = "3";
                    break;
                case "four_btn":
                    btn_process = "4";
                    break;
                case "five_btn":
                    btn_process = "5";
                    break;
                case "six_btn":
                    btn_process = "6";
                    break;
                case "seven_btn":
                    btn_process = "7";
                    break;
                case "eight_btn":
                    btn_process = "8";
                    break;
                case "nine_btn":
                    btn_process = "9";
                    break;
                case "zero_btn":
                    if (!TextY.isEmpty() && !TextY.equals("-")) {
                        btn_process = "0";
                    }
                    break;
                case "dot_btn":
                case "dot2_btn":
                    if (TextY.isEmpty()) {
                        btn_process = "0.";
                    } else if (!TextY.contains(".")) {
                        btn_process = ".";
                    }
                    break;
                case "clear_btn":
                    TextX = "";
                    X_String = "";
                    Y_String = "";
                    process = "";
                    TextY = "";
                    Z = 0;
                    break;
                case "back_btn":
                    if (!TextY.isEmpty() && !TextY.equals("0.")) {
                        TextY = TextY.substring(0, TextY.length() - 1);
                    } else if (TextY.equals("0.")) {
                        TextY = "";
                    } else {
                        process = "";
                        X_String = "";
                    }
                    break;
                case "plus_btn":
                case "minus_btn":
                case "times_btn":
                case "divide_btn":
                    break;
                case "equal_btn":                            // equal BTN
                    if (!TextY.isEmpty() && !TextY.equals("-")) {
                        Y_String = TextY;
                        switch (process){
                            case "+":
                                Z = Double.parseDouble(X_String) + Double.parseDouble(Y_String);
                                break;
                            case "-":
                                Z = Double.parseDouble(X_String) - Double.parseDouble(Y_String);
                                break;
                            case "*":
                                Z = Double.parseDouble(X_String) * Double.parseDouble(Y_String);
                                break;
                            case "/":
                                Z = Double.parseDouble(X_String) / Double.parseDouble(Y_String);
                                break;
                        }
                    }
                    break;
            }

            TextY += btn_process;
        }

        // Show X and Y in calculator
        TextView Output_button = findViewById(R.id.button_output);
        // Data That show X and Y and the process
        String Final_Output;
        if (Z != 0) {
            // Set intent
            Intent intent = new Intent(this, Main2Activity.class);

            // Send through Intent system
            intent.putExtra("Z", Z);

            // Run Intent
            startActivity(intent);

            Final_Output = "";
        } else {
            Final_Output = TextX + process + TextY;
            if (Final_Output.isEmpty() || Final_Output.contains("请输入计算结")){
                Final_Output = "请输入计算结果";
            }
        }

        Output_button.setText(Final_Output);



    }
}