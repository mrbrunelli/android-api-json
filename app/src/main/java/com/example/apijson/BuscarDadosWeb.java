package com.example.apijson;

import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

public class BuscarDadosWeb extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>> {

    @Override
    protected ArrayList<HashMap<String, String>> doInBackground(String... strings) {
        ArrayList<HashMap<String, String>> listaDados = new ArrayList<HashMap<String, String>>();
        try {
            String link = strings[0];
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            connection.setDoInput(true);
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String linha;
            while ((linha = reader.readLine()) != null) {
                JSONArray ja = new JSONArray(linha);
                for (int i = 0; i < ja.length(); i++) {
                    JSONObject jo = ja.getJSONObject(i);
                    HashMap<String, String> item = new HashMap<>();
                    item.put("codigo", jo.getString("Emi_Codigo"));
                    item.put("nome", jo.getString("Emi_Nome"));
                    item.put("imagem", jo.getString("Emi_Logo"));
                    listaDados.add(item);
                }
            }
        } catch (Exception ex) {

        }
        return listaDados;
    }
}
