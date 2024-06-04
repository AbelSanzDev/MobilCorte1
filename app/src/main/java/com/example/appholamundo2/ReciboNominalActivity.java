package com.example.appholamundo2;

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
    private TextView tvTituloCalculo;
    private TextView tvNombreTrabajadorCalculo;
    private TextView tvNombreTrabajador;
    private EditText etNumeroRecibo;
    private EditText etHorasTrabNormal;
    private EditText etHorasExtras;
    private RadioGroup rgPuesto;
    private RadioButton rbAuxiliar;
    private RadioButton rbAlbanil;
    private RadioButton rbIngObra;
    private TextView tvSubtotal;
    private TextView tvImpuesto;
    private TextView tvTotalPagar;
    private Button btnCalcular;
    private Button btnLimpiar;
    private Button btnRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recibo_nominal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}