package com.example.appholamundo2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Conversion_grados extends AppCompatActivity {
    private EditText txtCantidad;
    private RadioButton rdbCel, rdbFar;
    private TextView txtResultado;
    private Button btnCalcular, btnLimpiar, btnCerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_conversion_grados);

        txtCantidad = findViewById(R.id.txtCantidad);
        rdbCel = findViewById(R.id.rdbCel);
        rdbFar = findViewById(R.id.rdbFar);
        txtResultado = findViewById(R.id.txtResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnCerrar = findViewById(R.id.btnCerrar);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCantidad.setText("");
                txtResultado.setText("");
            }
        });
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cantidadStr = txtCantidad.getText().toString();
                if (!cantidadStr.isEmpty()) {
                    double cantidad = Double.parseDouble(cantidadStr);
                    double resultado;
                    if (rdbCel.isChecked()) {
                        resultado = (cantidad * 9 / 5) + 32;
                        txtResultado.setText("Resultado: " + resultado + " °F");
                    } else if (rdbFar.isChecked()) {
                        resultado = (cantidad - 32) * 5 / 9;
                        txtResultado.setText("Resultado: " + resultado + " °C");
                    }
                }else{
                    Toast.makeText(Conversion_grados.this,"El campo debe de ser completado", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}
