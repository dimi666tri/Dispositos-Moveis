package com.ifsc.onclick;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edpeso,edaltura;
    TextView tvresultado;
    Button bntCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edpeso=findViewById(R.id.edPeso);
        edaltura = findViewById(R.id.edAltura);
        tvresultado = findViewById(R.id.tvResultado);
        bntCalcular= findViewById(R.id.button);

        bntCalcular.setOnClickListener(v -> {
        double peso,altura,imc;
        peso=Double.parseDouble(edpeso.getText().toString());
        altura=Double.parseDouble(edaltura.getText().toString());
        imc = peso/(altura*altura);
        tvresultado.setText(Double.toString(imc));
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}