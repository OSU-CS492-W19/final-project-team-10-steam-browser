package com.example.haolin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    ImageView user_info;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_info = findViewById(R.id.user_info);

        // you should add this if you want to click the ImageView
        user_info.setClickable(true);

        user_info.setOnClickListener(this);

        // the text displayed on nine button
        ArrayList<String> data = new ArrayList<String>();
        for (int i = 1; i < 10; i++) {
            data.add("Genre" + i);
        }

        recyclerView = findViewById(R.id.recyclerView);

        // set Adapter of RecyclerView
        MyAdapter adapter = new MyAdapter(this, data);
        recyclerView.setAdapter(adapter);

        // setting grid layout with three columns
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        // set the spacing between buttons
        recyclerView.addItemDecoration(new SpaceItemDecoration(30));

        // set user interactions of RecyclerView
        ItemTouchHelper.Callback callback = new MyItemTouchHelper(data, adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onClick(View view) {
        if(view == user_info){
            // jump to UserInfo Activity
            Intent intent = new Intent(this, UserInfo.class);
            startActivity(intent);
        }
    }
}