package com.example.hd1app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hd1app.Models.Deal;

import java.util.ArrayList;

public class MoreDealsActivity extends AppCompatActivity {
    TextView topText;
    ArrayList<Deal> fashionDeals;
    ArrayList<Deal> electronicsDeals;
    ArrayList<Deal> foodDeals;
    RecyclerView recyclerView;
    ImageView coverImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_deals);
        coverImg = findViewById(R.id.cover_image);
        topText = findViewById(R.id.top_text);
        recyclerView = findViewById(R.id.more_deals_recycler);
        Intent intent = getIntent();
        topText.setText(intent.getStringExtra("category_title"));
        fashionDeals = HomePage.fashionDeals;
        foodDeals = HomePage.foodDeals;
        electronicsDeals = HomePage.electronicsDeals;
        initRecyclerView(intent);



    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
    }

    public void fillRecyclerDealList(ArrayList<Deal> dealList, RecyclerView recyclerView){
        CustomAdapter adapter = new CustomAdapter(this, dealList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, 20, false));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public void initRecyclerView(Intent intent){
        if(intent.getStringExtra("category_title").equals("Fashion")){
            fillRecyclerDealList(fashionDeals, recyclerView);
            coverImg.setImageResource(R.drawable.topshopcover);
        }else if (intent.getStringExtra("category_title").equals("Electronics")){
            fillRecyclerDealList(electronicsDeals, recyclerView);
            coverImg.setImageResource(R.drawable.applecover);
        }else if (intent.getStringExtra("category_title").equals("Food & Drink")){
            fillRecyclerDealList(foodDeals, recyclerView);
            coverImg.setImageResource(R.drawable.coverimg);
        }
        else if (intent.getStringExtra("category_title").equals("Travel")){
//            fillRecyclerDealList(foodDeals, recyclerView);
//            coverImg.setImageResource(R.drawable.coverimg);
        }else if (intent.getStringExtra("category_title").equals("Entertainment")){
            //fillRecyclerDealList(foodDeals, recyclerView);
            //coverImg.setImageResource(R.drawable.coverimg);
        }else if (intent.getStringExtra("category_title").equals("Education")){
            //fillRecyclerDealList(foodDeals, recyclerView);
            //coverImg.setImageResource(R.drawable.coverimg);
        }
    }
}
