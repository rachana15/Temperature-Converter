package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    /* declaring the attributes*/
    private RadioButton celsius;
    private RadioButton fahrenheit;
    private EditText input;
    private TextView output;
    private TextView text1;
    private TextView text2;
    private TextView textView3;
    StringBuilder sb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.editText2);
        fahrenheit = (RadioButton) findViewById((R.id.radioButton));
        celsius = (RadioButton) findViewById(R.id.radioButton2);
        output = (TextView) findViewById(R.id.textView8);
        text1 = (TextView) findViewById(R.id.textView5);
        text2 = (TextView) findViewById(R.id.textView4);
        textView3 = findViewById(R.id.editText4);
        textView3.setMovementMethod(new ScrollingMovementMethod());
        sb = new StringBuilder();
        Button clear = (Button) findViewById(R.id.button2) ;
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("");
                output.setText("");
                textView3.setText("");
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        /* Saves the conversion History, Input and Output */
        outState.putString("TextView", textView3.getText().toString());
        outState.putString("Input", input.getText().toString());
        outState.putString("output", output.getText().toString());
        // Call super last
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        /*this function is used to restore the data back when orientation is changed */
        super.onRestoreInstanceState(savedInstanceState);

        textView3.setText(savedInstanceState.getString("TextView"));
        input.setText(savedInstanceState.getString("Input"));
        output.setText(savedInstanceState.getString("output"));
    }
    public  void  converter(double value){
        /* This function calculates the result and displays it in conversion History */
        double result;

        if(fahrenheit.isChecked()){
            result = (value - 32) / 1.8;
            output.setText(String.format("%.1f",result));
            sb.append(value + " F =>" + String.format("%.1f",result) + " C \n");
            textView3.setText(sb.toString());
        }
        else if (celsius.isChecked()){
            result = (value * 1.8) + 32;
//            conv = Double.toString(result);
            output.setText(String.format("%.1f",result));
            sb.append(value + " C =>" + String.format("%.1f",result) + " F \n");
            textView3.setText(sb.toString());

        }
//        output.setText(conv);

    }
    public void calculate(View v){
        /* when Convert Button is clicked, this function gets called which inturn calls converter function to calculate result*/
//        output.setText("hello");
        if(input.getText().length()!=0){
            double result = Double.parseDouble(input.getText().toString());
            converter(result);
        }
        else{
            Toast.makeText(this,"Enter the Degrees",Toast.LENGTH_LONG).show();
        }
    }
    public void fahrenheitText(View view){
        /* Changes the text when radio button is clicked */
        text1.setText("Fahrenheit Degrees");
        text2.setText("Celsius Degrees");
    }

    public void celsiusText(View view){
        /* changes the text when radio button is clicked */
        text1.setText("Celsius Degrees");
        text2.setText("Fahrenheit Text");
    }
}
