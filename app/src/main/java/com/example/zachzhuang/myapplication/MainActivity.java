package com.example.zachzhuang.myapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> things;
    private EditText thing;
    private ArrayAdapter<String> adapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        things = new ArrayList<String>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thing = (EditText) findViewById(R.id.newThing);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, things);
        ListView toDoList = (ListView) findViewById(R.id.toDoList);
        toDoList.setAdapter(adapter);
        toDoList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
              @Override
              public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                  things.remove(position);
                  adapter.notifyDataSetChanged();
                  return false;
              }
        });
    }

    public void addThings(View view) {
        String thingToDo = thing.getText().toString();
        things.add(thingToDo);
        adapter.notifyDataSetChanged();
    }

}