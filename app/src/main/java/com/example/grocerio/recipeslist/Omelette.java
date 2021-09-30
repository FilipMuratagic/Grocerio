package com.example.grocerio.recipeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerio.R;

public class Omelette extends AppCompatActivity {

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

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.omelette_main_drawable));
        title.setText("Omelette");
        prepTime.setText("10 minutes.");
        ingredients.setText("- 3 eggs, beaten\n- 1 tsp sunflower oil\n- 1 tsp butter\n");
        content1.setText("Season the beaten eggs well with salt and pepper. Heat the oil and butter in a non-stick frying pan over a medium-low heat until the butter has melted and is foaming.");
        content2.setText("Pour the eggs into the pan, tilt the pan ever so slightly from one side to another to allow the eggs to swirl and cover the surface of the pan completely. " +
                "Let the mixture cook for about 20 seconds then scrape a line through the middle with a spatula.");
        content3.setText("Tilt the pan again to allow it to fill back up with the runny egg. Repeat once or twice more until the egg has just set.");
        content4.setText("At this point you can fill the omelette with whatever you like – some grated cheese, sliced ham, fresh herbs, sautéed mushrooms or smoked salmon all work well. " +
                "Scatter the filling over the top of the omelette and fold gently in half with the spatula. Slide onto a plate to serve.");
    }
}