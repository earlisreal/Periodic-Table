package com.ama.periodictable;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by ching on 3/8/2017.
 */

public class Database {
    private Context context;

    private ArrayList<Element> elements;

    public Database(Context context) {
        this.context = context;
        elements = new ArrayList<>();

        InputStreamReader inputStreamReader = new InputStreamReader(context.getResources().openRawResource(R.raw.database));
        JsonReader reader = new JsonReader(inputStreamReader);

        elements = new ArrayList<>();

        try {
            reader.beginArray();
            Gson gson = new Gson();

            while (reader.hasNext()){
                Element element = gson.fromJson(reader, Element.class);
                elements.add(element);
            }

            reader.endArray();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Element> getElements(){
        return elements;
    }

    public Element getElement(int number){
        return elements.get(number - 1);
    }
}
