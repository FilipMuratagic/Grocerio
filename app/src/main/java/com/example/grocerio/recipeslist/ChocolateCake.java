package com.example.grocerio.recipeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerio.R;

public class ChocolateCake extends AppCompatActivity {

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

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.chocolate_cake_drawable));
        title.setText("Chocolate Cake");
        prepTime.setText("240 minutes.");
        ingredients.setText("Cake:\n- nonstick baking spray\n- 1 ¼ cup Dutch-process cocoa,   plus more for dusting\n" +
                "- 2 ¼ cups-all-purpose flour\n- 2 ¼ tsp baking soda\n- 1 tsp baking powder\n- 1 large egg\n" +
                "- 2 large egg yolks\n- 2 ¼ cups light brown sugar\n- 1 ¼ cup sour cream\n- ⅔ cup vegetable oil\n- 1 tbsp pure vanilla extract\n" +
                "- 1 ¼ tsp salt\n");

        content1.setText("For the cake: Arrange a rack in the center of oven and preheat to 350 degrees F. Lightly coat two 9-inch round" +
                " cake pans with nonstick cooking spray. Line the bottoms with parchment paper rounds and lightly coat the paper with nonstick " +
                "spray. Dust the bottom and sides of each pan with Dutch-process cocoa powder, tapping out excess.Sift the cocoa powder, flour, " +
                "baking soda and baking powder into the bowl of a stand mixer. Beat on low speed to combine. Add the eggs, egg yolks, brown sugar, " +
                "sour cream, oil, vanilla, salt and 1 cup of hot water. Beat on medium speed until completely smooth, about 3 minutes. ");
        content2.setText("Scrape the batter evenly into the prepared pans. Smooth the tops. Bake, rotating the pans halfway through, until a " +
                "tester inserted into the centers comes out clean, 35 to 45 minutes. Transfer the pans to a wire rack and let the cakes cool " +
                "for 30 minutes. Run a knife around the sides of the cakes and invert onto the wire rack. Remove the parchment and let the cakes " +
                "cool completely. Trim the domes of the cake rounds with a large serrated knife so the tops are flat. ");
        content3.setText("For the frosting: Melt the chocolate in a medium heatproof bowl set over simmering water in a medium saucepan. " +
                "Remove from the simmering water and let it cool to room temperature, about 30 minutes.Beat the butter and salt in a large " +
                "bowl with an electric mixer on high speed until light and fluffy, about 2 minutes. Reduce the speed to low, drizzle in the " +
                "chocolate and beat until completely blended. Gradually beat in the confectioners' sugar, cocoa powder and vanilla. Increase " +
                "the speed to high and beat until light and fluffy, about 2 minutes. ");
        content4.setText("To assemble the cake: Place one cake, cut-side down, on a platter. Spread 1 ½ cups of the frosting evenly over the top." +
                " Place the remaining cake, cut-side down, on top. Spread the top with 1 ½ cups of the frosting. Frost the sides of the cake with " +
                "¾ cup of the frosting and smooth out completely to make an even crumb coat. (It's ok if some of the cake shows through. This is just " +
                "a base layer.) Refrigerate for 30 minutes to let the frosting set. Spread the remaining frosting over the top and sides, swirling decoratively. ");
    }
}