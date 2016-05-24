package com.dhruvvaishnav.sectionindexrecyclerview;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by dhruv.vaishnav on 23-05-2016.
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCountry = (RecyclerView) findViewById(R.id.rvCountry);
        rvCountry.setLayoutManager(new LinearLayoutManager(this));
        rvCountry.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        new AsyncCountryInitTask().execute();
    }


    /**
     * Get Country List From countries.dat file from Assets Folder.
     */
    private class AsyncCountryInitTask extends AsyncTask<Void, Void, ArrayList<CountryEntity>> {

        private ArrayList<CountryEntity> countryData;

        @Override
        protected ArrayList<CountryEntity> doInBackground(Void... params) {
            countryData = new ArrayList<>();
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(getAssets().open("countries.dat"), "UTF-8"));
                String line;
                while ((line = reader.readLine()) != null) {
                    //process line
                    CountryEntity c = new CountryEntity(line);
                    countryData.add(c);
                }
            } catch (IOException e) {
                //log the exception
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        //log the exception
                    }
                }
            }
            return countryData;
        }

        @Override
        protected void onPostExecute(ArrayList<CountryEntity> data) {
            if (data.size() > 0) {
                CountryAdapter countryAdapter = new CountryAdapter(MainActivity.this, data);
                rvCountry.setAdapter(countryAdapter);
            }
        }
    }
}
