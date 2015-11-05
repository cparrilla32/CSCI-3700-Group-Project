package com.carlosparrilla32gmail.beercompass;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONAdapter extends BaseAdapter
{


    Context mContext;
    LayoutInflater mInflater;
    JSONArray mJsonArray;

    public JSONAdapter(Context context, LayoutInflater inflater)
    {
        mContext = context;
        mInflater = inflater;
        mJsonArray = new JSONArray();
    }

    @Override
    public int getCount() {
        return mJsonArray.length();
    }

    @Override
    public JSONObject getItem(int position)
    {
        return mJsonArray.optJSONObject(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        // check if the view already exists
        // if so, no need to inflate and findViewById again!
        if (convertView == null) {

            // Inflate the custom row layout from your XML.
            convertView = mInflater.inflate(R.layout.beer_row, null);

            // create a new "Holder" with subviews
            holder = new ViewHolder();
            holder.thumbnailImageView = (ImageView) convertView.findViewById(R.id.img_thumbnail);
            holder.nameTextView = (TextView) convertView.findViewById(R.id.text_name);
            holder.breweryTextView = (TextView) convertView.findViewById(R.id.text_brewery);

            // hang onto this holder for future recyclage
            convertView.setTag(holder);
        }
        else
        {


            // skip all the expensive inflation/findViewById
            // and just get the holder you already made
            holder = (ViewHolder) convertView.getTag();
        }

        // Get the current book's data in JSON form
        JSONObject jsonObject = (JSONObject) getItem(position);

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
        String brewery = null;
        try
        {
             brewery = breweries.getJSONObject(0).getString("name");
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }


// See if there is a cover ID in the Object
        if (jsonObject.has("labels"))
        {

            // If so, grab the Cover ID out from the object
            String imageID = jsonObject.optString("cover_i");

            // Construct the image URL (specific to API)
            String imageURL = labels.optString("medium");

            // Use Picasso to load the image
            // Temporarily have a placeholder in case it's slow to load
            Picasso.with(mContext).load(imageURL).placeholder(R.mipmap.ic_launcher).into(holder.thumbnailImageView);
        }
        else
        {

            // If there is no cover ID in the object, use a placeholder
            holder.thumbnailImageView.setImageResource(R.mipmap.ic_launcher);
        }

        String beerName = "";
        String breweryName = "";

        if (jsonObject.has("name"))
        {
            beerName = jsonObject.optString("name");
        }

        breweryName = brewery;

// Send these Strings to the TextViews for display
        holder.nameTextView.setText(beerName);
        holder.breweryTextView.setText(breweryName);

        return convertView;
    }

    public void updateData(JSONArray jsonArray)
    {
        // update the adapter's dataset
        mJsonArray = jsonArray;
        notifyDataSetChanged();
    }

    private static class ViewHolder
    {
        public ImageView thumbnailImageView;
        public TextView nameTextView;
        public TextView breweryTextView;
    }




}