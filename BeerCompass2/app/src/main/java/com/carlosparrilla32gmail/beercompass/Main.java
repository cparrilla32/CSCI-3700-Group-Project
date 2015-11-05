package com.carlosparrilla32gmail.beercompass;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.carlosparrilla32gmail.beercompass.library.DatabaseHandler;
import com.carlosparrilla32gmail.beercompass.library.UserFunctions;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class Main extends Activity
{
    Button btnSearch;
    Button btnRecommended;
    Button btnLearn;
    Button changepas;
    Button btnLogout;

     /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = (Button) findViewById(R.id.search);
        //btnRecommended = (Button) findViewById(R.id.recomended);
        btnLearn = (Button) findViewById(R.id.learn);
        changepas = (Button) findViewById(R.id.btchangepass);
        btnLogout = (Button) findViewById(R.id.logout);

        DatabaseHandler db = new DatabaseHandler(getApplicationContext());

        /**
         * Hashmap to load data from the Sqlite database
         **/
        HashMap<String,String> user = new HashMap<String, String>();
        user = db.getUserDetails();

        btnLearn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {

                Intent learn = new Intent(getApplicationContext(), Learn.class);

                startActivity(learn);
            }

        });

        btnSearch.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {

                Intent search = new Intent(getApplicationContext(), Search.class);

                startActivity(search);
            }

        });

        /**
         * Change Password Activity Started
         **/
        changepas.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {

                Intent chgpass = new Intent(getApplicationContext(), ChangePassword.class);

                startActivity(chgpass);
            }

        });

        /**
         *Logout from the User Panel which clears the data in Sqlite database
         **/
        btnLogout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0)
            {

                UserFunctions logout = new UserFunctions();
                logout.logoutUser(getApplicationContext());
                Intent login = new Intent(getApplicationContext(), Login.class);
                login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(login);
                finish();
            }
        });
/**
 * Sets user first name and last name in text view.
 **/
        final TextView login = (TextView) findViewById(R.id.textwelcome);
        login.setText("Welcome  "+user.get("fname"));
        final TextView lname = (TextView) findViewById(R.id.lname);
        lname.setText(user.get("lname"));


    }


}
