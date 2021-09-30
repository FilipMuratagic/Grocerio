package com.example.grocerio.recipeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerio.R;

public class ShepherdsPie extends AppCompatActivity {

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

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.shepherds_main_drawable));
        title.setText("Shepherds Pie");
        prepTime.setText("90 minutes.");
        ingredients.setText(" For the Potatoes:\n\n- 1 ½ pounds russet potatoes\n- 2 ounces unsalted butter\n- ¾ tsp salt\n- ¼ tsp freshly grounds black   pepper\n" +
                "- 1 egg yolk\n\nFor the Meat filling:\n\n- 2 tbsp canola oil\n- 1 cup chopped onion\n- 2 carrots, diced small\n- 2 cloves of garlic, minced\n" +
                "- 1 ½ pounds ground lamb\n- 1 tsp salt\n- ½ tsp freshly ground black   pepper\n- 2 tbsp flour\n- 2 tsp tomato paste\n- 1 cup chicken broth\n" +
                "- 1 tsp Worcestershire sauce\n- 2 tsp freshly chopped   rosemary leaves\n- 1 tsp freshly chopped thyme   leaves\n- ½ cup of corn kernels\n" +
                "- ½ cup english peas\n");
        content1.setText("Peel the potatoes and cut into ½-inch dice. Place in a medium saucepan and cover with cold water. Set over high heat, " +
                "cover and bring to a boil. Once boiling, uncover, decrease the heat to maintain a simmer and cook until tender and easily crushed with tongs," +
                " approximately 10 to 15 minutes. Place the half-and-half and butter into a microwave-safe container and heat in the microwave until warmed through, " +
                "about 35 seconds. Drain the potatoes in a colander and then return to the saucepan. Mash the potatoes and then add the half and half, butter, s" +
                "alt and pepper and continue to mash until smooth. Stir in the yolk until well combined.");
        content2.setText("Preheat the oven to 400 degrees F.");
        content3.setText("While the potatoes are cooking, prepare the filling. Place the canola oil into a 12-inch saute pan and set over medium high heat. " +
                "Once the oil shimmers, add the onion and carrots and saute just until they begin to take on color, approximately 3 to 4 minutes. " +
                "Add the garlic and stir to combine. Add the lamb, salt and pepper and cook until browned and cooked through, approximately 3 minutes. " +
                "Sprinkle the meat with the flour and toss to coat, continuing to cook for another minute. Add the tomato paste, chicken broth, Worcestershire, " +
                "rosemary, thyme, and stir to combine. Bring to a boil, reduce the heat to low, cover and simmer slowly 10 to 12 minutes or until the sauce is thickened slightly.");
        content4.setText("Add the corn and peas to the lamb mixture and spread evenly into an 11 by 7-inch glass baking dish. Top with the mashed potatoes, starting around the edges " +
                "to create a seal to prevent the mixture from bubbling up and smooth with a rubber spatula. Place on a parchment lined half sheet pan on the middle rack of the oven and " +
                "bake for 25 minutes or just until the potatoes begin to brown. Remove to a cooling rack for at least 15 minutes before serving.");
    }
}