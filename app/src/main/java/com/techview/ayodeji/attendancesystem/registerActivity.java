package com.techview.ayodeji.attendancesystem;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class registerActivity extends AppCompatActivity {

    //DatabaseHelper mDatabaseHelper;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
     EditText fullname, staffID,Department, Spassword;
     Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        openHelper= new DatabaseHelper(this);

        fullname = (EditText)findViewById(R.id.fname);
        staffID = (EditText)findViewById(R.id.staffId);
        Department = (EditText)findViewById(R.id.Sdepartment);
        Spassword = (EditText)findViewById(R.id.SPassword);

        register = (Button)findViewById(R.id.reg);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db= openHelper.getWritableDatabase();
                String fname = fullname.getText().toString();
                String staff = staffID.getText().toString();
                String dp = Department.getText().toString();
                String pass = Spassword.getText().toString();
                insertdata(fname,staff,dp,pass);
                //Toast.makeText(getApplicationContext(), "register successfully",Toast.LENGTH_LONG).show();

            }
        });
        //openHelper = new DataBaseHelper(this);
        //mDatabaseHelper = new DatabaseHelper(this);
    }
    public void  insertdata(String fname,String staff,String dp,String pass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL2, fname);
        contentValues.put(DatabaseHelper.COL3, staff);
        contentValues.put(DatabaseHelper.COL4, dp);
        contentValues.put(DatabaseHelper.COL5, pass);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
        if(id<=0)
        {

            Toast.makeText(getApplicationContext(), "register successfully",Toast.LENGTH_LONG).show();
            //Message.message(getApplicationContext(),"Insertion Unsuccessful");
            //fullname.setText();
            //staffID.setText();
        } else
        {
            Toast.makeText(getApplicationContext(), "register unsuccessfully",Toast.LENGTH_LONG).show();
           // Message.message(getApplicationContext(),"Insertion Successful");
            //Name.setText("");
            //Pass.setText("");
        }
    }
}
