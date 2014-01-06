package com.briangriffey.glass.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

/**
 * Created by briangriffey on 1/3/14.
 */
public class CardActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CardScrollView scrollView = new CardScrollView(this);
        scrollView.setAdapter(new SpecialCardAdapter());
        scrollView.activate();

        setContentView(scrollView);
    }

    private class SpecialCardAdapter extends CardScrollAdapter {

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Object getItem(int i) {
            return new Integer(i);
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            // Create a card with some simple text and a footer.
            Card card1 = new Card(CardActivity.this);
            card1.setText("This is card " + i);
            return card1.toView();

        }

        @Override
        public int findIdPosition(Object o) {
            return (Integer)o;
        }

        @Override
        public int findItemPosition(Object o) {
            return (Integer)o;
        }
    }
}
