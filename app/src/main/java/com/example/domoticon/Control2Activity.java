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

import com.example.domoticon.databinding.ActivityControl2Binding;

public class Control2Activity extends AppCompatActivity {
    ActivityControl2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((binding = ActivityControl2Binding.inflate(getLayoutInflater())).getRoot());

        ToggleButton boton1 = binding.toggleButton3;
        ToggleButton boton2 = binding.toggleButton4;
        ToggleButton boton3 = binding.toggleButton5;

        ImageView img1 = binding.imageView3;
        ImageView img2 = binding.imageView4;
        ImageView img3 = binding.imageView5;

        Switch bloqueo = binding.switch2;


        if (savedInstanceState != null) {
            binding.toggleButton3.setChecked(savedInstanceState.getBoolean("estado_boton3"));
            binding.toggleButton4.setChecked(savedInstanceState.getBoolean("estado_boton4"));
            binding.toggleButton5.setChecked(savedInstanceState.getBoolean("estado_boton5"));

            binding.checkBox3.setChecked(savedInstanceState.getBoolean("estado_check3"));
            binding.checkBox4.setChecked(savedInstanceState.getBoolean("estado_check4"));
            binding.checkBox5.setChecked(savedInstanceState.getBoolean("estado_check5"));


            boolean bombilla1 = savedInstanceState.getBoolean("estado_imagenOn");
            boolean bombilla2 = savedInstanceState.getBoolean("estado_imagen2On");
            boolean bombilla3 = savedInstanceState.getBoolean("estado_imagen3On");

            binding.imageView3.setImageResource(bombilla1 ? R.drawable.idea__1_ : R.drawable.idea);
            binding.imageView4.setImageResource(bombilla2 ? R.drawable.idea__1_ : R.drawable.idea);
            binding.imageView5.setImageResource(bombilla3 ? R.drawable.idea__1_ : R.drawable.idea);

        }


        boton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(bloqueo.isChecked()){
                    Toast.makeText(getApplicationContext(), "Bloqueo activado", Toast.LENGTH_SHORT).show();
                }else {
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
                    if (isChecked) {
                        img2.setImageResource(R.drawable.idea__1_);
                    } else {
                        img2.setImageResource(R.drawable.idea);
                    }
                }
            }
        });

        boton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {

                if(bloqueo.isChecked()){
                    Toast.makeText(getApplicationContext(), "Bloqueo activado", Toast.LENGTH_SHORT).show();
                }else {
                    if (isChecked) {
                        img3.setImageResource(R.drawable.idea__1_);
                    } else {
                        img3.setImageResource(R.drawable.idea);
                    }
                }
            }
        });

        ImageButton cambio = binding.imageButton2;
        CheckBox check1 = binding.checkBox3;
        CheckBox check2 = binding.checkBox4;
        CheckBox check3 = binding.checkBox5;

        cambio.setOnClickListener(new View.OnClickListener() {
            ImageView imagen1 = binding.imageView3;
            ImageView imagen2 = binding.imageView4;
            ImageView imagen3 = binding.imageView5;
            final int imagenDefault = R.drawable.idea;
            final int imagenAlternar = R.drawable.idea__1_;

            @Override
            public void onClick(View v) {
                Drawable imgActual1 = imagen1.getDrawable();
                Drawable imgActual2 = imagen2.getDrawable();
                Drawable imgActual3 = imagen3.getDrawable();

                Drawable def = ContextCompat.getDrawable(v.getContext(), imagenDefault);
                Drawable alt = ContextCompat.getDrawable(v.getContext(), imagenAlternar);

                if(!bloqueo.isChecked()){
                    if (check1.isChecked()) {
                        if (imgActual1 != null && imgActual1.getConstantState() != null &&
                                imgActual1.getConstantState().equals(def.getConstantState())) {
                            imagen1.setImageResource(imagenAlternar);
                        } else {
                            imagen1.setImageResource(imagenDefault);
                        }
                    }

                    if (check2.isChecked()) {
                        if (imgActual2 != null && imgActual2.getConstantState() != null &&
                                imgActual2.getConstantState().equals(def.getConstantState())) {
                            imagen2.setImageResource(imagenAlternar);
                        } else {
                            imagen2.setImageResource(imagenDefault);
                        }
                    }

                    if (check3.isChecked()) {
                        if (imgActual3 != null && imgActual3.getConstantState() != null &&
                                imgActual3.getConstantState().equals(def.getConstantState())) {
                            imagen3.setImageResource(imagenAlternar);
                        } else {
                            imagen3.setImageResource(imagenDefault);
                        }
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Bloqueo activado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {


        outState.putBoolean("estado_boton3", binding.toggleButton3.isChecked());
        outState.putBoolean("estado_boton4", binding.toggleButton4.isChecked());
        outState.putBoolean("estado_boton5", binding.toggleButton5.isChecked());
        outState.putBoolean("estado_check3", binding.checkBox3.isChecked());
        outState.putBoolean("estado_check4", binding.checkBox4.isChecked());
        outState.putBoolean("estado_check5", binding.checkBox4.isChecked());



        Drawable bombilla1 = binding.imageView3.getDrawable();
        Drawable bombilla2 = binding.imageView4.getDrawable();
        Drawable bombilla3 = binding.imageView5.getDrawable();

        Drawable bombillaOn = getDrawable(R.drawable.idea__1_);
        outState.putBoolean("estado_imagenOn", bombilla1.getConstantState().equals(bombillaOn.getConstantState()));
        outState.putBoolean("estado_imagen2On", bombilla2.getConstantState().equals(bombillaOn.getConstantState()));
        outState.putBoolean("estado_imagen3On", bombilla3.getConstantState().equals(bombillaOn.getConstantState()));

        super.onSaveInstanceState(outState);
    }
}