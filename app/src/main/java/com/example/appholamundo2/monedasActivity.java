package com.example.appholamundo2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class monedasActivity extends AppCompatActivity {
    private EditText txtCantidad;
    private Spinner spmMoneda;
    private TextView txtResultado;
    private Button btnCalcular, btnLimpiar, btnCerrar;
    private int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monedas);

        txtCantidad = findViewById(R.id.txtCantidad);
        spmMoneda = findViewById(R.id.SpmMoneda);
        txtResultado = findViewById(R.id.txtResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnCerrar = findViewById(R.id.btnCerrar);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.monedas));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spmMoneda.setAdapter(adapter);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCantidad.setText("");
                txtResultado.setText("Resultado: ");
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtCantidad.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fallo al capturar", Toast.LENGTH_SHORT).show();
                } else {
                    float cantidad = Float.parseFloat(txtCantidad.getText().toString());
                    switch (pos) {
                        case 0: // peso a dolares
                            convertidor(cantidad, 16.64f);
                            break;
                        case 1: // pesos a dolar canadiense
                            convertidor(cantidad, 12.22f);
                            break;
                        case 2: // peso a euro
                            convertidor(cantidad, 18.12f);
                            break;
                        case 3: // peso a libras
                            convertidor(cantidad, 21.27f);
                            break;
                        default:
                            break;
                    }
                }
            }
        });

        spmMoneda.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No hacer nada
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void convertidor(float cantidad, float moneda) {
        float resultado = cantidad / moneda;
        txtResultado.setText("Resultado: " + resultado);
    }
}
