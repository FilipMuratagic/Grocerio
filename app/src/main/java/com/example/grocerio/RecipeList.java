package com.example.grocerio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class RecipeList extends AppCompatActivity {

    Integer[] imageID = {R.drawable.eggs_benedict_main_drawable,R.drawable.omelette_main_drawable, R.drawable.pancakes_main_drawable,
                            R.drawable.chicken_rice_drawable,R.drawable.goulash_main_drawable,R.drawable.kung_pao_main_drawable,
                            R.drawable.salmon_main_drawable,R.drawable.shepherds_main_drawable,R.drawable.stuffed_main_drawable,
                            R.drawable.lasagna_main_drawable,R.drawable.bolognese_main_drawable,R.drawable.sesame_salad_main_drawable,
                            R.drawable.chocolate_cake_drawable,R.drawable.creme_brule_main_drawable,R.drawable.lava_cake_main_drawable};

    TextView title,prepTime,ingredients,content1;
    private int recipeNr;
    private String prep,ingredient,recipe;
    StringBuilder stringBuilder = new StringBuilder();
    StringBuilder ingredientBuilder = new StringBuilder();
    StringBuilder recipeBuilder = new StringBuilder();
    ArrayList<String> prepList = new ArrayList<>();
    ArrayList<String> ingredientList = new ArrayList<>();
    ArrayList<String> recipeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_recipe);
        Intent intent = getIntent();
        int recipe = intent.getIntExtra("data",0);
        recipeNr = recipe;

        ImageView imageView = findViewById(R.id.RecipePhoto);
        title = findViewById(R.id.RecipeName);
        prepTime = findViewById(R.id.PreparationTime);
        ingredients = findViewById(R.id.Ingredients);
        content1 = findViewById(R.id.TextViewRecipe1);
        /*content2 = findViewById(R.id.TextViewRecipe2);
        content3 = findViewById(R.id.TextViewRecipe3);
        content4 = findViewById(R.id.TextViewRecipe4);*/

        /*Document doc = getRecipeContent(recipe);*/

        imageView.setImageDrawable(getResources().getDrawable(imageID[recipe]));

        StoredRecipes storedRecipes = new StoredRecipes();
        title.setText(storedRecipes.getRecipe(recipe));
        setTitle(storedRecipes.getRecipe(recipe)+" Recipe");

        WebContent webContent = new WebContent();
        webContent.execute();

    }

    String getRecipeUrl(int recipe){
        String string ="";
        switch (recipe){
            case 0:
                string = "https://www.foodnetwork.com/recipes/ina-garten/eggs-benedict-and-easy-hollandaise-sauce-3772150";
                break;
            case 1:
                string = "https://www.foodnetwork.com/recipes/food-network-kitchen/western-omelette-recipe-2011477";
                break;
            case 2:
                string = "https://www.foodnetwork.com/recipes/food-network-kitchen/pancakes-recipe-1913844";
                break;
            case 3:
                string = "https://www.foodnetwork.com/recipes/food-network-kitchen/the-best-chicken-and-rice-8133711";
                break;
            case 4:
                string = "https://www.foodnetwork.com/recipes/hungarian-goulash-recipe2-2011533";
                break;
            case 5:
                string = "https://www.foodnetwork.com/recipes/kung-pao-chicken-9534770";
                break;
            case 6:
                string = "https://www.foodnetwork.com/recipes/oven-baked-salmon-recipe-1911951";
                break;
            case 7:
                string = "https://www.foodnetwork.com/recipes/alton-brown/shepherds-pie-recipe2-1942900";
                break;
            case 8:
                string = "https://www.foodnetwork.com/recipes/ree-drummond/stuffed-bell-peppers-3325315";
                break;
            case 9:
                string = "https://www.foodnetwork.com/recipes/food-network-kitchen/the-best-lasagna-7250923";
                break;
            case 10:
                string = "https://www.foodnetwork.com/recipes/food-network-kitchen/the-best-bolognese-7195546";
                break;
            case 11:
                string = "https://www.foodnetwork.com/recipes/food-network-kitchen/sesame-noodle-salad-3764799";
                break;
            case 12:
                string = "https://www.foodnetwork.com/recipes/food-network-kitchen/the-best-chocolate-cake-7193220";
                break;
            case 13:
                string = "https://www.foodnetwork.com/recipes/food-network-kitchen/the-best-creme-brulee-7264939";
                break;
            case 14:
                string = "https://www.foodnetwork.com/recipes/chocolate-lava-cakes-2312421";
                break;
        }
        return string;

    }

    private class WebContent extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            String url = getRecipeUrl(recipeNr);
            System.out.println(url);

            try {
                Document doc = Jsoup.connect(url).get();
                Elements prepTimeData = doc.select("div.o-RecipeInfo")
                        .select("ul.o-RecipeInfo__m-Time").select("li");

                for (Element element : prepTimeData) {
                    prepList.add(element.select("span").text());
                }
                for (int i = 0; i < prepList.size() / 2; i++) {
                    stringBuilder.append(prepList.get(i)).append("\n");
                }
                prep = stringBuilder.toString();

                Elements ingredientData = doc.select("div.o-Ingredients__m-Body").select("p.o-Ingredients__a-Ingredient");

                for (Element element : ingredientData) {
                    ingredientList.add(element.select("span.o-Ingredients__a-Ingredient--CheckboxLabel").text());
                }

                for (int i = 1; i < ingredientList.size(); i++) {
                    ingredientBuilder.append("- ").append(ingredientList.get(i)).append("\n");
                }
                ingredient = ingredientBuilder.toString();

                Elements recipeData = doc.select("div.bodyRight")
                        .select("section.o-Method")
                        .select("div.o-Method__m-Body")
                        .select("ol")
                        .select("li.o-Method__m-Step");

                for (Element element : recipeData) {
                    recipeList.add(element.text());
                }
                for(int i=0;i<recipeList.size();i++){
                    recipeBuilder.append(recipeList.get(i)).append("\n\n");
                }
                recipe = recipeBuilder.toString();

            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            prepTime.setText(prep);
            ingredients.setText(ingredient);
            content1.setText(recipe);
        }

    }

}