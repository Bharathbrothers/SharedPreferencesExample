package com.starks.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView,textview2;
    EditText editText,editText2;
    Switch simpleswitch;
    Button newB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView  = (TextView) findViewById(R.id.textView);
        textview2 = (TextView)findViewById(R.id.textView2);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        newB = (Button)findViewById(R.id.button3);

         simpleswitch = (Switch)findViewById(R.id.switch1);

        simpleswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                setPage(b);
       }
        });

           SharedPreferences sharedPreferences =getPreferences(Context.MODE_PRIVATE);
            Boolean s1 = sharedPreferences.getBoolean("changed color",false);
            simpleswitch.setChecked(s1);
        newB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(it);
            }
        });

    }

    private void setPage(boolean b) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("changed color",b);
        editor.apply();
        simpleswitch.setText(b ? "green" : "blue");
    }

    public void savedata(View view) {

        SharedPreferences sharedPreferences = (SharedPreferences) getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name",editText.getText().toString());
        editor.putString("password",editText2.getText().toString());
        editor.apply();
     }

    public void loaddata(View view) {

        SharedPreferences sharedPreferences =(SharedPreferences)getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String name = sharedPreferences.getString("name","NA");
        String pass = sharedPreferences.getString("password","Na");
        textView.setText("name is :"+name.toString());
        textview2.setText("password is :"+pass.toString());
    }
}
