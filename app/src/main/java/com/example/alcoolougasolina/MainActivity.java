package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPriceAlcool;
    private EditText editPriceGas;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPriceAlcool = findViewById(R.id.idPriceAlccol);
        editPriceGas    = findViewById(R.id.idPriceGas);
        result          = findViewById(R.id.idResultado);
    }

    public void Calculate(View view)
    {
        String priceAlcool  = editPriceAlcool.getText().toString();
        String priceGas     = editPriceGas.getText().toString();
        if (emptyFilds(priceAlcool, priceGas))
        {
            result.setText("Um ou mais campos estão vazios!");
            return;
        }
        Double alcool = Double.parseDouble(priceAlcool);
        Double gas = Double.parseDouble(priceGas);

        if (alcool / gas >= 0.7d) result.setText("Melhor usar gasolina");
        else result.setText("Melhor usar alcool");

        cleanFilds();
    }

    private boolean emptyFilds(String fild1, String fild2)
    {
        return fild1.equals("") || fild2.equals("");
    }

    private void cleanFilds()
    {
        editPriceAlcool.setText("");
        editPriceGas.setText("");
    }
}