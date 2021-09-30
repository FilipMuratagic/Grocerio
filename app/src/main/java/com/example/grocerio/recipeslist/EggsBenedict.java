package com.example.grocerio.recipeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerio.R;

public class EggsBenedict extends AppCompatActivity {

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

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.eggs_benedict_main_drawable));
        title.setText("Eggs Benedict");
        prepTime.setText("25 minutes.");
        ingredients.setText("- 8 pcs of bacon \n" + "- 2 tbsp chopped parsley\n" + "- 4 eggs\n" + "- 2 teaspoons white vinegar\n" +
                "- 2 English muffins\n" + "- butter\n" + "\n- For the Hollanadaise:\n\n" + "- 10 tbsp unsalted butter\n" + "- 3 egg yolks\n" +
                "- 1 tbsp lemon juice\n" + "- ½ teaspoon salt\n" + "- dash of cayenne\n");

        content1.setText("Heat a large skillet on medium low heat. Add the strips of bacon or the slices of Canadian bacon. " +
                "Slowly fry, turning occasionally, until the bacon is browned on both sides, and if using strip bacon, much of the " +
                "fat is rendered out (about 10 minutes). While the bacon is cooking, bring a large saucepan two-thirds-filled with water to a boil, " +
                "then add the vinegar. Bring the water to a boil again, then lower the heat to a bare simmer.");

        content2.setText("To make blender hollandaise, melt 10 Tbsp unsalted butter." +
                "Put 3 egg yolks, a tablespoon of lemon juice, ½ teaspoon salt in a blender, blend on medium to medium high speed for 20-30 seconds," +
                " until eggs lighten in color." +
                "Turn blender down to lowest setting, slowly dribble in the hot melted butter, while continuing to blend. " +
                "Taste for salt and acidity and add more salt or lemon juice to taste." +
                "Transfer it to a container you can use for pouring and set it on a warm—but not hot—place on or near the stovetop.");

        content3.setText("Working one egg at a time you crack an egg into a small bowl and slip it into the barely simmering water. " +
                "Once it begins to solidify, you can slip in another egg, until you have all four cooking. Turn off the heat, cover the pan, " +
                "and let sit for 4 minutes. Note that the timing is a little variable on the eggs, depending on the size of your pan, how much water, " +
                "how many eggs, and how runny you like them.");

        content4.setText("As soon as all the eggs are in the poaching water, begin toasting your English muffins. If you can’t get all the muffins toasted " +
                "by the time the eggs are ready, gently remove the eggs from the poaching water and set in a bowl. To assemble, butter one side of an English muffin. " +
                "Top with two slices of bacon, put a poached egg on top of the bacon, then pour some hollandaise over. Sprinkle some parsley over it all and serve at once.");

    }
}