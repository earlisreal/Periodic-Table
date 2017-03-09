package com.ama.periodictable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ElementActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
            }
            return false;
        }

    };

    public TextView number, symbol, name, weight;
    ImageView elementImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

//        getActionBar().setDisplayHomeAsUpEnabled(true);

        int position = getIntent().getIntExtra("position", -1);
        Database database = new Database(this);
        Element element = database.getElements().get(position);

        number = (TextView) findViewById(R.id.number);
        symbol = (TextView) findViewById(R.id.symbol);
        name = (TextView) findViewById(R.id.name);
        weight = (TextView) findViewById(R.id.weight);
        elementImage = (ImageView) findViewById(R.id.element_image);

        number.setText("" +element.getNumber());
        symbol.setText(element.getSymbol());
        name.setText(element.getName());
        weight.setText(element.getWeight());

        Resources res = getResources();

        try{

            int imageId = res.getIdentifier("element" +element.getNumber(), "drawable", getPackageName());
            //Drawable drawable = res.getDrawable(imageId);
            //elementImage.setImageDrawable(drawable);

            elementImage.setImageResource(imageId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
