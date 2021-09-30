package com.example.grocerio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Arrays;

public class Recipes extends AppCompatActivity {

    Integer[] recipeID = {R.id.BreakfastImage1,R.id.BreakfastImage2,R.id.BreakfastImage3,R.id.LunchImage1,R.id.LunchImage2,R.id.LunchImage3,R.id.LunchImage4,R.id.LunchImage5,
                      R.id.LunchImage6,R.id.DinnerImage1,R.id.DinnerImage2,R.id.DinnerImage3,R.id.DessertImage1,R.id.DessertImage2,R.id.DessertImage3};
    Integer[] recipeName = {R.id.Breakfast1,R.id.Breakfast2,R.id.Breakfast3,R.id.Lunch1,R.id.Lunch2,R.id.Lunch3,R.id.Lunch4,R.id.Lunch5,
                        R.id.Lunch6,R.id.Dinner1,R.id.Dinner2,R.id.Dinner3,R.id.Dessert1,R.id.Dessert2,R.id.Dessert3};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
    }

    public void onRecipeClicked(View view){
        int id = view.getId();
        Intent intent = new Intent(this,RecipeList.class);

        int rId,rName;
        rId = Arrays.asList(recipeID).indexOf(id);
        rName = Arrays.asList(recipeName).indexOf(id);

        if(rId>rName) intent.putExtra("data",rId);
        else intent.putExtra("data",rName);

        startActivity(intent);
    }
}