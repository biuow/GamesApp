package com.android.alex.alexp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class JoKenPoActivity  extends AppCompatActivity {

    private ImageButton btn_rck, btn_ppr, btn_scz;
    private Button btn_rst;
    private ImageView iv_player, iv_comp;
    private TextView tv_msg, tv_placar;
    private LinearLayout lay_resultado;
    int player_placar = 0, comp_placar = 0;

    // 1 - rock
    // 2 - paper
    // 3 - scissors

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokenpo);

        btn_rck = (ImageButton) findViewById(R.id.btn_rck);
        btn_ppr = (ImageButton) findViewById(R.id.btn_ppr);
        btn_scz = (ImageButton) findViewById(R.id.btn_scz);
        btn_rst = (Button) findViewById(R.id.btn_rst);
        iv_player = (ImageView) findViewById(R.id.iv_player);
        iv_comp = (ImageView) findViewById(R.id.iv_comp);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        tv_placar = (TextView) findViewById(R.id.tv_placar);
        lay_resultado = (LinearLayout) findViewById(R.id.lay_result);

        lay_resultado.setVisibility(LinearLayout.GONE);

        btn_rck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lay_resultado.setVisibility(LinearLayout.VISIBLE);
                int comp = geraComputador();
                calculaResultado(1,comp);
            }
        });

        btn_ppr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lay_resultado.setVisibility(LinearLayout.VISIBLE);
                int comp = geraComputador();
                calculaResultado(2,comp);
            }
        });

        btn_scz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lay_resultado.setVisibility(LinearLayout.VISIBLE);
                int comp = geraComputador();
                calculaResultado(3,comp);
            }
        });

        btn_rst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player_placar = 0;
                comp_placar = 0;
                lay_resultado.setVisibility(LinearLayout.GONE);
            }
        });
    }

    private int geraComputador(){
        Random rand = new Random();
        int n = rand.nextInt(3);
        if(n < 1){
            return 1;
        }else if(n < 2){
            return 2;
        }else {
            return 3;
        }
    }

    private void calculaResultado(int j, int c){

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(j == 1) iv_player.setImageResource(R.drawable.jkp_rock);
        if(j == 2) iv_player.setImageResource(R.drawable.jkp_paper);
        if(j == 3) iv_player.setImageResource(R.drawable.jkp_scizor);

        if(c == 1) iv_comp.setImageResource(R.drawable.jkp_rock);
        if(c == 2) iv_comp.setImageResource(R.drawable.jkp_paper);
        if(c == 3) iv_comp.setImageResource(R.drawable.jkp_scizor);

        if(j == c){
            tv_msg.setText("Nào houve vencedores...");
            tv_placar.setText(bundle.get("nome") +" "+ player_placar +" x "+ comp_placar +" Computador");
        }
        if((j == 1 && c == 3) || (j == 2 && c == 1) || (j == 3 && c == 2)){
            player_placar++;
            tv_msg.setText("Aeee! Você ganhou! :D");
            tv_placar.setText(bundle.get("nome") +" "+ player_placar +" x "+ comp_placar +" Computador");
        }
        if((j == 1 && c == 2) || (j == 2 && c == 3) || (j == 3 && c == 1)){
            comp_placar++;
            tv_msg.setText("Poxa, você perdeu :(");
            tv_placar.setText(bundle.get("nome") +" "+ player_placar +" x "+ comp_placar +" Computador");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(getBaseContext(),"Obrigado por jogar! :)",Toast.LENGTH_LONG).show();
    }

}
