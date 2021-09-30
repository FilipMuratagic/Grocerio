package com.example.grocerio.recipeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerio.R;

public class Goulash extends AppCompatActivity {

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

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.goulash_main_drawable));
        title.setText("Hungarian Goulash");
        prepTime.setText("120 minutes.");
        ingredients.setText("- 2 onions\n- 2tsp butter\n- 1 tsp caraway seeds\n- 2tbsp paprika\n- ¼ cup flour\n- 1 ½ pound stewing beef\n" +
                "- 2 cups beef broth\n- 1 cup diced tomatoes\n- 1 tsp salt\n- ¼ tsp pepper\n" +
                "- 1 ½ cup carrots\n- 300 grams potatoes\n");
        content1.setText("In a large pot, melt butter and add onion. Cook till translucent. Stir in caraway seeds and paprika and mix well.");
        content2.setText("In a bowl, dredge the stew beef with flour. Add beef to the onion mixture and cook for about 2-3 minutes. ");
        content3.setText("Slowly add about ¼ cup of the beef broth to lift the brown bits off the bottom of the pan. Then add remaining broth, " +
                "diced tomatoes (potatoes and carrots if using), salt and pepper. ");
        content4.setText("Stir and bring to a boil, cover, then reduce to a simmer for about 1 ½ - 2 hours or until tender.");
    }
}