package com.example.grocerio.recipeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerio.R;

public class Salmon extends AppCompatActivity {

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

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.salmon_main_drawable));
        title.setText("Baked Salmon");
        prepTime.setText("30 minutes.");
        ingredients.setText("- 12 ounce salmon fillet, 4   pieces\n- coarse grained salt\n- freshly ground black pepper\n" +
                "- toasted almond parsley salsa   (for serving)\n- 1 shallot\n- 1 tbsp red wine vinegar\n- 2 tbsp capers, rinsed\n" +
                "- 1 cup fresh flat-leaf parsley\n- ½ cup toasted almonds\n- extra virgin olive oil");
        content1.setText("Preheat the oven to 450 degrees F.");
        content2.setText("Season salmon with salt and pepper. Place salmon, skin side down, on a non-stick baking sheet " +
                "or in a non-stick pan with an oven-proof handle. Bake until salmon is cooked through, about 12 to 15 minutes. " +
                "Serve with the Toasted Almond Parsley Salad and squash, if desired.");
        content3.setText("Mince the shallot and add to a small bowl. Pour the vinegar over the shallots and add a pinch of salt. Let sit for 30 minutes.");
        content4.setText("Roughly chop the capers, parsley and almonds and add to the shallots. Add the olive oil, tasting as you go. " +
                "Mix again and adjust the seasonings.");

    }
}