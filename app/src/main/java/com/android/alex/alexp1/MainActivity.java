package com.android.alex.alexp1;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static final String NOME = "nome";
    public static final int NOTIFICATION_ID = 5453;
    Button btn_jkp, btn_jdv, btn_imc, btn_st;
    EditText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagina_inicial);
        btn_jkp = (Button) findViewById(R.id.btnjkp);
        btn_jdv = (Button) findViewById(R.id.btnjdv);
        btn_imc = (Button) findViewById(R.id.btnimc);
        btn_st = (Button) findViewById(R.id.btnst);

        btn_jkp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificaNome()){
                    Intent intent = new Intent(MainActivity.this, JoKenPoActivity.class);
                    intent.putExtra("nome", getNome());
                    startActivity(intent);
                }
            }
        });

        btn_jdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificaNome()){
                    Intent intent = new Intent(MainActivity.this, JogoVelhaActivity.class);
                    intent.putExtra("nome", getNome());
                    startActivity(intent);
                }
            }
        });

        btn_imc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificaNome()){
                    Intent intent = new Intent(MainActivity.this, IMCActivity.class);
                    intent.putExtra("nome", getNome());
                    startActivity(intent);
                }
            }
        });

        btn_st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificaNome()){
                    Intent intent = new Intent(MainActivity.this, SuperTretas.class);
                    intent.putExtra("nome", getNome());
                    startActivity(intent);
                }
            }
        });
    }



    private boolean verificaNome(){
        if(getNome().trim().equals("")){
            Toast.makeText(getBaseContext(),"Por favor, digite seu nome para poder continuar.",Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }
    private String getNome(){
        nome = (EditText) findViewById(R.id.et_nome);
        return String.valueOf(nome.getText());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Aviso")
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentIntent(pendingIntent)
                .setContentText("Obrigado por utilizar meu aplicativo! ass: Alex :D")
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification);
    }


}
