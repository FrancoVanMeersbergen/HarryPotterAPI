package com.example.potterapi;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class fetchSpells extends AsyncTask<Void,Void,Void> {
    String dataSpells = "";
    String dataParsedSpells ="";
    String singleParsedSpells="";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL urlPupils = new URL("https://www.potterapi.com/v1/spells?key=%242a%2410%241JEnmtEF417yBaFZcr51qukRjaKv8d5toEG5DKP%2FIUZWIVwfsaF7y");

            HttpURLConnection httpURLConnection = (HttpURLConnection) urlPupils.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                dataSpells = dataSpells + line;
            }

            JSONArray JA = new JSONArray(dataSpells);
            for (int i = 0; i < JA.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsedSpells = "Spell: " + JO.get("spell") + "\n" +
                        "Type: " + JO.get("type") + "\n" +
                        "Effect: " + JO.get("effect") + "\n"+
                        "\n";

                dataParsedSpells = dataParsedSpells + singleParsedSpells;
            }


        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (
                JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        SpellsActivity.data.setText(this.dataParsedSpells);
    }
}
