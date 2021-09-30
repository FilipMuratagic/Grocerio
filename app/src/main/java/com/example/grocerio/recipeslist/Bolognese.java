package com.example.grocerio.recipeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerio.R;

public class Bolognese extends AppCompatActivity {

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

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.bolognese_main_drawable));
        title.setText("Pasta Bolognese");
        prepTime.setText("150 minutes.");
        ingredients.setText("- ¾ pound ground beef\n- ¾ pound ground pork\n- 2 tbsp olive oil\n- 3 ounces pancetta, cut in   cubes\n- 3 cloves of garlic\n" +
                "- 2 large stalks of celery\n- 1 large carrot, cut in cubes\n- 1 medium yellow onion, cut in   cubes\n- 1 bay leaf\n" +
                "- ⅛ tbsp ground nutmeg\n- salt and pepper\n- one 6-ounce can tomato paste\n- 1 ⅔ cups dry white wine\n" +
                "- 2 cups homemade chicken   stock or water\n- 2 cups milk\n- 1 large parmesan rind\n- 1 pound fresh tagliatelle or   pappardelle\n" +
                "- grated parmesan, for serving\n");
        content1.setText("Combine the beef and pork in a large bowl. \"Pull\" the ground meat apart with two forks as if you were shredding pulled pork," +
                " breaking up the clumps and incorporating the meat without compacting it. Continue to pull the meat apart until thoroughly mixed and no " +
                "clumps remain. Heat the oil in a Dutch oven or large heavy pot over medium-high heat. Cook the pancetta, stirring occasionally, until the fat " +
                "has rendered and is golden brown on all sides, 4 to 6 minutes. Transfer the pancetta with a slotted spoon to a large bowl, leaving the fat in the pot. ");
        content2.setText("Spread half of the ground meat in an even layer in the pot and cook undisturbed until lightly golden brown, 1 to 2 minutes. Toss and continue to cook, " +
                "breaking up any clumps with the back of a spoon and scraping up any browned bits from the pot, until the meat is lightly browned on both sides, 1 to 2 minutes more. " +
                "Transfer the browned meat with a slotted spoon to the bowl with the pancetta, leaving the fat in the pot. Repeat with the remaining ground meat. Reduce the heat to medium. " +
                "Add the garlic, celery, carrots, onions, bay leaf, nutmeg, 2 teaspoons salt and ¼ teaspoon pepper and cook, stirring occasionally, until the vegetables are tender but not " +
                "browned, 8 to 10 minutes. Add the tomato paste and cook, stirring constantly, until very fragrant and brick red, about 2 minutes. Stir in the wine, bring to a boil and cook " +
                "until it reduces and thickens and no smell of alcohol remains, 6 to 8 minutes. Stir in the stock, milk and browned meat.");
        content3.setText("Bring to a boil, then reduce the heat to low. Add the Parmesan rind and simmer, stirring occasionally, until most of the liquid has evaporated away and the mixture " +
                "resembles sloppy joes, 2 to 2 ½ hours. There shouldn't be any rapid bubbles while cooking. Instead, the sauce should release occasional small bubbles. If you have a small burner" +
                " you should use it; the larger burners even at their lowest setting might cook the sauce too quickly. If the sauce reduces too quickly, add ½ cup of stock or water and continue cooking;" +
                " repeat if necessary. The sauce needs the full 2 to 2 ½ hour cook time to develop the flavors. Discard the bay leaf and Parmesan rind. Use the back of a spoon to break up any " +
                "remaining clumps of meat for an even-textured sauce. Season with salt and keep warm.");
        content4.setText("Bring a large pot of salted water to a boil over high heat. Cook the pasta. If using fresh pasta, cook about 3 minutes. If using dry, cook until very al dente, about 2 minutes less " +
                "than the package directions. Reserve 1 cup of the pasta cooking liquid, then drain the pasta and transfer to the sauce. Increase the heat to medium, bring the sauce to a simmer and cook, " +
                "tossing the pasta constantly, until the pasta is al dente and the sauce is slightly thickened, adding pasta cooking liquid if necessary, about 2 minutes. Transfer the pasta to a platter and top with grated Parmesan. ");
    }
}