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

public class fetchHouses extends AsyncTask<Void,Void,Void> {
    String dataHouses ="";
    String dataParsedHouses ="";
    String singleParsedHouses="";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL urlHouses = new URL("https://www.potterapi.com/v1/houses?key=%242a%2410%241JEnmtEF417yBaFZcr51qukRjaKv8d5toEG5DKP%2FIUZWIVwfsaF7y");

            HttpURLConnection httpURLConnection = (HttpURLConnection) urlHouses.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                dataHouses = dataHouses + line;
            }

            JSONArray JA = new JSONArray(dataHouses);
            for (int i = 0; i < JA.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsedHouses = "Name: " + JO.get("name") + "\n" +
                        "Mascot: " + JO.get("mascot") + "\n" +
                        "Head Of House: " + JO.get("headOfHouse") + "\n" +
                        "House Ghost: " + JO.get("houseGhost") + "\n" +
                        "Founder: " + JO.get("founder") + "\n" +
                      //  "School: " + JO.get("school") + "\n" + there are inconsistencies in the data regarding certain fields,for example, Gryffindor has a school listed whereas Slytherin does not, this leaves Slytherin out of the displayed data.
                        "Values: " + JO.get("values") + "\n" +
                        "Colors: " + JO.get("colors") + "\n" +
                        "\n";

                dataParsedHouses = dataParsedHouses + singleParsedHouses;
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

        HousesActivity.data.setText(this.dataParsedHouses);
    }
}
