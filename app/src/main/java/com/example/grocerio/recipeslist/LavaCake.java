package com.example.grocerio.recipeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerio.R;

public class LavaCake extends AppCompatActivity {

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

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.lava_cake_main_drawable));
        title.setText("Lava Cake");
        prepTime.setText("25 minutes.");
        ingredients.setText("- 6 ounces bittersweet   chocolate, roughly chopped\n- 1 stick (½) unsalted butter,   plus 1 tbsp melted\n" +
                "- ¼ cup sugar, plus more for   coating the ramekins\n- 1 tsp pure vanilla extract\n- 1 tsp instant espresso powder\n" +
                "- ½ tsp salt\n- 2 large eggs, plus 2 large egg   yolks\n- 2 tbsp all-purpose flour\n");

        content1.setText("Preheat the oven to 400 degrees F. Brush four 6-ounce ramekins with the melted butter and sprinkle lightly with sugar. " +
                "Place the ramekins on a baking sheet.");
        content2.setText("Combine the chocolate and butter in a medium microwave-safe bowl. Microwave on high in 30 second intervals, stirring in between " +
                "each with a rubber spatula until completely melted and smooth, about 1 ½ minutes total. Add the vanilla, espresso powder and salt into the " +
                "chocolate mixture and stir to combine.");
        content3.setText("Add the eggs, egg yolks and ¼ cup sugar to the bowl of a stand mixer fitted with a whisk attachment. Whisk on medium-high " +
                "until fluffy and pale, about 1 ½ to 2 minutes. With the mixer on low, add the chocolate mixture to the egg mixture, mixing until just combined. " +
                "Remove the bowl from the stand mixer and gently fold in the flour using a rubber spatula.");
        content4.setText("Divide the batter equally among the 4 prepared ramekins. Bake until the sides are firm but the centers are still soft, 12 to 14 minutes. " +
                "(A cake tester inserted into the center of each cake should not come out clean.) Do not overbake.Let the cakes cool for 1 minute. " +
                "Invert onto serving plates and serve warm. ");
    }
}