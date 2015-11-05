package com.carlosparrilla32gmail.beercompass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by GreyFox32 on 4/29/2015.
 */
public class Craft extends Activity
{
    Button back;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_craft);

        back = (Button) findViewById(R.id.backButton);

        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {

                Intent learn = new Intent(getApplicationContext(), Learn.class);

                startActivity(learn);
            }

        });
    }

}
