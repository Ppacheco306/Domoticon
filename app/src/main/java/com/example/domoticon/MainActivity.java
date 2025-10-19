package com.example.domoticon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.domoticon.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());


        Spinner spinner = binding.dispositivos;

        // Defino los valores y el adaptador
        String[] opciones = {" ", "2", "3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.spinner_textview, // layout para el texto seleccionado
                opciones
        );
        adapter.setDropDownViewResource(R.layout.spinner_textview);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String opcion = parent.getItemAtPosition(position).toString();
                switch (opcion){
                    case "2":
                        startActivity(new Intent(MainActivity.this , Control1Activity.class));
                    break;
                    case "3":
                        startActivity(new Intent(MainActivity.this , Control2Activity.class));
                    break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



}