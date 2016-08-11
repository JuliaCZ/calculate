package com.example.julia.calculate2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);



        setTitle("Calculator");

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost2);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tag1");

        tabSpec.setContent(R.id.linearLayout5);
        tabSpec.setIndicator("Palindrome");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setContent(R.id.linearLayout6);
        tabSpec.setIndicator("Factorial");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        tabSpec.setContent(R.id.linearLayout4);
        tabSpec.setIndicator("Pairs");
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);
    }

    public void Calculate_Palindrome(View v)//l_l5
    {
        EditText number1 = (EditText) findViewById(R.id.editText7);
        TextView textView12 = (TextView) findViewById(R.id.textView12);
        char[] number = number1.getText().toString().toCharArray();
        boolean flag = false;
        for (int number_i = 0; number_i < number.length / 2; number_i++)//цикл по текущему числу
        {
            //взять первый символ и сравнить с последним
            //второй с предпоследним и т.д
            if (number[number_i] == number[number.length - 1 - number_i]) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if (flag)
        {
            textView12.setText("Palindrome");
        } else {
            textView12.setText("Not palindrome");
        }
    }
    private double Factorial(int n)
    {
        //1. Найти факториал числа
        double result = 1;
        for(int i = 1; i <= n; i++)
        {
            result *= i;
        }
        //System.out.println("Factrial 100! = " + result);
        return result;
    }
    public void Calculate_Factorial(View v)
    {
        EditText factorial = (EditText)findViewById(R.id.editText8);
        TextView textView14 = (TextView) findViewById(R.id.textView14);
        if(Integer.valueOf(factorial.getText().toString()) < 101 &&
                Integer.valueOf(factorial.getText().toString()) > 0) {
            Double result = Factorial(Integer.valueOf(factorial.getText().toString()));
            int sum = 0;
            //Нахождение суммы
            while (result > 0) {
                double del = 0;
                del = result % 10.0;
                result = result / 10.0;
                sum += del;
            }
            textView14.setText(String.valueOf(sum));
        }
        else
        {
            textView14.setText(String.valueOf("Введите число в диапазоне [1 - 100]"));
        }
    }
    public void Calculate_Pairs(View v)//l_l4
    {
        TextView textView10 = (TextView)findViewById(R.id.textView10);
        EditText pairs = (EditText)findViewById(R.id.editText5);
        ListCollection<Integer, Integer> list = new ListCollection<Integer, Integer>();
        ListCollection<Integer, Integer> result = new ListCollection<Integer, Integer>();
        String[] line = pairs.getText().toString().split(" ");
        if(line.length == 1)
        {
            textView10.setText(line[0]);
        }
        else {
            for (int i = 0; i < line.length; i++) {
                if (line[i].length() == 2) {
                    int c = Integer.valueOf(line[i]);
                    int s = c % 10;
                    c = c / 10;
                    int f = c % 10;
                    list.Add(f, s);
                }
            }
            if (list.SizeAll() == 2) {
                textView10.setText(line[0]);
            } else {
                for (int i = 0; i < list.Size() - 1; i++) {
                    if (list.getFirst(i) < list.getSecond(i) &&
                            list.getFirst(i + 1) > list.getSecond(i + 1)) {
                        if (result.Size() == 0) {
                            result.Add(list.getFirst(i), list.getSecond(i));
                            result.Add(list.getFirst(i + 1), list.getSecond(i + 1));
                        } else {
                            ListCollection<Integer, Integer> tmp = new ListCollection<Integer, Integer>();
                            tmp.Add(list.getFirst(i), list.getSecond(i));
                            tmp.Add(list.getFirst(i + 1), list.getSecond(i + 1));
                            if (tmp.LengthPairs() >= result.LengthPairs()) {
                                result.DeleteAll();
                                result.Add(list.getFirst(i), list.getSecond(i));
                                result.Add(list.getFirst(i + 1), list.getSecond(i + 1));
                            }
                        }
                    }
                }
                //System.out.println("RESULT = ");
                //result.Print();
                String res = "";
                for (int i = 0; i < result.Size(); i++) {
                    res += result.getFirst(i);
                    res += result.getSecond(i);
                    res += " ";
                }
                textView10.setText(res);
            }
        }
    }
}
