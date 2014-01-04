package com.briangriffey.glass.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.google.android.glass.app.Card;

/**
 * Created by briangriffey on 1/3/14.
 */
public class CardActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create a card with some simple text and a footer.
        Card card1 = new Card(this);
        card1.setText("This card has a footer.");
        card1.setFootnote("I'm the footer!");
        View card1View = card1.toView();

        setContentView(card1View);
    }
}
