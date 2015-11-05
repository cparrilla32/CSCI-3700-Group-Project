package com.carlosparrilla32gmail.beercompass;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by GreyFox32 on 5/7/2015.
 */
public class DetailActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Tell the activity which XML layout is right
        setContentView(R.layout.activity_beer_detail);

        // Access the imageview from XML
        ImageView imageView = (ImageView) findViewById(R.id.beerImage);
        TextView beerN = (TextView) findViewById(R.id.beerName);
        TextView beerD = (TextView) findViewById(R.id.beerDesc);
        TextView breweryN = (TextView) findViewById(R.id.breweryName);
        TextView beerABV = (TextView) findViewById(R.id.abv);
        TextView beerIBU = (TextView) findViewById(R.id.ibu);

        String imageURL = this.getIntent().getExtras().getString("beerImage");
        String beerName = this.getIntent().getExtras().getString("beerName");
        String beerDesc = this.getIntent().getExtras().getString("beerDesc");
        String breweryName = this.getIntent().getExtras().getString("breweryName");
        String abv = this.getIntent().getExtras().getString("abv");
        String ibu = this.getIntent().getExtras().getString("ibu");

        // Use Picasso to load the image
        Picasso.with(this).load(imageURL).placeholder(R.drawable.android).into(imageView);

        beerN.setText(beerName);
        beerD.setText(beerDesc);
        breweryN.setText(breweryName);
        beerABV.setText(abv);
        beerIBU.setText(ibu);

   }
}

