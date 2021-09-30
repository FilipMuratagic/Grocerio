package com.example.grocerio.recipeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerio.R;

public class CremeBrulee extends AppCompatActivity {

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

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.creme_brule_main_drawable));
        title.setText("Creme Brulee");
        prepTime.setText("45 minutes.");
        ingredients.setText("- 2 ½ cups heavy cream\n- 1 vanilla bean, split lengthwise\n" +
                "- ¼ tsp salt\n- 12 tbsp sugar\n- 7 large egg yolks\n");

        content1.setText("Arrange a rack in the center of the oven and preheat to 300 degrees F. " +
                "Line a large heavy roasting pan (a turkey roasting pan works great) with a clean kitchen " +
                "towel and place 4 six-ounce ramekins on top of the towel spaced a few inches apart.Heat the " +
                "cream in a medium saucepan over medium heat. Using the back of a paring knife, scrape the " +
                "vanilla seeds from both halves of the pod. Add the seeds and pod to the cream. Whisk in the salt " +
                "and 3 tablespoons of the sugar and bring to a boil. Remove from the heat.");
        content2.setText("Vigorously whisk the yolks and 3 more tablespoons of the sugar in a large bowl until " +
                "pale yellow and very thick and creamy, about 2 minutes. Alternatively, you can use an electric " +
                "mixer on high speed and beat until pale yellow and very thick and creamy, about 1 minute.Whisking " +
                "the yolks constantly, add a couple of teaspoons at a time from 1 cup of the hot cream, then increase" +
                " to a steady stream until the cream is fully incorporated. (Don't pour too much hot cream at once or " +
                "you'll end up with scrambled eggs.) The yolks are now tempered. Whisk the tempered yolks back into the " +
                "remaining hot cream until combined. Strain through a fine mesh sieve into a large measuring cup or medium" +
                " pitcher for easier pouring; discard the vanilla pods.");
        content3.setText("Skim the foam off the top of the custard by placing a clean paper towel on top and lightly " +
                "pressing down so it touches the surface and absorbs some of the liquid. This will make for a completely " +
                "smooth and silky custard. Fill the ramekins with the custard, about ¾ cup per ramekin. Carefully pour " +
                "boiling water into the roasting pan halfway up the sides of the ramekins without getting any water in the " +
                "custard. Cover the pan tightly with foil and bake until the custard is set around the edges but still has a " +
                "slight jiggle in the center, 35 to 45 minutes. Carefully remove the roasting pan from the oven and transfer " +
                "the ramekins to a wire rack to cool for 30 minutes. Then refrigerate until very cold, about 3 hours.");
        content4.setText("Just before serving, evenly spread 1 tablespoon of the sugar over the top of a custard. Hold a " +
                "kitchen torch 2 inches above the surface. Starting in the center of the ramekin, move the flame in a " +
                "circular motion and work your way out to the edges to caramelize the sugar. Repeat with the remaining " +
                "sugar and custards. Alternatively, arrange a rack in the top position of the oven and heat the broiler " +
                "on high. Place the ramekins on a rack set inside a baking sheet and broil until deep golden brown, 15 to 60 seconds, " +
                "checking every 10 seconds. Freeze the custards for 5 minutes before serving.");
    }
}