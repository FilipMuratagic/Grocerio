package com.example.grocerio.recipeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerio.R;

public class KungPaoChicken extends AppCompatActivity {

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

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.kung_pao_main_drawable));
        title.setText("Kung Pao Chicken");
        prepTime.setText("50 minutes.");
        ingredients.setText("- 2 lbs. chicken breasts,thinly   sliced\n- ¼ cup soy sauce\n- 2 tbsp cornstarch\n" +
                "- 3 tbsp sesame oil\n- 1 red bell pepper, cubed\n- 1 green bell pepper, cubed\n- 1 bunch green onions, white   and green parts\n" +
                "- ½ cup cashews\n- 10 dried chili peppers, cut in   half\n- 6 garlic cloves, minced\n- 1 tbsp fresh ginger,minced or   grated\n" +
                "\nKung Pao Sauce:\n\n- ¼ cup soy sauce\n- ⅓ cup rice vinegar\n- 2 tbsp sugar\n");
        content1.setText("Make the Kung Pao sauce: combine ¼ cup of soy sauce, rice or sherry vinegar and sugar in a bowl. Stir to combine and set aside.");
        content2.setText("Combine the remaining ¼ cup of soy sauce or (tamari) with cornstarch in a large bowl and whisk until the mixture is smooth and uniform. " +
                "Toss chicken breast pieces in the soy sauce-cornstarch mixture to coat and set aside.");
        content3.setText("In a large skillet, heat the sesame oil over high heat. Working in batches so as not to overcrowd the pan, stir-fry the chicken pieces until " +
                "lightly browned and cooked through—about 3-4 minutes total. Remove the chicken from the pan and set it aside.");
        content4.setText("Once all of the chicken is cooked, use the same skillet to finish the dish. Heat one tablespoon of sesame oil over medium heat." +
                " When the pan is hot, stir-fry the bell peppers for about four minutes, until they begin to soften. Add the green onions, cashews, ginger, garlic," +
                " and dried chili peppers. Stir-fry the vegetables for 2 minutes before adding the Kung Pao sauce and the cooked chicken breast. Bring the pan to a simmer, " +
                "and cook until the sauce has thickened— about 2 minutes. Serve over white or brown rice.");
    }
}