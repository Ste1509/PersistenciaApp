package com.example.registration;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private EditText edtName,edtSalary,edtPercentage;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<String>();
        readSharedPreferences();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        edtName = (EditText)findViewById(R.id.edtName);
        edtSalary = (EditText)findViewById(R.id.edtSalary);
        edtPercentage = (EditText)findViewById(R.id.edtPercentega);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(adapterView.getContext(),Operation.class);
                intent.putExtra("salary", edtSalary.getText().toString());
                startActivity(intent);
                return false;
            }
        });
    }
    public void save(View view){
        arrayList.add(edtName.getText().toString()+" , "+ edtSalary.getText().toString()+" , "+ edtPercentage.getText().toString());
        adapter.notifyDataSetChanged();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(edtName.getText().toString(),edtSalary.getText().toString());
        editor.commit();
        edtName.setText("");
        edtSalary.setText("");
        edtPercentage.setText("");
    }

    private void readSharedPreferences() {
        preferences = getSharedPreferences("dataemployees", Context.MODE_PRIVATE);
        Map<String,?> keys = preferences.getAll();
        for(Map.Entry<String,?> ele : keys.entrySet()){
            arrayList.add(ele.getKey()+" : " +ele.getValue().toString());
        }
    }
}