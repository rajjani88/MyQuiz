package com.raj.myquiz.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.raj.myquiz.R;
import com.raj.myquiz.adapters.MyQuizAdapter;
import com.raj.myquiz.adapters.SimpleAdapter;
import com.raj.myquiz.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

/*
* Example of simple list view
* */
public class CategoriesActivity extends AppCompatActivity {

    //String[] cat = {"Java", "PHP", "Python", "C", "C++"};
    //String[] cat_details = {"new 17 ques", "20 ques", "19 ques", "C", "C++"};
   //

    ArrayList categoryItems = new ArrayList<CategoryModel>();

    //ListView lv1;
    RecyclerView rv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        categoryItems.add(new CategoryModel("Java", "become Java Expert"));
        categoryItems.add(new CategoryModel("PHP", "become PHP Expert"));
        categoryItems.add(new CategoryModel("C++", "become C++ Expert"));
        categoryItems.add(new CategoryModel("Python", "become Python Expert"));

        initView();



    }

    void initView() {
        //lv1 = findViewById(R.id.lv1);
        rv1 = findViewById(R.id.rv1);

        getCategories();
        simpleRv();


    }

    void getCategories(){

        String url = "https://quicdeal.in/api_ex/get_cat.php";
        RequestQueue requestQueue = Volley.newRequestQueue(CategoriesActivity.this);

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showLog(response);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        showLog(error.getMessage());

                    }
                }
        );


        requestQueue.add(stringRequest);

    }

    void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    void showLog(String msg) {
        Log.e("CA", "showLog: "+msg);
    }


    //recycler view
    void simpleRv(){

        MyQuizAdapter adapter = new MyQuizAdapter(this, categoryItems);

        rv1.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        rv1.setAdapter(adapter);

    }

    //function for simple list view
    void simpleListView(){
        //for setting listview with default adapter
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cat);

//        SimpleAdapter adapter = new SimpleAdapter(this, cat);
//        lv1.setAdapter(adapter);
//
//        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
//                showMessage("You selected :" + cat[index]);
//            }
//        });
    }

}