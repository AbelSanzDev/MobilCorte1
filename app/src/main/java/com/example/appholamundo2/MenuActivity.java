package com.example.appholamundo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity {

    private CardView crvHola,crvImc,crvCotizacion,crvConversion,crvMoneda,crvSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        iniciarComponetes();

        crvHola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        crvImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,IMC.class);
                startActivity(intent);
            }
        });
        crvConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Conversion_grados.class);
                startActivity(intent);
            }
        });
        crvMoneda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, monedasActivity.class);
                startActivity(intent);
            }
        });
        crvCotizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MainCotizacion.class);
                startActivity(intent);
            }
        });
        crvSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, SpinnerPersonalizado.class);
                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void iniciarComponetes(){
        crvHola = (CardView) findViewById(R.id.crvHola);
        crvImc = (CardView) findViewById(R.id.crvImc);
        crvCotizacion = (CardView) findViewById(R.id.crvCotizacion);
        crvConversion = (CardView) findViewById(R.id.crvConversion);
        crvMoneda = (CardView) findViewById(R.id.crvMoneda);
        crvSpinner = (CardView) findViewById(R.id.crvSpinner);
    }
}