package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button start;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        start= findViewById(R.id.button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edittext = name.getText().toString().trim();
                if(name.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this,"請輸入名字!",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, Calculate.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", edittext);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    MainActivity.this.finish();

                }

            }
        });
    }
}