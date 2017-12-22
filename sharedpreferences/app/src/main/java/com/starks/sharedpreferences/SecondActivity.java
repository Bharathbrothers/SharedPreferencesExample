package com.starks.sharedpreferences;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu);
        toolbar.setSubtitle("Bharath");

    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){

           MenuInflater inflater= getMenuInflater();
            inflater.inflate(R.menu.menu,menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){

            switch (item.getItemId()){
                case R.id.first:
                    Toast.makeText(this,"First",Toast.LENGTH_LONG).show();
                    return true;
                case R.id.second:
                    Toast.makeText(this,"Second",Toast.LENGTH_LONG).show();
                    return true;
                case R.id.third:
                    Toast.makeText(this,"Third",Toast.LENGTH_LONG).show();
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }

}