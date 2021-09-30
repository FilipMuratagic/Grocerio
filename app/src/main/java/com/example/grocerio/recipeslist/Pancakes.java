package com.example.grocerio.recipeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerio.R;

public class Pancakes extends AppCompatActivity {

    TextView title,prepTime,ingredients,content1,content2,content3,content4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_recipe);

        ImageView imageView = findViewById(R.id.RecipePhoto);
        title = findViewById(R.id.RecipeName);
        prepTime = findViewById(R.id.PreparationTime);
        ingredients = findViewById(R.id.Ingredients);
        content1 = findViewById(R.id.TextViewRecipe1);
        /*content2 = findViewById(R.id.TextViewRecipe2);
        content3 = findViewById(R.id.TextViewRecipe3);
        content4 = findViewById(R.id.TextViewRecipe4);*/

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.pancakes_main_drawable));
        title.setText("Pancakes");
        prepTime.setText("15 minutes.");
        ingredients.setText("- 5 eggs\n- 1 and ½ cups of milk\n- 6 tbsp butter,melted\n- 5 cups buttermilk\n- 5 cups all-purpose flower\n" +
                "- 5 tsp baking powder\n- 5 tsp baking soda\n- 1 pinch of salt (optional)\n- 5 tbsp sugar\n");
        content1.setText("In a large bowl, whisk together the eggs, milk, butter and buttermilk. Combine the flour, " +
                "baking powder, baking soda and sugar; stir into the wet ingredients just until blended." +
                " Adjust the thickness of the batter to your liking by adding more flour or buttermilk if necessary.");
        content2.setText("Heat a large skillet over medium heat, and coat with cooking spray. Pour ¼ cupfuls of batter onto the skillet, " +
                "and cook until bubbles appear on the surface. Flip with a spatula, and cook until browned on the other side. Continue with remaining batter.");
    }
}