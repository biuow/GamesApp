package com.android.alex.alexp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IMCActivity extends AppCompatActivity {
    private EditText et_peso;
    private EditText et_altura;
    private Button btn_calcular;
    private TextView tv_imc;
    private TextView tv_resultado;
    private String player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imc);

        et_peso = (EditText) findViewById(R.id.et_peso);
        et_altura = (EditText) findViewById(R.id.et_altura);
        btn_calcular = (Button) findViewById(R.id.btn_calcular);
        tv_imc = (TextView) findViewById(R.id.tv_imc);
        tv_resultado = (TextView) findViewById(R.id.tv_resultado);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        player = (String) b.get("nome");

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int peso = Integer.parseInt(et_peso.getText().toString());
                float altura = Float.parseFloat(et_altura.getText().toString());
                float resultado = peso / (altura * altura);
                String toastResultado = String.valueOf(resultado);

                tv_imc.setText(player + ", seu IMC é de "+String.format("%.2f", resultado));
                //
                if(resultado < 19){
                    tv_resultado.setText("Abaixo peso, procure seu médico!");
                }else if(resultado > 32){
                    tv_resultado.setText("Acima peso, procure seu médico!");
                }else{
                    tv_resultado.setText("Parabéns você está dentro do peso " +
                            "correto, mesmo assim visite o médico regularmente!");
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(getBaseContext(),"Lembre-se de se cuidar! :)",Toast.LENGTH_LONG).show();
    }
}
