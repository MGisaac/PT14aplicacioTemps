package com.isaac.pt14_maldonadoisaac.api;

import android.content.Context;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.isaac.pt14_maldonadoisaac.ui.listeners.OnTemperaturesListener;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Isaac on 02/01/2018.
 */

public class Descarregador extends AsyncTask<String, InputStream, InputStream> {

    Context context;
    OnTemperaturesListener listener;


    public Descarregador(Context context, OnTemperaturesListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected InputStream doInBackground(String... nomCiutats) {
        return getTemperaturesFromApi(nomCiutats[0]);
    }

    @Override
    protected void onPostExecute(InputStream inputStream) {
        super.onPostExecute(inputStream);
        listener.OnTemperaturesGotten(inputStream);
    }

    private InputStream getTemperaturesFromApi(String ciutat) {
        InputStream inputStream = null;
        try {
            URL url = Api.getTemperaturesUrl(ciutat);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            inputStream = urlConnection.getInputStream();
        }catch (MalformedURLException e){
            Toast.makeText(context, "URL no valida ", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error de conexió ", Toast.LENGTH_SHORT).show();
        }
        return inputStream;
    }
}