package com.example.grocerio.recipeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerio.R;

public class Lasagna extends AppCompatActivity {

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

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.lasagna_main_drawable));
        title.setText("Lasagna");
        prepTime.setText("240 minutes.");
        ingredients.setText("- 1 pound ground beef\n- 2 tbsp olive oil\n- 3 ounces pancetta, cut into   cubes\n" +
                "- 1 large carrot, cut into cubes\n- 1 large celery stack, cut into   cubes\n- 1 medium yellow onion, cut   into cubes\n" +
                "- 6 cloves of garlic\n- 1 bay leaf\n- 1 tsp dried oregano\n- ¼ tsp crushed red pepper   flakes\n- ⅛ tsp freshly ground nutmeg\n" +
                "- salt and pepper\n- ¼ cup tomato paste\n- ½ cup dry white wine\n- two 28-ounce cans whole   peeled tomatoes\n- 2 large sprigs basil\n" +
                "- 1 large piece of Parmesan rind\n- 2 cups whole milk ricotta\n- 1 ¼ cup grated Parmesan\n- 8 ounces whole milk   mozzarella\n");

        content1.setText("Place the beef in a large bowl and \"pull\" it apart with two forks as if you were shredding pulled pork, breaking up the clumps " +
                "and loosening the meat without compacting it.Heat the oil in a Dutch oven or large heavy pot over medium-high heat. Add the pancetta and cook, " +
                "stirring occasionally, until the fat has rendered and the meat is golden brown, 5 to 7 minutes. Transfer the pancetta to a large bowl with a " +
                "slotted spoon, leaving the fat in the pot. Spread the beef in an even layer in the same pot and cook undisturbed until lightly browned, about 3 minutes. " +
                "Toss and continue to cook, breaking up any clumps and scraping up any browned bits from the pot, until the meat is browned and completely cooked, 5 to 6 minutes. " +
                "Transfer the browned meat with a slotted spoon to the bowl with the pancetta, leaving the fat in the pot. ");
        content2.setText("Reduce the heat to medium. Add the carrots, celery, onions, half the garlic, the bay leaf, oregano, red pepper flakes, nutmeg, 2 teaspoons salt and ¼ teaspoon " +
                "black pepper to the pot and cook, stirring occasionally, until the vegetables are tender but not browned, 6 to 8 minutes. Add the tomato paste and cook, stirring " +
                "constantly, until it's very fragrant and brick red colored, about 2 minutes. Stir in the wine, bring to a boil and reduce until the liquid is very thick and no smell of " +
                "alcohol remains, 6 to 8 minutes. Add the tomatoes and the reserved pancetta and beef, bring to a boil and then reduce the heat to low. Add the basil and Parmesan rind and simmer," +
                " stirring occasionally, until most of the liquid has evaporated and the sauce resembles sloppy joes, 2 to 2 ½ hours. There shouldn't be any rapid bubbles while cooking. Instead, " +
                "the ragu should release occasional small bubbles. If the ragu reduces too quickly, add ½ cup of water and continue cooking. Repeat if necessary. The ragu needs the full 2 to 2 ½ hour" +
                " cook time to develop the flavors. Discard the bay leaf, basil and Parmesan rind. Break up any remaining clumps of meat with the back of a spoon, making an even textured sauce. Season with " +
                "salt and set aside until ready to assemble.  ");
        content3.setText("Arrange a rack in the center of the oven and preheat to 350 degrees F. Bring a large pot of salted water to a boil over high heat. Cook the noodles, stirring occasionally " +
                "and separating them to prevent sticking, until softened and bendable but are still hard and chalky in the center, about 5 minutes. Transfer the noodles to a large bowl of cold water " +
                "and set aside until ready to assemble. Lightly oil a 13-by-9-inch glass or ceramic baking pan. Spread 1 cup of the ragu evenly in the bottom of the pan. Lay a single layer of noodles over the ragu " +
                "(if you're using long noodles, you will need to cut some noodles to fill the gaps). Spread 1 ½ cups of the ragu over the noodles. Dollop ¾ cup of the ricotta mixture over " +
                "the ragu and spread lightly with a small offset spatula. Sprinkle with ½ cup of the mozzarella, followed by another layer of noodles. Repeat with the remaining pasta, ragu, ricotta " +
                "mixture and mozzarella, creating 4 layers of pasta and ending with the remaining ½ cup mozzarella. (The lasagna should come just above the top of the pan but it will sink down slightly as it cooks.) " +
                "Top with the remaining ¼ cup Parmesan. ");
        content4.setText("Lightly oil a piece of foil and cover the pan. Put the pan on a rimmed baking sheet to catch any drips. Bake the lasagna until bubbling gently around the edges, about 1 hour.Remove the lasagna " +
                "from the oven and increase the oven temperature to 450 degrees F. Remove the foil and then continue to bake the lasagna until the top is browned and crisp around the edges, 15 to 20 minutes. " +
                "Let sit 10 minutes before serving.");
    }
}