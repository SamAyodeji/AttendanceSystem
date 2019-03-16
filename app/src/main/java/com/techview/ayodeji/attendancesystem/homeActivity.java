package com.techview.ayodeji.attendancesystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homeActivity extends Activity {

    private Button scan;
    private Button print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        print = (Button) findViewById(R.id.printbtn);
        scan = (Button)findViewById(R.id.scanbtn);
        scan.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick (View v){
                openscanactivity();
            }
        });
    }

        public  void openscanactivity() {
            Intent intent = new Intent(this, ScanActivity.class);
            startActivity(intent);
        }
}
