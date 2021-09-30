package com.example.grocerio.recipeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerio.R;

public class StuffedPeppers extends AppCompatActivity {

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

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.stuffed_main_drawable));
        title.setText("Stuffed Peppers");
        prepTime.setText("95 minutes.");
        ingredients.setText("- 6 bell peppers\n- 4 tbs olive oil\n- 8 ounces lean ground beef\n- salt and pepper\n- 1 onion, finely diced\n" +
                "- 2 cloves garlic, chopped\n- 1 medium zucchini, finely \t\tdiced\n- 4 tomatoes, finely diced\n- red pepper flakes\n" +
                "- 1 cup cooked long-grain and \t\twild rice\n- 1 ½ cups grated cheese");
        content1.setText("Preheat the oven to 350 degrees F. Cut the tops off the peppers. Remove and discard the stems, then finely chop the tops; s" +
                "et aside. Scoop out the seeds and as much of the membrane as you can. Place the peppers cut-side up in a baking dish just large enough to hold them upright.");
        content2.setText("Heat 2 tablespoons of the olive oil in a large skillet over medium-high heat. Add the beef, season with salt and pepper and cook, breaking up the lumps, " +
                "until the meat is cooked through and just beginning to brown, 8 to 10 minutes. Remove to a paper towel-lined plate to get rid of the fat.");
        content3.setText("Wipe out the skillet and add the remaining 2 tablespoons olive oil. Add the onions and chopped peppers and cook until beginning to soften, 3 to 4 minutes. " +
                "Add the garlic and zucchini and cook for another minute. Add the tomatoes and season with salt and a pinch or 2 of red pepper flakes. Cook until everything is heated through, " +
                "then stir in the beef and rice. Taste and adjust the seasoning. Stir in 1 cup of the cheese.");
        content4.setText("Fill the peppers with the rice mixture and top each with a sprinkle of the remaining ½ cup cheese. Pour a small amount of water into the bottom of the baking dish and drizzle " +
                "the peppers with a little olive oil. Cover with foil and bake for 30 minutes. Uncover and bake until the peppers are soft and the cheese is melted and lightly browned, another 15 to 20 minutes.");
    }
}