package com.example.appholamundo2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CotizacionActivity extends AppCompatActivity {
    private EditText carDescriptionEditText, carPriceEditText, downPaymentPercentageEditText;
    private RadioGroup termRadioGroup;
    private Button calculateButton,btnLimpiar,btnCerrar;
    private TextView initialPaymentTextView,txtNombreCliente, monthlyPaymentTextView,folioTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cotizacion);

        carDescriptionEditText = findViewById(R.id.carDescriptionEditText);
        carPriceEditText = findViewById(R.id.carPriceEditText);
        downPaymentPercentageEditText = findViewById(R.id.downPaymentPercentageEditText);
        termRadioGroup = findViewById(R.id.termRadioGroup);
        calculateButton = findViewById(R.id.calculateButton);
        initialPaymentTextView = findViewById(R.id.initialPaymentTextView);
        monthlyPaymentTextView = findViewById(R.id.monthlyPaymentTextView);
        txtNombreCliente = findViewById(R.id.txtNombreCliente);
        btnCerrar = findViewById(R.id.btnCerrar);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        folioTextView = findViewById(R.id.folioTextView);


        String clientName = getIntent().getStringExtra("CLIENT_NAME");
        txtNombreCliente.setText(clientName);

        calculateButton.setOnClickListener(view -> calculateQuote());

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initialPaymentTextView.setText("Pago inicial: ");
                monthlyPaymentTextView.setText("Pago mensual: ");
                folioTextView.setText("Folio: ");
                carDescriptionEditText.setText("");
                carPriceEditText.setText("");
                downPaymentPercentageEditText.setText("");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void calculateQuote() {
        String carPriceStr = carPriceEditText.getText().toString();
        String downPaymentPercentageStr = downPaymentPercentageEditText.getText().toString();
String carDescriptionEditTextStr = carDescriptionEditText.getText().toString();
        if (carPriceStr.isEmpty() || downPaymentPercentageStr.isEmpty() ||  carDescriptionEditTextStr.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Faltan datos por llenar", Toast.LENGTH_SHORT).show();
            return;
        }
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        int sixDigitNumber = (int) (Math.random() * 900000) + 100000;
        String folio = Integer.toString(sixDigitNumber);
        folioTextView.setText("Folio: " + folio);

        double carPrice = Double.parseDouble(carPriceStr);
        double downPaymentPercentage = Double.parseDouble(downPaymentPercentageStr) / 100;

        double downPayment = carPrice * downPaymentPercentage;
        double totalToFinance = carPrice - downPayment;

        int selectedTermId = termRadioGroup.getCheckedRadioButtonId();
        int term = 0;

        if (selectedTermId == R.id.term12) {
            term = 12;
        } else if (selectedTermId == R.id.term18) {
            term = 18;
        } else if (selectedTermId == R.id.term24) {
            term = 24;
        } else if (selectedTermId == R.id.term36) {
            term = 36;
        }

        double monthlyPayment = totalToFinance / term;

        initialPaymentTextView.setText("Pago inicial: $" + String.format("%.2f", downPayment));
        monthlyPaymentTextView.setText("Pago mensual: $" + String.format("%.2f", monthlyPayment));
    }
}