package com.example.appholamundo2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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
        tvNombreTrabajadorCalculo.setText(nombreTrabajador);
        etNombre.setText(nombreTrabajador);

        btnCalcular.setOnClickListener(view -> calcularNomina());
        btnLimpiar.setOnClickListener(view -> limpiarCampos());
        btnRegresar.setOnClickListener(view -> finish());

    }
    private void calcularNomina() {
        int numRecibo = Integer.parseInt(etNumeroRecibo.getText().toString());
        String nombre = tvNombreTrabajadorCalculo.getText().toString();
        float horasTrabNormal = Float.parseFloat(etHorasTrabNormal.getText().toString());
        float horasTrabExtras = Float.parseFloat(etHorasExtras.getText().toString());

        int puesto = 0;
        if (rbAuxiliar.isChecked()) puesto = 1;
        if (rbAlbanil.isChecked()) puesto = 2;
        if (rbIngObra.isChecked()) puesto = 3;

        recibo.setNumRecibo(numRecibo);
        recibo.setNombre(nombre);
        recibo.setHorasTrabNormal(horasTrabNormal);
        recibo.setHorasTrabExtras(horasTrabExtras);
        recibo.setPuesto(puesto);

        float subtotal = recibo.calcularSubtotal();
        float impuesto = recibo.calcularImpuesto();
        float total = recibo.calcularTotal();

        tvSubtotal.setText(String.valueOf(subtotal));
        tvImpuesto.setText(String.valueOf(impuesto));
        tvTotalPagar.setText(String.valueOf(total));
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