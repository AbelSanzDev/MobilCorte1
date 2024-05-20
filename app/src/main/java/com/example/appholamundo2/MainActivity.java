package com.example.appholamundo2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView lblSaludo;
    private EditText txtSaludo;
    private Button btnPulsame,btnLimpiar,btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lblSaludo = (TextView) findViewById(R.id.lblSaludo);
        txtSaludo = (EditText) findViewById(R.id.txtNombre);
        btnPulsame = (Button) findViewById(R.id.btnPulsame);
        btnCerrar = (Button) findViewById(R.id.btnCerrar);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSaludo.setText("");
                lblSaludo.setText("");
            }
        });
        //condificar cerrar
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnPulsame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = txtSaludo.getText().toString();

                if (!nombre.isEmpty()) {
                    Toast.makeText(MainActivity.this, "¡Hola, " + nombre + "!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, ingresa tu nombre.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}