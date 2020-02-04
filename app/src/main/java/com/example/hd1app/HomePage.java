package com.example.hd1app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.hd1app.DealCategories.AllPossibleDeals;
import com.example.hd1app.DealCategories.NewDeals;
import com.example.hd1app.DealCategories.FeaturedDeals;
import com.example.hd1app.DealCategories.TrendingDeals;
import com.example.hd1app.Models.Deal;
import com.example.hd1app.Models.EducationDeal;
import com.example.hd1app.Models.ElectronicsDeal;
import com.example.hd1app.Models.FashionDeal;
import com.example.hd1app.Models.FoodDeal;

import java.util.ArrayList;
import java.util.Date;

public class HomePage extends AppCompatActivity {
    Spinner spinner;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //Get components
        spinner = findViewById(R.id.choice_spinner);
        featuredRecyclerView = findViewById(R.id.featured_recycler_view);
        trendingRecyclerView = findViewById(R.id.trending_recycler_view);
        newRecyclerView = findViewById(R.id.new_recycler_view);

        //Create objects of different deals
        featuredDeals = new FeaturedDeals();
        newDeals = new NewDeals();
        trendingDeals = new TrendingDeals();
        allPossibleDeals = new AllPossibleDeals();

        //Categories
        foodDeals = new ArrayList<>();
        electronicsDeals = new ArrayList<>();
        fashionDeals = new ArrayList<>();

        //
        initSpinner(spinner);

        //Deals management
        createTestDeals();
        sortDeals();

        fillRecyclerDealList(newDeals, newRecyclerView);

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

        FoodDeal foodDeal = new FoodDeal("KFC deal%", "45HHs6hgshHG", new Date(2020,2,29),240,100);
        FoodDeal foodDeal1 = new FoodDeal("McDonalds offer", "45HHs6hgshHG", new Date(2020,2,29),430,200);
        FoodDeal foodDeal2 = new FoodDeal("Subway deal", "45HHs6hgshHG", new Date(2020,2,29),1000,5);
        allPossibleDeals.add(foodDeal);
        allPossibleDeals.add(foodDeal1);
        allPossibleDeals.add(foodDeal2);
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
}
