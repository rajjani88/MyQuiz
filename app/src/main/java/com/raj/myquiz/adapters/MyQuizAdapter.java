package com.raj.myquiz.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.raj.myquiz.R;
import com.raj.myquiz.model.CategoryModel;

import java.util.ArrayList;

/*
 * For recycler view adapter
 * */
public class MyQuizAdapter extends RecyclerView.Adapter<MyQuizAdapter.MyViewHolder> {

    Context context;
    ArrayList<CategoryModel> items;

    public MyQuizAdapter(Context context, ArrayList<CategoryModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.category_list_item, parent, false);
        // MyViewHolder holde  = new MyViewHolder(v);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CategoryModel c = items.get(position);
        holder.title.setText(c.getTitle());
        holder.details.setText(c.getDetails());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage("You Clicked :" + c.getTitle());
            }
        });

    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView details;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tvCatItem);
            details = itemView.findViewById(R.id.tvDetails);

        }
    }

    void showMessage(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
