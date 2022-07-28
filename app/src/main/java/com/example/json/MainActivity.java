package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

Button crear, leer;
TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crear = (Button) findViewById(R.id.btnCrear);
        leer = (Button) findViewById(R.id.btnAgregar);
        texto = (TextView) findViewById(R.id.lblJson);

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    createJSON();
                }catch (JSONException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

    }
    public void createJSON()throws JSONException, IOException{
        JSONArray jsonArray = new JSONArray();
        JSONObject objeto;

        objeto = new JSONObject();
        objeto.put("Nombre:","Juan");
        objeto.put("Apellido:", "Perez");
        objeto.put("Edad:",20);
        jsonArray.put(objeto);
        objeto = new JSONObject();
        objeto.put("Nombre:","Osvaldo");
        objeto.put("Apellido","Solano");
        objeto.put("Edad:",23);
        jsonArray.put(objeto);
        objeto = new JSONObject();
        objeto.put("Nombre:","Sebastian");
        objeto.put("Apellido","Solano");
        objeto.put("Edad:",2);
        jsonArray.put(objeto);

        String text = jsonArray.toString();

        FileOutputStream fo = openFileOutput("objeto",MODE_PRIVATE);
        fo.write(text.getBytes());
        fo.close();
        texto.setText(jsonArray.toString());

    }

}