package com.example.appholamundo2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private TextView tvTitulo,tvNombreTrabajador,etNombre;
    private ImageView logoICG;
    private Button btnEntrar,btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        tvTitulo = findViewById(R.id.tvTitulo);
        tvNombreTrabajador = findViewById(R.id.tvNombreTrabajador);
        logoICG = findViewById(R.id.logoICG);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnSalir = findViewById(R.id.btnSalir);
        etNombre = findViewById(R.id.etNombre);


        btnEntrar.setOnClickListener(view -> {
            String nombreTrabajador = etNombre.getText().toString();
            Intent intent = new Intent(MainActivity2.this, ReciboNominalActivity.class);
            intent.putExtra("nombreTrabajador", nombreTrabajador);
            startActivity(intent);
        });

        btnSalir.setOnClickListener(view -> finish());


    }
}