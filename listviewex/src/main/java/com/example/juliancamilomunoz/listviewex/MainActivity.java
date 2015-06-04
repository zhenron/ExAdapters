package com.example.juliancamilomunoz.listviewex;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private ListView LVNames;
    private ListaEntrada[] my_data =
            new ListaEntrada[] {
                    new ListaEntrada(R.drawable.superman, "Superman", "Clark Kent", "1938"),
                    new ListaEntrada(R.drawable.flash, "Flash", "Barry Allen", "1940"),
                    new ListaEntrada(R.drawable.wonderwoman, "Mujer Maravilla", "Diana", "1941"),
                    new ListaEntrada(R.drawable.aquaman, "Acuaman", "Arthur Curry", "1941")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adapter my_adapter = new Adapter(this, my_data);

        LVNames = (ListView) findViewById(R.id.ListView);
        LVNames.setAdapter(my_adapter);

        LVNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String my_OptionSelected = ((ListaEntrada)parent.getItemAtPosition(position)).getNombre();
                Toast.makeText(MainActivity.this, my_OptionSelected, Toast.LENGTH_SHORT).show();
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

    public class Adapter extends ArrayAdapter<ListaEntrada> {
        public Adapter(Context context, ListaEntrada[] my_data){
            super(context,R.layout.list_item, my_data);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater my_inflater = LayoutInflater.from(getContext());
            View item = my_inflater.inflate(R.layout.list_item,null);

            TextView my_name = (TextView) item.findViewById(R.id.tnombre);
            my_name.setText(my_data[position].getNombre());

            TextView my_name_pila = (TextView) item.findViewById(R.id.tnomPila);
            my_name_pila.setText(my_data[position].getNombrePila());

            TextView my_year = (TextView) item.findViewById(R.id.tyear);
            my_year.setText(my_data[position].getFecha());

            ImageView my_image = (ImageView) item.findViewById(R.id.imagen);
            my_image.setImageResource(my_data[position].getIdImagen());

            return (item);
        }
    }
}
