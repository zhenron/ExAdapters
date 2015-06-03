package com.example.juliancamilomunoz.exadapters;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Spinner SNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ArrayAdapter<CharSequence> my_adapter = ArrayAdapter.createFromResource(this,R.array.names_array, android.R.layout.simple_spinner_item);
        //Mejor asignar de una vez el tipo de layout que verdaderamente se quiere para el Spinner, y se arrora la linea de mas abajo
        ArrayAdapter<CharSequence> my_adapter = ArrayAdapter.createFromResource(this, R.array.names_array, android.R.layout.simple_spinner_dropdown_item);
        SNames = (Spinner) findViewById(R.id.SpinnerNames);
        //my_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SNames.setAdapter(my_adapter);

        SNames.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this, String.valueOf((CharSequence) parent.getItemAtPosition(position)), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
