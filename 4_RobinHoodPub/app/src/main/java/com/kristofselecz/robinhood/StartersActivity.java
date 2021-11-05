package com.kristofselecz.robinhood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class StartersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);

        // ListView variable
        ListView startersList = findViewById(R.id.list_view_starters);

        Dish[] dishes = {
                new Dish("Melon and lemon soup", "Fresh melon and lemon combined into creamy soup", 1199),
                new Dish("Coconut and chocolate mousse", "A creamy mousse made with fresh coconut and milk chocolate", 899),
                new Dish("Spinach and cabbage wontons", "Thin wonton cases stuffed with fresh spinach and chinese cabbage", 799),
                new Dish("Broccoli and cucumber soup", "Fresh broccoli and cucumber combined into creamy soup", 899),
                new Dish("Chilli and aubergine dip", "A dip made from scotch bonnet chilli and fresh aubergine", 999),
                new Dish("Chickpea and chilli gyoza", "Thin pastry cases stuffed with fresh chickpea and green chilli", 699),
                new Dish("Sprout and pineapple soup", "Fresh sprout and pineapple combined into creamy soup", 899),
                new Dish("Egusi and borscht soup", "Egusi and borscht combined into creamy soup", 1299)
        };


        String[] dishesList = {
                "Crab and monkfish madras",
                "Polenta and sultana biscuits",
                "Rice and pecan pie",
                "Tuna and tomato penne",
                "Spinach and salmon lasagne",
                "Chicken and udon salad",
                "Jalapeno and egg pizza",
                "Orange and bran biscuits",
                "Treacle and stilton cupcakes",
                "Apple and yuzu salad",
                "Chicken and beetroot risotto",
                "Elderberry and jaggery salad",
                "Venison and plantain madras",
                "Stilton and pigeon dumplings",
                "Olive and caper penne",
                "Pork and steak bagel",
                "Tempeh salad with garlic dressing",
                "Sage and pineapple jam",
                "Pumpkin and crab korma",
                "Avocado and fregola pasta"
        };

        /******* ListView Adapter Implementation *******/

        /**
         * ArrayAdapter<T>
         *
         * Constructor params
         * ArrayAdapter(@NonNull Context context, int resource, @NonNull T[] objects)
         */
        ArrayAdapter<Dish> dishesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dishes);

        /**
         * Method params
         * setAdapter(ListAdapter adapter)
         */
        startersList.setAdapter(dishesAdapter);

    }
}