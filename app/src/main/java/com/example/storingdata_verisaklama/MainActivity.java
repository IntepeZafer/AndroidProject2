package com.example.storingdata_verisaklama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText editTextTextPersonName;
    EditText editTextNumber;
    TextView textView;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ///////////////////////////////////////
        sharedPreferences = this.getSharedPreferences("com.example.storingdata_verisaklama" , Context.MODE_PRIVATE);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextNumber = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        ///////////////////////////////////////
        String name = sharedPreferences.getString("strogeName" , "");
        String age =  sharedPreferences.getString("strogeAge" , "");
        if(name != "" || age != ""){
            textView.setText("Enter Name: " + name);
            textView2.setText("Enter Birthday: " + age);
        }
    }
    public void save(View view){
        if(!editTextTextPersonName.getText().toString().matches("") || !editTextNumber.getText().toString().matches("")){
            textView.setText("Name: " + editTextTextPersonName.getText());
            textView2.setText("Age: " + editTextNumber.getText());
            String name = editTextTextPersonName.getText().toString();
            String age = editTextNumber.getText().toString();
            sharedPreferences.edit().putString("strogeName" , name).apply();
            sharedPreferences.edit().putString("strogeAge" , age).apply();
        }
    }
    public void delete(View view){
        String strogeName = sharedPreferences.getString("strogeName" , "");
        String strogeAge = sharedPreferences.getString("strogeAge" , "");
        if(strogeName != "" || strogeAge != ""){
            sharedPreferences.edit().remove("strogeName").apply();
            sharedPreferences.edit().remove("strogeAge").apply();
            textView.setText("Enter Name: ");
            textView2.setText("Enter Age: ");
        }
    }
}