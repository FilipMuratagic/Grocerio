package com.example.grocerio.recipeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerio.R;

public class ChickenRice extends AppCompatActivity {

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

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.chicken_rice_drawable));
        title.setText("Chicken and Rice");
        prepTime.setText("55 minutes.");
        ingredients.setText("- 2 tbsp canola oil\n- 4 to 6 chicken thighs\n- ½ tsp paprika\n" +
                "- salt & freshly ground black   pepper\n- 4 medium carrots\n- 3 stalks of celery\n" +
                "- 2 large shallots\n- 2cloves of garlic\n- 1tbsp fresh thyme leaves\n- 1 tbsp fresh oregano\n" +
                "- 2 tsp grated lemon zest\n- 1 tbsp lemon juice\n- 1 cup long-grain rice\n- 4 cups chicken stock\n" +
                "- 1 tbsp chopped fresh chives\n");
        content1.setText("Preheat the broiler. Heat 1 tablespoon of the oil in a large skillet over medium-high heat. " +
                "Toss the chicken with the paprika, 1 teaspoon salt and a few grinds of pepper in a large bowl. " +
                "Place the chicken skin-side down in the skillet and cook undisturbed until the skin is golden but not too dark, 4 to 5 minutes. " +
                "Remove the chicken to a plate using a metal spatula and add the remaining 1 tablespoon oil to the skillet.");
        content2.setText("Add the carrots, celery and shallots to the skillet and cook, stirring occasionally, until softened but not yet turning golden, " +
                "4 to 5 minutes. Stir in the garlic, thyme, oregano, lemon zest, lemon juice, ½ teaspoon salt and a few grinds of pepper and cook just " +
                "until you begin to smell the garlic, about 1 minute. Stir in the rice and cook undisturbed until lightly toasted, about 2 minutes. " +
                "Pour in the broth, add ½ teaspoon salt and stir to combine, then add the chicken thighs back to the pan, skin-side up. Bring the " +
                "liquid to a boil then cover, reduce the heat to a simmer and cook until the rice is tender and the chicken is cooked through, 15 to 20 minutes. ");
        content3.setText("Remove the lid from the pan and broil until the chicken skin is crispy and golden, 2 to 3 minutes. Sprinkle with the chives.  ");

    }
}