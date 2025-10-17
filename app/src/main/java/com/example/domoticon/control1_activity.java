package com.example.domoticon;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.domoticon.databinding.ActivityControl1Binding;

public class control1_activity extends AppCompatActivity {
    private ActivityControl1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView((binding = ActivityControl1Binding.inflate(getLayoutInflater())).getRoot());

        ToggleButton boton1 = binding.toggleButton;
        ToggleButton boton2 = binding.toggleButton2;

        ImageView img1 = binding.imageView;
        ImageView img2 = binding.imageView2;


        boton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    img1.setImageResource(R.drawable.image);
                }else{
                    img1.setImageResource(R.drawable.image__5_);
                }
            }
        });

        boton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    img2.setImageResource(R.drawable.image);
                }else{

                    img2.setImageResource(R.drawable.image__5_);
                }
            }
        });

        ImageButton cambio = binding.imageButton;//Cuando pulsas este boton,
        //los botones q tienen las checkbox activada se cambian de posicion.

        cambio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox check1 = binding.checkBox;
                if (check1.isChecked()) {
                    //TODO cambio de imagen
                }

                CheckBox check2 = binding.checkBox2;
                if (check2.isChecked()) {
                    //TODO cambio de imagen
                }
            }
        });

    }
}