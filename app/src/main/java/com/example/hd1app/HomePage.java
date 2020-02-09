package com.example.hd1app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hd1app.DealCategories.AllPossibleDeals;
import com.example.hd1app.DealCategories.NewDeals;
import com.example.hd1app.DealCategories.FeaturedDeals;
import com.example.hd1app.DealCategories.TrendingDeals;
import com.example.hd1app.Models.Deal;
import com.example.hd1app.Models.EducationDeal;
import com.example.hd1app.Models.ElectronicsDeal;
import com.example.hd1app.Models.FashionDeal;
import com.example.hd1app.Models.FoodDeal;
import com.example.hd1app.Models.TravelDeal;

import java.util.ArrayList;
import java.util.Date;

public class HomePage extends AppCompatActivity implements View.OnClickListener {
    //Spinner spinner;
    RecyclerView featuredRecyclerView;
    RecyclerView trendingRecyclerView;
    RecyclerView newRecyclerView;
    //
    FeaturedDeals featuredDeals;
    NewDeals newDeals;
    TrendingDeals trendingDeals;
    AllPossibleDeals allPossibleDeals;

    //Categories
    ArrayList<Deal> foodDeals;
    ArrayList<Deal> electronicsDeals;
    ArrayList<Deal> fashionDeals;

    LinearLayout electronicsButton;
    LinearLayout fashionButton;
    LinearLayout entertainmentButton;
    LinearLayout foodDrinkButton;
    LinearLayout travelButton;
    LinearLayout educationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //Get components
        //spinner = findViewById(R.id.choice_spinner);
        featuredRecyclerView = findViewById(R.id.featured_recycler_view);
        trendingRecyclerView = findViewById(R.id.trending_recycler_view);
        newRecyclerView = findViewById(R.id.new_recycler_view);
        electronicsButton = findViewById(R.id.electronics_button);
        fashionButton = findViewById(R.id.fashion_button);
        entertainmentButton = findViewById(R.id.entertainment_button);
        foodDrinkButton = findViewById(R.id.food_drink_button);
        travelButton = findViewById(R.id.travel_button);
        educationButton = findViewById(R.id.education_button);


        //Create objects of different deals
        featuredDeals = new FeaturedDeals();
        newDeals = new NewDeals();
        trendingDeals = new TrendingDeals();
        allPossibleDeals = new AllPossibleDeals();

        //Categories
        foodDeals = new ArrayList<>();
        electronicsDeals = new ArrayList<>();
        fashionDeals = new ArrayList<>();

        //initSpinner(spinner);

        //Deals management
        createTestDeals();
        sortDeals();

        fillRecyclerDealList(newDeals, newRecyclerView);
        //Set click listeners for the category buttons
        electronicsButton.setOnClickListener(this);
        fashionButton.setOnClickListener(this);
        entertainmentButton.setOnClickListener(this);
        travelButton.setOnClickListener(this);
        educationButton.setOnClickListener(this);
        foodDrinkButton.setOnClickListener(this);

    }
    public void fillRecyclerDealList(ArrayList<Deal> dealList, RecyclerView recyclerView){
        CustomAdapter adapter = new CustomAdapter(this, dealList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public void initSpinner(Spinner spinner){
        //Add string array to the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    /**
     * This method creates test deals
     */
    public void createTestDeals(){
        //Further we will extract it from our database
        ElectronicsDeal electronicsDeal = new ElectronicsDeal("Apple -10%", "45HHs6hgshHG", new Date(2020,2,29),10,1);
        ElectronicsDeal electronicsDeal1 = new ElectronicsDeal("Samsung -5%", "45HHs6hgshHG", new Date(2020,2,29),30,5);
        ElectronicsDeal electronicsDeal2 = new ElectronicsDeal("Something deal", "45HHs6hgshHG", new Date(2020,2,29),50,10);
        allPossibleDeals.add(electronicsDeal);
        allPossibleDeals.add(electronicsDeal1);
        allPossibleDeals.add(electronicsDeal2);

        FashionDeal fashionDeal = new FashionDeal("Next -10%", "45HHs6hgshHG", new Date(2020,2,29),100,10);
        FashionDeal fashionDeal1 = new FashionDeal("Adidas -10%", "45HHs6hgshHG", new Date(2020,2,29),50,20);
        FashionDeal fashionDeal2 = new FashionDeal("Nike -10%", "45HHs6hgshHG", new Date(2020,2,29),10,1);
        allPossibleDeals.add(fashionDeal);
        allPossibleDeals.add(fashionDeal1);
        allPossibleDeals.add(fashionDeal2);

        FoodDeal foodDeal = new FoodDeal("KFC deal", "45HHs6hgshHG", new Date(2020,2,29),240,100);
        FoodDeal foodDeal1 = new FoodDeal("McDonalds offer", "45HHs6hgshHG", new Date(2020,2,29),430,200);
        FoodDeal foodDeal2 = new FoodDeal("Subway deal", "45HHs6hgshHG", new Date(2020,2,29),1000,5);
        allPossibleDeals.add(foodDeal);
        allPossibleDeals.add(foodDeal1);
        allPossibleDeals.add(foodDeal2);


        EducationDeal educationDeal = new EducationDeal("Deal 15% off", "45HHs6hgshHG", new Date(2020,2,29),50,50);
        EducationDeal educationDeal1 = new EducationDeal("Blabla membership", "45HHs6hgshHG", new Date(2020,2,29),100,25);
        EducationDeal educationDeal2 = new EducationDeal("HelloWorld -50%", "45HHs6hgshHG", new Date(2020,2,29),500,50);
        allPossibleDeals.add(educationDeal);
        allPossibleDeals.add(educationDeal1);
        allPossibleDeals.add(educationDeal2);
    }

    /**
     * This method sorts the deals by categories and status of the deals.
     * This may be changed in the future, because it is very basic sorting.
     *
     * Key issues:
     *
     * Can they repeat in different categories? (for instance, same deal in both trending and featured lists)
     * What algorithm of sorting deals by these categories?
     */
    public void sortDeals(){
        for (Deal deal : allPossibleDeals){
            if(deal instanceof ElectronicsDeal){
                electronicsDeals.add(deal);
            }else if(deal instanceof  FashionDeal){
                fashionDeals.add(deal);
            }else if(deal instanceof FoodDeal){
                foodDeals.add(deal);
            }
            if(deal.getLikes()>10){
                featuredDeals.add(deal);
            }
            if(deal.getNumOfUses()>50){
                trendingDeals.add(deal);
            }
            /*if(deal.getLikes()>10){
                newDeals.add(deal);
            }*/
        }
        fillRecyclerDealList(featuredDeals, featuredRecyclerView);
        fillRecyclerDealList(trendingDeals, trendingRecyclerView);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(HomePage.this, MoreDealsActivity.class);
        if(v.getId() == R.id.electronics_button){
            intent.putExtra("category_title", "Electronics");
        } else if (v.getId() == R.id.fashion_button) {
            intent.putExtra("category_title", "Fashion");
        }
        else if (v.getId() == R.id.education_button) {
            intent.putExtra("category_title", "Education");
        }else if (v.getId() == R.id.entertainment_button) {
            intent.putExtra("category_title", "Entertainment");
        }
        else if (v.getId() == R.id.food_drink_button) {
            intent.putExtra("category_title", "Food & Drink");
        }
        else if (v.getId() == R.id.travel_button) {
            intent.putExtra("category_title", "Travel");
        }
        startActivity(intent);
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }
}
