package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

public void calcularPreco (View view) {
String precoAlcool = editPrecoAlcool.getText().toString();
String precoGasolina = editPrecoGasolina.getText().toString();
Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

if (camposValidados) {
    Double valorAlcool = Double.parseDouble(precoAlcool);
    Double valorGasolina = Double.parseDouble(precoGasolina);

    Double resultado = valorAlcool / valorGasolina;

    if (resultado > 0.7) {
        textResultado.setText("Melhor usar Gasolina");
    } else {
        textResultado.setText("Melhor usar Alcool");
    }

}else {
    textResultado.setText("Preencha os preços primeiro");
}
}


public Boolean validarCampos (String alcool, String gasolina)  {
        Boolean camposValidados = true;

        if (alcool == null || alcool.equals("")) {
            camposValidados = false;
        } else if (gasolina == null || gasolina.equals("")){
            camposValidados = false;
        }
        return camposValidados;
}
}
