package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    List<String> toDo;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toDo = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this,R.layout.listviewlayout,toDo);
        listView = findViewById(R.id.list_view);

        listView.setAdapter(arrayAdapter);
        editText = findViewById(R.id.edittext);

    }
    public void addItemToList(View view){
        if(editText.getText().equals(null) || editText.getText().toString().equals("")) {
            Toast.makeText(this, "Type Something First", (int) 0.4).show();
        }
        else
        {
            toDo.add(editText.getText().toString());
            String theText = editText.getText().toString();
            arrayAdapter.notifyDataSetChanged();
            Toast.makeText(this, theText.concat("  Added"), (int) 0.4).show();
            editText.setText("");
        }
    }

    @Override
    public void onClick(View v) { }
}
