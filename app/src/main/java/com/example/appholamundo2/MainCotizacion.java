package com.example.appholamundo2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainCotizacion extends AppCompatActivity {

    private EditText clientNameEditText;
    private Button quoteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_cotizacion);

        clientNameEditText = findViewById(R.id.clientNameEditText);
        quoteButton = findViewById(R.id.quoteButton);

        quoteButton.setOnClickListener(view -> {
            String clientName = clientNameEditText.getText().toString();
            if(clientName.isEmpty()){
                Toast.makeText(getApplicationContext(), "Faltan datos por llenar", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(MainCotizacion.this, CotizacionActivity.class);
            intent.putExtra("CLIENT_NAME", clientName);
            startActivity(intent);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}