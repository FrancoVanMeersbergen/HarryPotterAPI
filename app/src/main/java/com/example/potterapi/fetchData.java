package com.example.potterapi;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void,Void,Void>{
    String dataPupils ="";
    String dataParsedPupil ="";
    String singleParsedPupils="";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL urlPupils = new URL("https://www.potterapi.com/v1/characters?key=%242a%2410%241JEnmtEF417yBaFZcr51qukRjaKv8d5toEG5DKP%2FIUZWIVwfsaF7y");

            HttpURLConnection httpURLConnection = (HttpURLConnection) urlPupils.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                dataPupils = dataPupils + line;
            }


            JSONArray JA = new JSONArray(dataPupils);
            for(int i = 0; i <JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);

                String OOTP = "";
                if (JO.get("orderOfThePhoenix") == "false"){
                    OOTP = "No";
                }else{
                    OOTP= "Yes";
                }
                String MOM = "";
                if (JO.get("ministryOfMagic") == "false"){
                    MOM = "No";
                }else{
                    MOM= "Yes";
                }
                String DDA = "";
                if (JO.get("dumbledoresArmy") == "false"){
                    DDA = "No";
                }else{
                    DDA= "Yes";
                }
                String DE = "";
                if (JO.get("deathEater") == "false"){
                    DE = "No";
                }else{
                    DE= "Yes";
                }
                String Role = "";
                if (JO.get("role") == "")
                {
                    Role = "Unknown";
                }else
                {
                    Role = (String) JO.get("role");
                }
                String House = "";
                if (JO.get("house") == "")
                {
                    House = "Unknown";
                }else
                {
                    House = (String) JO.get("house");
                }
                String School = "";
                if (JO.get("school") == "")
                {
                    School = "Unknown";
                }else
                {
                    School = (String) JO.get("school");
                }
                String BloodStatus = "";
                if (JO.get("bloodStatus") != "")
                {
                    BloodStatus = (String) JO.get("bloodStatus");
                }else
                {
                    BloodStatus = "Unknown";
                }
                String Species = "";
                if (JO.get("species") != "")
                {
                    Species = (String) JO.get("species");
                }else
                {
                    Species = "Unknown";
                }

                singleParsedPupils = "Name: " + JO.get("name") + "\n"+
                        "Role: " + Role + "\n" +
                        "House: " + House + "\n"+
                        "School: " + School + "\n"+
                        "Ministry of Magic: " + MOM + "\n"+
                        "Order of the Phoenix: " + OOTP + "\n"+
                        "Dumbledore's Army: " + DDA + "\n"+
                        "Death Eater: " + DE + "\n"+
                        "Blood status: " + BloodStatus + "\n"+
                        "Species: " + Species + "\n";

                        dataParsedPupil = dataParsedPupil + singleParsedPupils;
            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        PupilsActivity.data.setText(this.dataParsedPupil);
    }
}
