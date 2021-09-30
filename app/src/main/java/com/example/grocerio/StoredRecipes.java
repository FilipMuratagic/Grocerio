package com.example.grocerio;

import java.util.ArrayList;

public class StoredRecipes {

    private ArrayList<String> RecipeList = new ArrayList<>();

    public StoredRecipes(){

        RecipeList.add("Eggs Benedict");
        RecipeList.add("Omelette");
        RecipeList.add("Pancakes");
        RecipeList.add("Chicken & Rice");
        RecipeList.add("Goulash");
        RecipeList.add("Kung Pao Chicken");
        RecipeList.add("Salmon");
        RecipeList.add("Shepherd's Pie");
        RecipeList.add("Stuffed Peppers");
        RecipeList.add("Lasagna");
        RecipeList.add("Pasta Bolognese");
        RecipeList.add("Sesame Salad");
        RecipeList.add("Chocolate Cake");
        RecipeList.add("Creme Brulee");
        RecipeList.add("Lava Cake");
    }

    public ArrayList<String> getRecipeList(){
        return RecipeList;
    }

    public String getRecipe(int index){
        return RecipeList.get(index);
    }

}
