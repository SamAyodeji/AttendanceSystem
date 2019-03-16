package com.techview.ayodeji.attendancesystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class loginActivity extends Activity {

    private EditText Name;
    private  EditText password;
    private TextView Info;
    private Button Login;
    private Button Reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.reginfo);
        Login = (Button)findViewById(R.id.btnLogin);
        Reg = (Button)findViewById(R.id.btnReg);
       Reg.setOnClickListener(new View.OnClickListener(){
           @Override
           public  void  onClick (View v){
               openregActivity();
           }
       });
    }
            public void  openregActivity(){
                Intent intent = new Intent(this, registerActivity.class);
                startActivity(intent);
            }
}
