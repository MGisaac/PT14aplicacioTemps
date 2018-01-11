package com.isaac.pt14_maldonadoisaac.api;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Isaac on 10/01/2018.
 */

public class Api {
    public static final String API_KEY = "695fd144d201e07f66a9c1c8b78580e0";

    public static URL getTemperaturesUrl(String ciutat) throws MalformedURLException {
        return new URL("http://api.openweathermap.org/data/2.5/forecast?q="+ciutat+"&APPID="+API_KEY+"&mode=xml&unit=metric");
    }

}
