package com.example.domoticon;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.domoticon.databinding.ActivityControl1Binding;

public class Control1Activity extends AppCompatActivity {
    private ActivityControl1Binding binding;



    private boolean[] estado = {false, false}; //Esto es para guardar el estado de la imagen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((binding = ActivityControl1Binding.inflate(getLayoutInflater())).getRoot());



        ToggleButton boton1 = binding.toggleButton;
        ToggleButton boton2 = binding.toggleButton2;

        ImageView img1 = binding.imageView;
        ImageView img2 = binding.imageView2;

        Switch bloqueo = binding.switch1;

        if (savedInstanceState != null) {
            binding.toggleButton.setChecked(savedInstanceState.getBoolean("estado_boton1"));
            binding.toggleButton2.setChecked(savedInstanceState.getBoolean("estado_boton2"));
            binding.checkBox1.setChecked(savedInstanceState.getBoolean("estado_check1"));
            binding.checkBox2.setChecked(savedInstanceState.getBoolean("estado_check2"));

            boolean bombilla1 = savedInstanceState.getBoolean("estado_imagenOn");
            boolean bombilla2 = savedInstanceState.getBoolean("estado_imagen2On");

            binding.imageView.setImageResource(bombilla1 ? R.drawable.idea__1_ : R.drawable.idea);
            binding.imageView2.setImageResource(bombilla2 ? R.drawable.idea__1_ : R.drawable.idea);

        }



        boton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(bloqueo.isChecked()){
                    Toast.makeText(getApplicationContext(), "Bloqueo activado", Toast.LENGTH_SHORT).show();
                }else {
                    estado[0] = isChecked;
                    if (isChecked) {
                        img1.setImageResource(R.drawable.idea__1_);
                    } else {
                        img1.setImageResource(R.drawable.idea);
                    }
                }

            }
        });

        boton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {

                if(bloqueo.isChecked()){
                    Toast.makeText(getApplicationContext(), "Bloqueo activado", Toast.LENGTH_SHORT).show();
                }else {
                    estado[1] = isChecked;
                    if (isChecked) {
                        img2.setImageResource(R.drawable.idea__1_);
                    } else {
                        img2.setImageResource(R.drawable.idea);
                    }
                }
            }
        });

        ImageButton cambio = binding.imageButton;
        CheckBox check1 = binding.checkBox1;
        CheckBox check2 = binding.checkBox2;

        cambio.setOnClickListener(new View.OnClickListener() {
            ImageView imagen1 = binding.imageView;
            ImageView imagen2 = binding.imageView2;
            final int imagenDefault = R.drawable.idea;
            final int imagenAlternar = R.drawable.idea__1_;
            @Override
            public void onClick(View v) {
                Drawable imgActual1 = imagen1.getDrawable();
                Drawable imgActual2 = imagen2.getDrawable();
                Drawable def = ContextCompat.getDrawable(v.getContext(), imagenDefault);
                Drawable alt = ContextCompat.getDrawable(v.getContext(), imagenAlternar);
                if(!bloqueo.isChecked()){
                    if (check1.isChecked()) {
                        if (imgActual1.getConstantState().equals(def.getConstantState())) {
                            imagen1.setImageResource(imagenAlternar);
                        } else {
                            imagen1.setImageResource(imagenDefault);
                        }
                    }

                    if (check2.isChecked()) {
                        if (imgActual2.getConstantState().equals(def.getConstantState())) {
                            imagen2.setImageResource(imagenAlternar);
                        } else {
                            imagen2.setImageResource(imagenDefault);
                        }
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Bloqueo activado", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {


        outState.putBoolean("estado_boton1", binding.toggleButton.isChecked());
        outState.putBoolean("estado_boton2", binding.toggleButton2.isChecked());
        outState.putBoolean("estado_check1", binding.checkBox1.isChecked());
        outState.putBoolean("estado_check2", binding.checkBox2.isChecked());


        Drawable bombilla1 = binding.imageView.getDrawable();
        Drawable bombilla2 = binding.imageView2.getDrawable();
        Drawable bombillaOn = getDrawable(R.drawable.idea__1_);
        outState.putBoolean("estado_imagenOn", bombilla1.getConstantState().equals(bombillaOn.getConstantState()));
        outState.putBoolean("estado_imagen2On", bombilla2.getConstantState().equals(bombillaOn.getConstantState()));

        super.onSaveInstanceState(outState);
    }
}