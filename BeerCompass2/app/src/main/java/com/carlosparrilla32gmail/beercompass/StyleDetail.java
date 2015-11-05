package com.carlosparrilla32gmail.beercompass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by GreyFox32 on 4/30/2015.
 */
public class StyleDetail extends Activity
{
    Button back;
    TextView style;
    TextView description;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_detail);

        back = (Button) findViewById(R.id.buttonBack);
        style = (TextView) findViewById(R.id.style);
        description = (TextView) findViewById(R.id.description);

        String styleText = this.getIntent().getExtras().getString("style");
        String descriptionText = this.getIntent().getExtras().getString("description");

        style.setText(styleText);
        description.setText(descriptionText);

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent back = new Intent(getApplicationContext(), Styles.class);

                startActivity(back);
            }

        });




    }
}
