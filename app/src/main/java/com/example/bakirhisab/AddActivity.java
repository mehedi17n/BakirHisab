package com.example.bakirhisab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    EditText name_input, amount_input, comment_input, date_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name_input = findViewById(R.id.name_input);
        amount_input = findViewById(R.id.amount_input);
        comment_input = findViewById(R.id.comment_input);
        date_input = findViewById(R.id.date_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addRecord(name_input.getText().toString().trim(),
                        amount_input.getText().toString().trim(),
                        comment_input.getText().toString().trim(),
                        date_input.getText().toString().trim());
            }
        });
    }
}
