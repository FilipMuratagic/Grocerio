package com.example.grocerio.recipeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerio.R;

public class SesameSalad extends AppCompatActivity {

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

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.sesame_salad_main_drawable));
        title.setText("Sesame Noodle Salad");
        prepTime.setText("20 minutes.");
        ingredients.setText("- 8 ounces udon dried noodles\n- 1 cup frozen shelled edamame\n" +
                "- vegetable oil, for the grill\n- 1 bunch scallions\n- 3 tbsp tahini\n- 3 tbsp soy sauce\n" +
                "- 3 tbsp rice wine vinegar\n- 2 tsp toasted sesame oil\n- 2 tsp sugar\n- 2 tsp grated fresh ginger\n" +
                "- 2 cups bean sprouts\n- 1 cup shredded carrots\n- 1 cup julienned snow peas\n- toasted sesame seeds, for   topping\n");

        content1.setText("Cook the udon noodles as the label directs; drain and let cool. Meanwhile, cook the edamame as the label directs; drain and let cool.");
        content2.setText("Heat a grill or grill pan over medium-high heat and oil the grates. Add the scallions and cook, turning, until charred, about 3 minutes. Let cool, then slice. ");
        content3.setText("Make the dressing: Whisk the tahini, soy sauce, vinegar, sesame oil, sugar and ginger in a large bowl. Stir in 1 to 2 tablespoons water to make a smooth sauce. ");
        content4.setText("Add the noodles and edamame to the dressing along with the bean sprouts, carrots and snow peas; toss. Sprinkle with sesame seeds. ");

    }
}