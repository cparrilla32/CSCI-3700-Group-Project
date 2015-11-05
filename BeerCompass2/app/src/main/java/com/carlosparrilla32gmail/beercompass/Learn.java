package com.carlosparrilla32gmail.beercompass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by GreyFox32 on 4/29/2015.
 */
public class Learn extends Activity
{
    Button whatCraft;
    Button styles;
    Button ingredients;
    Button back;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        whatCraft = (Button) findViewById(R.id.craft);
        styles = (Button) findViewById(R.id.styles);
        ingredients = (Button) findViewById(R.id.ingredients);
        back = (Button) findViewById(R.id.bck);

        whatCraft.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {

                Intent craft = new Intent(getApplicationContext(), Craft.class);

                startActivity(craft);
            }

        });

        styles.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {

                Intent styles = new Intent(getApplicationContext(), Styles.class);

                startActivity(styles);
            }

        });

        ingredients.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {

                Intent ingredients = new Intent(getApplicationContext(), Ingredients.class);

                startActivity(ingredients);
            }

        });

        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {

                Intent back = new Intent(getApplicationContext(), Main.class);

                startActivity(back);
            }

        });


    }
}
