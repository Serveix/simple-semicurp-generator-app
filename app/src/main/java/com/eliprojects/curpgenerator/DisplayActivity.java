package com.eliprojects.curpgenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView mName;
    TextView mUsersex;
    TextView mDate;
    TextView mState;
    TextView mCurp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        mName    = (TextView)findViewById(R.id.wholename);
        mUsersex = (TextView)findViewById(R.id.usersex);
        mDate    = (TextView)findViewById(R.id.date);
        mState   = (TextView)findViewById(R.id.state);
        mCurp    = (TextView)findViewById(R.id.curp);

        Curp curp = getIntent().getParcelableExtra("curp");

        if(curp != null)
        {
            mName.setText("Nombres: " + curp.userName + " " + curp.lastName1 + " " + curp.lastName2);
            mUsersex.setText("Sexo: " + curp.sex);
            mDate.setText("Fecha de nacimiento: " + curp.day + "/" + curp.month + "/" + curp.year);
            mState.setText("Sexo: " + curp.state);

            String n = Character.toString(curp.userName.charAt(0));

            String ap = Character.toString(curp.lastName1.charAt(0)) + Character.toString(curp.lastName1.charAt(1));

            String  am = Character.toString(curp.lastName2.charAt(0));

            String[] estadoArr = curp.state.split(" ");
            String ef = "";
            for (int i = 0; i < estadoArr.length; i++) {
                String s = estadoArr[i];
                ef += Character.toString(s.charAt(0));
            }

            String s = Character.toString(curp.sex.charAt(0));
            String month = curp.month;
            if(Integer.parseInt(curp.month) < 9)
                month = 0 + curp.month;

            String day = Integer.toString(curp.day);

            if(curp.day < 9)
                day = 0 + Integer.toString(curp.day);

            String printable = ap + am + n + (curp.year + "" + month + "" + day) + s + ef;

            mCurp.setText("CURP: " + printable.toUpperCase());

        }

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



}
