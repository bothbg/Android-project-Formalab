package com.example.flousi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.flousi.MainActivity.db;

public class Main2Activity extends AppCompatActivity {


    Button b1 ;
    EditText achat ;
    EditText prix ;
    ListView liste ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        b1=findViewById(R.id.ajout);
        achat=findViewById(R.id.achat1);
        prix=findViewById(R.id.prix1);


        b1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                String achats = achat.getText().toString();
                Float prixx =Float.valueOf(prix.getText().toString());
                Expense exp = new Expense(achats, prixx);
                db.addexpense(exp);
                Toast.makeText(Main2Activity.this, " \n" +
                        "success operation ", Toast.LENGTH_SHORT).show();

            }

        });
    }
}
