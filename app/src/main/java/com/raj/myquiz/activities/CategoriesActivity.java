package com.raj.myquiz.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.raj.myquiz.R;
import com.raj.myquiz.adapters.SimpleAdapter;

/*
* Example of simple list view
* */
public class CategoriesActivity extends AppCompatActivity {

    String[] cat = {"Java", "PHP", "Python", "C", "C++"};

    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        initView();


    }

    void initView() {
        lv1 = findViewById(R.id.lv1);

        //for setting listview with default adapter
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cat);

        SimpleAdapter adapter = new SimpleAdapter(this, cat);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                showMessage("You selected :" + cat[index]);
            }
        });
    }

    void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}