package com.eliprojects.curpgenerator;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    TextInputLayout lastName1;
    TextInputLayout lastName2;
    TextInputLayout userName;
    Spinner userSex;
    Spinner day;
    Spinner month;
    Spinner year;
    Spinner countrystate;
    Button submitCurpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lastName1 = (TextInputLayout)findViewById(R.id.lastName1Text);
        lastName2 = (TextInputLayout)findViewById(R.id.lastName2Text);
        userName = (TextInputLayout)findViewById(R.id.NameText);
        day = (Spinner)findViewById(R.id.daySpinner);
        month = (Spinner)findViewById(R.id.monthSpinner);
        year = (Spinner)findViewById(R.id.yearSpinner);
        userSex = (Spinner)findViewById(R.id.usersexSpinner);
        countrystate = (Spinner)findViewById(R.id.stateSpinner);
        submitCurpBtn = (Button)findViewById(R.id.button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void goDisplayCurp(View v){
        Curp curp = new Curp(lastName1.getEditText().getText().toString(), lastName2.getEditText().getText().toString(), userName.getEditText().getText().toString(),
                userSex.getSelectedItem().toString(), Integer.parseInt(day.getSelectedItem().toString()),
                month.getSelectedItem().toString(), Integer.parseInt(year.getSelectedItem().toString()), countrystate.getSelectedItem().toString());

        Intent intent = new Intent(getBaseContext(), DisplayActivity.class);

        intent.putExtra("curp", curp);

        startActivity(intent);
    }
}
