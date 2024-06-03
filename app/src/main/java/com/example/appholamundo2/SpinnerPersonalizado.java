package com.example.appholamundo2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class SpinnerPersonalizado extends AppCompatActivity {

    private Button btnCerrar;
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_personalizado);
        btnCerrar = findViewById(R.id.btnCerrar);

        ArrayList<ItemData> list = new ArrayList<>();
        list.add(new ItemData(getString(R.string.itemFrappses), getString(R.string.msgFrapses), R.drawable.categorias));
        list.add(new ItemData(getString(R.string.itemAgradecimiento), getString(R.string.msgAgradecimiento), R.drawable.agradecimiento));
        list.add(new ItemData(getString(R.string.itemAmor), getString(R.string.msgAmor), R.drawable.corazon));
        list.add(new ItemData(getString(R.string.itemNewYear), getString(R.string.msgNewYear), R.drawable.nuevo));
        list.add(new ItemData(getString(R.string.itemCanciones), getString(R.string.msgCanciones), R.drawable.canciones));
        sp = findViewById(R.id.spinner1);
        SpinnerAdapter adapter = new SpinnerAdapter(this, R.layout.spinner_layout, R.id.lblCategorias, list);
        sp.setAdapter(adapter);

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),
                        getString(R.string.msgSeleccionado).toString() + " " + ((ItemData) parent.getItemAtPosition(position)).getTextCategoria(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
