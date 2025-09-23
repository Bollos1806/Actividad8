package com.bollos18.tema7; // ← cambia esto si es necesario

import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Scene sceneInitial;
    private Scene sceneFinal;
    private boolean showingInitial = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup sceneRoot = findViewById(R.id.sceneRoot);

        sceneInitial = Scene.getSceneForLayout(sceneRoot, R.layout.initial_layout, this);
        sceneFinal   = Scene.getSceneForLayout(sceneRoot, R.layout.final_layout, this);

        sceneInitial.enter();

        Button btn = findViewById(R.id.btnToggle);
        btn.setOnClickListener(v -> toggleScene());
    }

    private void toggleScene() {
        Transition explode = new Explode();
        Transition slide   = new Slide(Gravity.BOTTOM);
        Transition fade    = new Fade();

        TransitionSet set = new TransitionSet()
                .addTransition(explode)
                .addTransition(slide)
                .addTransition(fade)
                .setDuration(600);

        if (showingInitial) {
            TransitionManager.go(sceneFinal, set);
        } else {
            TransitionManager.go(sceneInitial, set);
        }

        showingInitial = !showingInitial;
    }
}
