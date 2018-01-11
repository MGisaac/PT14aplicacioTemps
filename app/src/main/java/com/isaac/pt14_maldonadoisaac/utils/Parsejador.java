package com.isaac.pt14_maldonadoisaac.utils;

import android.util.Xml;

import com.isaac.pt14_maldonadoisaac.model.Bloc;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isaac on 02/01/2018.
 */

public class Parsejador {

    private static final String ETIQUETA_TIME = "time";
    private static final String ETIQUETA_TEMPERATURE ="temperature";
    private static final String ns = null;
    List<Bloc> blocList;

    public List<Bloc> parseja(InputStream inputStream)  throws XmlPullParserException, IOException  {
        blocList = new ArrayList<>();

        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(inputStream,null);
        int eventType = parser.getEventType();

        String hora =null;
        String temperatura = null;

        //while(parser.getEventType() != XmlPullParser.END_DOCUMENT){
         while(eventType != XmlPullParser.END_DOCUMENT){

            switch (eventType){

                case XmlPullParser.START_TAG:

                    String tagName = parser.getName();

                    if(tagName.equals(ETIQUETA_TIME)){
                        // 2018-01-10T09:00:00
                        hora = parser.getAttributeValue(0);
                    }else if(tagName.equals(ETIQUETA_TEMPERATURE)){
                        //12.71
                        temperatura = parser.getAttributeValue(1);
                    }
                    break;
            }
            eventType=parser.next();

            if(temperatura != null && hora !=null){
                Bloc bloc = new Bloc(hora,temperatura);
                blocList.add(bloc);

                temperatura = null;
                hora = null;
            }

        }

        return blocList;
}
}
