package com.example.flousi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.flousi.MainActivity.db;
import static com.example.flousi.MainActivity.getAppFirstInstallTime;
import static com.example.flousi.MainActivity.getDate;

public class Main3Activity extends AppCompatActivity {

    Long date ;
    TextView text;
    TextView date1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        text =findViewById(R.id.Total);
        text.setText(Float.toString(db.total()));
        date= getAppFirstInstallTime(this);
        String DMY = getDate(date, "dd/MM/yyyy");
        date1=findViewById(R.id.date);
        date1.setText(DMY);


    }

   // @Override
    //public void onResume(){
       // super.onResume();
        //text.setText(Float.toString(db.total()));
    //}
}