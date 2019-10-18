package com.example.crytal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;


public class MainActivity extends AppCompatActivity implements Observer {

    private Button left,rigth,atcar, saltar;

    private Comunicacion com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control);
        com = Comunicacion.instancia();
        com.addObserver(this);

        left = findViewById(R.id.rigth);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             com.enviar("left");
            }
        });

        rigth = findViewById(R.id.right);
        rigth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.enviar("rigth");
            }
        });



        atcar = findViewById(R.id.fire);
        atcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.enviar("down");
            }
        });

        saltar = findViewById(R.id.jump);
        saltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.enviar("atacar");
            }
        });


    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
