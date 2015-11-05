package com.carlosparrilla32gmail.beercompass;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;


public class Search extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener
{

    TextView mainTextView;
    Button mainButton;
    Button back;
    EditText mainEditText;
    ListView mainListView;

    JSONAdapter mJSONAdapter;

    ProgressDialog mDialog;



    private static final String QUERY_URL = "http://api.brewerydb.com/v2/search?&key=4f14ac540344892afc075b30eb4a99ab&type=beer&withBreweries=y&q=";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mainTextView = (TextView) findViewById(R.id.main_textview);

        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);

        back = (Button) findViewById(R.id.btnBack);

        mainEditText = (EditText) findViewById(R.id.main_edittext);

        mainListView = (ListView) findViewById(R.id.main_listview);

        mJSONAdapter = new JSONAdapter(this, getLayoutInflater());
        mainListView.setAdapter(mJSONAdapter);
        mainListView.setOnItemClickListener(this);

        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Searching for Beer");
        mDialog.setCancelable(false);

        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {

                Intent main = new Intent(getApplicationContext(), Main.class);

                startActivity(main);
            }

        });

    }


    @Override
    public void onClick(View v)
    {
        queryBeers(mainEditText.getText().toString());
    }

    /*
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        JSONObject jsonObject = (JSONObject) mJSONAdapter.getItem(position);
        String coverID = jsonObject.optString("cover_i","");

        // create an Intent to take you over to a new DetailActivity
        Intent detailIntent = new Intent(this, DetailActivity.class);

        // pack away the data about the cover
        // into your Intent before you head out
        detailIntent.putExtra("coverID", coverID);

        // TODO: add any other data you'd like as Extras

        // start the next Activity using your prepared Intent
        startActivity(detailIntent);
    }*/


    private void queryBeers(String searchString)
    {

        // Prepare your search string to be put in a URL
        // It might have reserved characters or something
        String urlString = "";
        try
        {
            urlString = URLEncoder.encode(searchString, "UTF-8");
        }   catch (UnsupportedEncodingException e)
        {

            // if this fails for some reason, let the user know why
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        // Create a client to perform networking
        AsyncHttpClient client = new AsyncHttpClient();
        mDialog.show();

        // Have the client get a JSONArray of data
        // and define how to respond
        client.get(QUERY_URL + urlString,
                new JsonHttpResponseHandler()
                {

                    @Override
                    public void onSuccess(JSONObject jsonObject)
                    {
                        mDialog.dismiss();
                        // Display a "Toast" message
                        // to announce your success
                        Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();
                        Log.d("beer compass", jsonObject.toString());
                        mJSONAdapter.updateData(jsonObject.optJSONArray("data"));
                    }

                    @Override
                    public void onFailure(int statusCode, Throwable throwable, JSONObject error)
                    {
                        mDialog.dismiss();
                        // Display a "Toast" message
                        // to announce the failure
                        Toast.makeText(getApplicationContext(), "Error: " + statusCode + " " + throwable.getMessage(), Toast.LENGTH_LONG).show();

                        // Log error message
                        // to help solve any problems
                        Log.e("beer compass", statusCode + " " + throwable.getMessage());
                    }
                });
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        JSONObject jsonObject = (JSONObject) mJSONAdapter.getItem(position);

        JSONObject labels = null;
        try
        {
            labels = jsonObject.getJSONObject("labels");
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        JSONArray breweries = null;
        try
        {
            breweries = jsonObject.getJSONArray("breweries");
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        String beerName = jsonObject.optString("name","");
        String beerDescription = jsonObject.optString("description","");
        String beerImage = labels.optString("large", "");
        String abv = jsonObject.optString("abv", "");
        String ibu = jsonObject.optString("ibu", "");

        String breweryName = null;
        try
        {
            breweryName = breweries.getJSONObject(0).getString("name");
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }


        // create an Intent to take you over to a new DetailActivity
        Intent detailIntent = new Intent(this, DetailActivity.class);

        // pack away the data about the cover
        // into your Intent before you head out
        detailIntent.putExtra("beerName", beerName);
        detailIntent.putExtra("beerDesc", beerDescription);
        detailIntent.putExtra("beerImage", beerImage);
        detailIntent.putExtra("breweryName", breweryName);
        detailIntent.putExtra("abv", abv);
        detailIntent.putExtra("ibu", ibu);



        // start the next Activity using your prepared Intent
        startActivity(detailIntent);
    }


}