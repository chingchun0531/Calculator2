package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculate extends AppCompatActivity {
TextView user;
public static StringBuilder equation;//顯示運算式(儲存字元串)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        equation=new StringBuilder();
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        user = findViewById(R.id.user);
        user.setText("歡迎 "+name+" 使用");
        Button zero = findViewById(R.id.zero);
        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);

        Button plus = findViewById(R.id.plus);
        Button minus = findViewById(R.id.minus);
        Button multi = findViewById(R.id.multiply);
        Button divide = findViewById(R.id.divide);
        Button C = findViewById(R.id.C);
        Button ce = findViewById(R.id.CE);
        Button point = findViewById(R.id.point);
        Button equals = findViewById(R.id.equals);
        EditText total = findViewById(R.id.total);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(equation.toString().equals("0"))){
                        equation.append("0");//append:將char參數的字符串表示形式附加到給定序列
                    // char參數附加到此StringBuilder序列的內容之後
                        total.setText(equation);
                }

            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    equation.append("1");
                    total.setText(equation);

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    equation.append("2");
                    total.setText(equation);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    equation.append("3");
                    total.setText(equation);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    equation.append("4");
                    total.setText(equation);

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    equation.append("5");
                    total.setText(equation);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    equation.append("6");
                    total.setText(equation);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    equation.append("7");
                    total.setText(equation);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    equation.append("8");
                    total.setText(equation);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    equation.append("9");
                    total.setText(equation);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("+");
                total.setText(equation);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("-");
                total.setText(equation);
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("*");
                total.setText(equation);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append("/");
                total.setText(equation);
            }
        });
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(String.valueOf(equation));
                int a = 1;//儲存乘階的值
                for(int i = 1;i <= n;i++) {
                    a *= i;
                }
                total.setText(Integer.toString(a));
            }
        });
        ce.setOnClickListener(new View.OnClickListener() {//清除
            @Override
            public void onClick(View view) {
                equation.delete(0,equation.length());
                total.setText("");
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equation.append(".");
                total.setText(equation);
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sb = equation.toString();//stringbuilder轉字串
                for(int i=0;i<sb.length();i++){
                    char b;//符號
                    int x;
                    x=i;
                    b=sb.charAt(i);
                    if(b=='+'||b=='-'||b=='*'||b=='/'){
                        i++;
                    String s1 = sb.substring(0,x);
                    String s2 = sb.substring(x+1,sb.length());
                    double ss1 = Integer.parseInt(s1);
                    double ss2 = Integer.parseInt(s2);
                    double sum;

                    switch(b) {
                        case '+': {
                            sum = ss1 + ss2;
                            total.setText(Double.toString(sum));
                            break;
                        }
                        case '-': {
                            sum = ss1 - ss2;
                            total.setText(Double.toString(sum));
                            break;
                        }
                        case '*': {
                            sum = ss1 * ss2;
                            total.setText(Double.toString(sum));
                            break;
                        }
                        case '/': {
                            sum = ss1 / ss2;
                            total.setText(Double.toString(sum));
                            break;
                        }
                    }
                    
                    }

                }

            }
        });

    }

}