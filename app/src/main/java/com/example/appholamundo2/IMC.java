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

public class IMC extends AppCompatActivity {

    private TextView lblResultado;
    private EditText txtAltura,txtPeso;
     private Button btnCalcular, btnLimpiar , btnCerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imc);

        lblResultado = (TextView) findViewById(R.id.lblResultado);
        txtAltura = (EditText) findViewById(R.id.txtAltura);
        txtPeso = (EditText) findViewById(R.id.txtPeso);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnCerrar = (Button) findViewById(R.id.btnCerrar);

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtPeso.setText("");
                txtAltura.setText("");

            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtaltura = txtAltura.getText().toString();
                String txtpeso = txtPeso.getText().toString();

                if(txtaltura.isEmpty() || txtpeso.isEmpty()){
                    Toast.makeText(IMC.this,"Ambos campos deben de estar completos", Toast.LENGTH_LONG).show();
                }else{
                    float altura = Float.parseFloat(txtaltura);
                    float peso = Float.parseFloat(txtpeso);

                    float imc =  peso/ (altura * altura);
                    String resultado = Float.toString(imc);

                    lblResultado.setText("Tu IMC ES DE " + resultado);
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