package com.example.bakirhisab;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText name_input, amount_input, comment_input, date_input;
    Button update_button, delete_button;

    String id, name, amount, comment, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name_input = findViewById(R.id.name_input2);
        amount_input = findViewById(R.id.amount_input2);
        comment_input = findViewById(R.id.comment_input2);
        date_input = findViewById(R.id.date_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                name = name_input.getText().toString().trim();
                amount = amount_input.getText().toString().trim();
                comment = comment_input.getText().toString().trim();
                date = date_input.getText().toString().trim();
                myDB.updateData(id, name, amount, comment, date);
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
//        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
//                getIntent().hasExtra("amount") && getIntent().hasExtra("comment") && getIntent().hasExtra("date")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            amount = getIntent().getStringExtra("amount");
            comment = getIntent().getStringExtra("comment");
            date = getIntent().getStringExtra("date");

            //Setting Intent Data
            name_input.setText(name);
            amount_input.setText(amount);
            comment_input.setText(comment);
            date_input.setText(date);
//            Log.d("stev", name+" "+amount+" "+comment+" "+date);
        }
//        else{
//            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
//        }
//    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + " ?");
        builder.setMessage("Are you sure you want to delete " + name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
