package com.bollos18.actividad8;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Carga el layout que contiene el NavHostFragment (el contenedor de navegación)
        setContentView(R.layout.activity_main);
    }
}
