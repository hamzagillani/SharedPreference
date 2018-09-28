package com.digicon_valley.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText v_food,v_shopping,v_fuel,v_mobile;
    Button v_cal;
    TextView v_expense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v_food=findViewById(R.id.id_editText_food);
        v_shopping=findViewById(R.id.id_editText_shooping);
        v_fuel=findViewById(R.id.id_editText_fuel);
        v_mobile=findViewById(R.id.id_editText_mobile);
        v_expense=findViewById(R.id.id_textV_expense);
        v_cal=findViewById(R.id.id_btn_cal);


        sharedPreferences=getSharedPreferences("EXPENSE",Context.MODE_PRIVATE);
        v_expense.setText(String.valueOf(sharedPreferences.getInt("EXP",0)));


        v_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int cal = Integer.valueOf(v_food.getText().toString()) +
                        Integer.valueOf(v_shopping.getText().toString()) +
                        Integer.valueOf(v_mobile.getText().toString()) +
                        Integer.valueOf(v_fuel.getText().toString());


                Toast.makeText(MainActivity.this, "Your Total Expense is :" + String.valueOf(cal), Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("EXP", +cal).apply();

                v_expense.setText("Your Expense "+cal);


            }
        });
    }
}
