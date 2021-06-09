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
public static ArrayList calculate;//計算式

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        equation=new StringBuilder();
        calculate=new ArrayList<>();
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
        Button point = findViewById(R.id.point);
        Button ce = findViewById(R.id.CE);
        Button back = findViewById(R.id.back);
        Button equals = findViewById(R.id.equals);
        EditText total = findViewById(R.id.total);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(equation.toString().equals("0"))){
                        equation.append("0");//顯示運算式
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
                int a = 1;
                for(int i = 1;i <= n;i++) {
                    a *= i;
                }
                total.setText(Integer.toString(a));
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    equation.append(".");
                    total.setText(equation);
            }
        });
        ce.setOnClickListener(new View.OnClickListener() {//清除
            @Override
            public void onClick(View view) {
                equation.delete(0,equation.length());
                calculate.clear();
                total.setText("");
            }
        });
        back.setOnClickListener(new View.OnClickListener() {//倒退，在equal後點選全清除，一般輸入則後退一格
            @Override
            public void onClick(View v) {
                if(!(equation.toString().equals(""))) {
                    if(equation.equals("")){
                        equation.deleteCharAt(equation.length() - 1);
                        total.setText(equation);
                    }

                }
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(equation.charAt(0)=='-')
                    equation.insert(0,"0");
                StringBuilder sb1 =new StringBuilder();
                for(int i=0;i<equation.length();i++){
                    if(equation.charAt(i)>='0'&&equation.charAt(i)<='9'||equation.charAt(i)=='.'){
                        sb1.append(String.valueOf(equation.charAt(i)));//CharAt()返回指定的索引範圍
                    }
                    else
                    {
                        calculate.add(sb1.toString());
                        sb1.delete(0,sb1.length());
                        calculate.add(String.valueOf(equation.charAt(i)));
                    }
                }
                calculate.add(sb1.toString());
                calculate.add("#");
                String sb8=calculation(calculate);
                total.setText(sb8);
            }
        });
    }
    protected boolean Comparative(char op1,char op2){//運算優先的比較級
        int o1=0;
        int o2=0;
        switch (op1){
            case '+':{
                o1=0;
            break;
            }
            case '-':{
                o1=0;
            break;
            }
            case '*':{
                o1=1;
            break;
            }
            case '/':{
                o1=1;
                break;
            }
        }
        switch (op2){
            case '+':{
                o2=0;
                break;
            }
            case '-':{
                o2=0;
                break;
            }
            case '*':{
                o2=1;
                break;
            }
            case '/':{
                o2=1;
                break;
            }
        }
        if(o1<=o2)
        {
            return false;
        }
        else
            return true;
    }
    protected String calculation(ArrayList equation){
        Double sb2;
        Double sb3;
        Double result;
        ArrayList operator=new ArrayList();
        ArrayList operand=new ArrayList();
        for(int i=0;i<equation.size();i++)
        {
            String sb4=(String) equation.get(i);
            if(sb4.equals("+")||sb4.equals("-")||sb4.equals("*")||sb4.equals("/")||sb4.equals("!"))
            {
                if(operator.size()>0)
                {
                    String sb5=operator.get(operator.size()-1).toString();
                    while(!(Comparative(sb4.charAt(0),sb5.charAt(0)))&&operator.size()>0)
                    {
                        operator.remove(operator.size()-1);
                        sb2=(Double.parseDouble(operand.get(operand.size()-1).toString()));
                        operand.remove(operand.size()-1);
                        sb3=(Double.parseDouble(operand.get(operand.size()-1).toString()));
                        operand.remove(operand.size()-1);
                        switch (sb5.charAt(0)){
                            case '+':{
                                result = sb2+sb3;
                                operand.add(String.valueOf(result));
                            break;
                            }
                            case '-':{
                                result = sb2-sb3;
                                operand.add(String.valueOf(result));
                            break;
                            }
                            case '*':{
                                result = sb2*sb3;
                                operand.add(String.valueOf(result));
                            break;
                            }
                            case '/':{
                                result = sb2/sb3;
                                operand.add(String.valueOf(result));
                            break;
                            }

                        }
                        if(operator.size()>0)
                        {
                            sb5=operator.get(operator.size()-1).toString();
                        }
                        else
                            break;
                    }
                    operator.add(sb4);
                }
                else
                    operator.add(sb4);
            }
            else if(sb4.equals("#"))
            {
                while(operator.size()>0)
                {
                    String sb6=(String)operator.get(operator.size()-1);
                    operator.remove(operator.size()-1);
                    sb3=(Double.parseDouble(operand.get(operand.size()-1).toString()));
                    operand.remove(operand.size()-1);
                    sb2=(Double.parseDouble(operand.get(operand.size()-1).toString()));
                    operand.remove(operand.size()-1);
                    switch (sb6.charAt(0)){
                        case '+': {
                            result=sb2+sb3;
                            operand.add(String.valueOf(result));
                        break;
                        }
                        case '-':{
                            result=sb2-sb3;
                            operand.add(String.valueOf(result));
                        break;
                        }
                        case '*':{
                            result=sb2*sb3;
                            operand.add(String.valueOf(result));
                        break;
                        }
                        case '/':{
                            result=sb2/sb3;
                            operand.add(String.valueOf(result));
                        break;
                        }
                    }
                }
            }
            else
            {
                operand.add(sb4);
            }
        }
        return operand.get(0).toString();
    }
}