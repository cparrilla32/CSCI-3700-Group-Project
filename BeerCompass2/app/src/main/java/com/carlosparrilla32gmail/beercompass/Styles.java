package com.carlosparrilla32gmail.beercompass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by GreyFox32 on 4/30/2015.
 */
public class Styles extends Activity
{
    Button pale;
    Button indiaPale;
    Button brownAle;
    Button stout;
    Button porter;
    Button hfw;
    Button amber;
    Button pils;
    Button bock;
    Button back;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_styles);

        pale = (Button) findViewById(R.id.pa);
        indiaPale = (Button) findViewById(R.id.ipa);
        brownAle = (Button) findViewById(R.id.ba);
        stout = (Button) findViewById(R.id.stout);
        porter = (Button) findViewById(R.id.porter);
        hfw = (Button) findViewById(R.id.hfw);
        amber = (Button) findViewById(R.id.amber);
        pils = (Button) findViewById(R.id.pils);
        bock = (Button) findViewById(R.id.bock);
        back = (Button) findViewById(R.id.button_back);

        pale.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String style = getString(R.string.btn_pa);
                String description = getString(R.string.pa_detail);

                Intent pale = new Intent(getApplicationContext(), StyleDetail.class);

                pale.putExtra("style", style);
                pale.putExtra("description", description);

                startActivity(pale);
            }

        });

        indiaPale.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String style = getString(R.string.btn_ipa);
                String description = getString(R.string.ipa_detail);

                Intent pale = new Intent(getApplicationContext(), StyleDetail.class);

                pale.putExtra("style", style);
                pale.putExtra("description", description);

                startActivity(pale);
            }

        });

        brownAle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String style = getString(R.string.btn_ba);
                String description = getString(R.string.ba_detail);

                Intent pale = new Intent(getApplicationContext(), StyleDetail.class);

                pale.putExtra("style", style);
                pale.putExtra("description", description);

                startActivity(pale);
            }

        });

        stout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String style = getString(R.string.btn_stout);
                String description = getString(R.string.stout_detail);

                Intent pale = new Intent(getApplicationContext(), StyleDetail.class);

                pale.putExtra("style", style);
                pale.putExtra("description", description);

                startActivity(pale);
            }

        });

        porter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String style = getString(R.string.btn_porter);
                String description = getString(R.string.porter_detail);

                Intent pale = new Intent(getApplicationContext(), StyleDetail.class);

                pale.putExtra("style", style);
                pale.putExtra("description", description);

                startActivity(pale);
            }

        });

        hfw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String style = getString(R.string.btn_hfw);
                String description = getString(R.string.hfw_detail);

                Intent pale = new Intent(getApplicationContext(), StyleDetail.class);

                pale.putExtra("style", style);
                pale.putExtra("description", description);

                startActivity(pale);
            }

        });

        amber.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String style = getString(R.string.btn_amber);
                String description = getString(R.string.amber_detail);

                Intent pale = new Intent(getApplicationContext(), StyleDetail.class);

                pale.putExtra("style", style);
                pale.putExtra("description", description);

                startActivity(pale);
            }

        });

        pils.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String style = getString(R.string.btn_pils);
                String description = getString(R.string.pils_detail);

                Intent pale = new Intent(getApplicationContext(), StyleDetail.class);

                pale.putExtra("style", style);
                pale.putExtra("description", description);

                startActivity(pale);
            }

        });

        bock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String style = getString(R.string.btn_bock);
                String description = getString(R.string.bock_detail);

                Intent pale = new Intent(getApplicationContext(), StyleDetail.class);

                pale.putExtra("style", style);
                pale.putExtra("description", description);

                startActivity(pale);
            }

        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent back = new Intent(getApplicationContext(), Learn.class);

                startActivity(back);
            }

        });


    }
}
