package com.example.appholamundo2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ReciboNominalActivity extends AppCompatActivity {
    private ReciboNomina recibo;
    private TextView tvTituloCalculo,tvNombreTrabajadorCalculo,etNombre;
    private EditText etNumeroRecibo,etHorasTrabNormal,etHorasExtras;
    private RadioGroup rgPuesto;
    private RadioButton rbAuxiliar,rbAlbanil,rbIngObra;
    private TextView tvSubtotal,tvImpuesto,tvTotalPagar;
    private Button btnCalcular,btnLimpiar,btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recibo_nominal);
        recibo = new ReciboNomina();

        tvTituloCalculo = findViewById(R.id.tvTituloCalculo);
        tvNombreTrabajadorCalculo = findViewById(R.id.tvNombreTrabajadorCalculo);
        etNombre = findViewById(R.id.etNombre);
        etNumeroRecibo = findViewById(R.id.etNumeroRecibo);
        etHorasTrabNormal = findViewById(R.id.etHorasTrabajadas);
        etHorasExtras = findViewById(R.id.etHorasExtras);
        rgPuesto = findViewById(R.id.rgPuesto);
        rbAuxiliar = findViewById(R.id.rbAuxiliar);
        rbAlbanil = findViewById(R.id.rbAlbanil);
        rbIngObra = findViewById(R.id.rbIngObra);
        tvSubtotal = findViewById(R.id.tvSubtotal);
        tvImpuesto = findViewById(R.id.tvImpuesto);
        tvTotalPagar = findViewById(R.id.tvTotalPagar);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);

        Intent intent = getIntent();
        String nombreTrabajador = intent.getStringExtra("nombreTrabajador");
        int sixDigitNumber = (int) (Math.random() * 900000) + 100000;
        String numero = Integer.toString(sixDigitNumber);
        etNumeroRecibo.setText(numero);
        tvNombreTrabajadorCalculo.setText(nombreTrabajador);
        etNumeroRecibo.setText(numero);
        etNombre.setText(nombreTrabajador);

        btnCalcular.setOnClickListener(view -> calcularNomina());
        btnLimpiar.setOnClickListener(view -> limpiarCampos());
        btnRegresar.setOnClickListener(view -> finish());

    }
    private void calcularNomina() {
        String nombre = tvNombreTrabajadorCalculo.getText().toString();
        String horasTrabNormalStr = etHorasTrabNormal.getText().toString();
        String horasTrabExtrasStr = etHorasExtras.getText().toString();

        if (nombre.isEmpty() || horasTrabNormalStr.isEmpty() || horasTrabExtrasStr.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        float horasTrabNormal;
        float horasTrabExtras;
        try {
            horasTrabNormal = Float.parseFloat(horasTrabNormalStr);
            horasTrabExtras = Float.parseFloat(horasTrabExtrasStr);
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Horas trabajadas deben ser números válidos", Toast.LENGTH_SHORT).show();
            return;
        }

        int puesto = 0;
        if (rbAuxiliar.isChecked()) puesto = 1;
        else if (rbAlbanil.isChecked()) puesto = 2;
        else if (rbIngObra.isChecked()) puesto = 3;
        else {
            Toast.makeText(getApplicationContext(), "Debe seleccionar un puesto", Toast.LENGTH_SHORT).show();
            return;
        }

        recibo.setNombre(nombre);
        recibo.setHorasTrabNormal(horasTrabNormal);
        recibo.setHorasTrabExtras(horasTrabExtras);
        recibo.setPuesto(puesto);

        float subtotal = recibo.calcularSubtotal();
        float impuesto = recibo.calcularImpuesto();
        float total = recibo.calcularTotal();

        tvSubtotal.setText(String.format("%.2f", subtotal));
        tvImpuesto.setText(String.format("%.2f", impuesto));
        tvTotalPagar.setText(String.format("%.2f", total));
    }

    private void limpiarCampos() {
        etNumeroRecibo.setText("");
        etHorasTrabNormal.setText("");
        etHorasExtras.setText("");
        rgPuesto.clearCheck();
        tvSubtotal.setText("");
        tvImpuesto.setText("");
        tvTotalPagar.setText("");
    }
}