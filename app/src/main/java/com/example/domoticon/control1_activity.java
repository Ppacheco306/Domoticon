package com.example.domoticon;

import android.os.Bundle;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
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



        CheckBox check1 = binding.
        if (check1.isChecked()) {
            // hacer algo
        }

    }
}