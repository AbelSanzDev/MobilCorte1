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

    private TextView tvTitulo,tvNombreTrabajador,tvTrabajadorNombre;
    private ImageView logoICG;
    private Button btnEntrar,btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        tvTitulo = findViewById(R.id.tvTitulo);
        tvNombreTrabajador = findViewById(R.id.tvNombreTrabajador);
        tvTrabajadorNombre = findViewById(R.id.tvTrabajadorNombre);
        logoICG = findViewById(R.id.logoICG);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnSalir = findViewById(R.id.btnSalir);


        btnEntrar.setOnClickListener(view -> {
            String nombreTrabajador = tvTrabajadorNombre.getText().toString();
            Intent intent = new Intent(MainActivity2.this, ReciboNominalActivity.class);
            intent.putExtra("nombreTrabajador", nombreTrabajador);
            startActivity(intent);
        });

        btnSalir.setOnClickListener(view -> finish());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}