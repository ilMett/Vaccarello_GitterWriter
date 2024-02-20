package com.example.vaccarello_mattia_gitter_writer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Text_activity extends AppCompatActivity {
    private ArrayList<String> aryParoleInserite = new ArrayList<>();
    private ArrayList<String> paroleInizializzate = new ArrayList<>();
    public int indiceParole = 0;
    private int indice = 0;
    TextView txtTimer, txtParole, txtUser;
    Button startButton, goBack;
    CountDownTimer countDownTimer;
    EditText paroleInserite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_activity);

        paroleInserite = findViewById(R.id.PlainText);
        txtUser = findViewById(R.id.txtUser);
        txtParole = findViewById(R.id.txtTesto);
        txtTimer = findViewById(R.id.txtTimer);
        startButton = findViewById(R.id.btnStart);
        goBack = findViewById(R.id.goBack);


        //switching to second activity
        String linguaScelta = getIntent().getStringExtra("lingua_scelta");
        Intent indice = getIntent();
        this.indice = indice.getIntExtra("IndiceListView", 1);

        // starting timer
        startTimer();

        // editText first not visible unless start button is pressed
        paroleInserite.setVisibility(View.GONE);
        paroleInserite.setEnabled(false);

        //choosing language
        switch (this.indice) {
            case 0:
                ITA();
                break;
            case 1:
                ENG();
                break;
            case 2:
                ESP();
                break;
        }

        // go back to MainActvity
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });
    }

    //countdown timer
    void setCountDownTimer() {
        countDownTimer = new CountDownTimer(40000, 1) {
            public void onTick(long millisUntilFinished) {
                // printing the format in SECONDS:MILLISECONDS
                NumberFormat f = new DecimalFormat("000");
                long sec = (millisUntilFinished / 1000) % 60;
                long milliseconds = millisUntilFinished % 1000;
                txtTimer.setText(f.format(sec) + ":" + f.format(milliseconds));
            }
            public void onFinish() {
                // disable EditText after timer has elapsed
                paroleInserite.setVisibility(View.GONE);
                paroleInserite.setEnabled(false);
                txtTimer.setText("000:000");
            }
        };
        countDownTimer.start();

    }

    public void startTimer(){
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCountDownTimer();
                // startButton disappears
                startButton.setVisibility(View.INVISIBLE);

                // editText appears
                paroleInserite.setVisibility(View.VISIBLE);
                paroleInserite.setEnabled(true);
            }
        });
    }

    //keyboard key events for printing the txt written every time the user click space
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent keyEvent) {
        switch(keyCode){
            case KeyEvent.KEYCODE_SPACE:
                aryParoleInserite.add(paroleInserite.getText().toString());
                txtUser.setText(aryParoleInserite.get(indiceParole));
                indiceParole++;
                return true;
        }
        return super.onKeyDown(keyCode, keyEvent);
    }

    //showIta
    public void ITA(){
        Parola Italiano = new Parola();
        Italiano.inizializzazione();
        for (int i = 0; i<= Italiano.getParolePredisposte().size(); i++){
            paroleInizializzate.add(Italiano.setTradITA(Italiano.getParolePredisposte().get(Italiano.genetazioneNumeri()).getTradITA()));
        }

        // replacing wrong characters
        String temp = paroleInizializzate.toString();
        temp = temp.replace("[", "").replace("]", "").replace(", ", "   ");
        txtParole.setText(temp);
    }
    //showEng
    public void ENG(){
        Parola Inglese = new Parola();
        Inglese.inizializzazione();
        for (int i = 0; i<= Inglese.getParolePredisposte().size(); i++){
            paroleInizializzate.add(Inglese.setTradENG(Inglese.getParolePredisposte().get(Inglese.genetazioneNumeri()).getTradENG()));
        }
        // replacing wrong characters
        String temp = paroleInizializzate.toString();
        temp = temp.replace("[", "").replace("]", "").replace(", ", " ");
        txtParole.setText(temp);
    }
    //showEsp
    public void ESP(){
        Parola Spagnolo = new Parola();
        Spagnolo.inizializzazione();
        for (int j = 0; j<= Spagnolo.getParolePredisposte().size(); j++){
            paroleInizializzate.add(Spagnolo.setTradSPA(Spagnolo.getParolePredisposte().get(Spagnolo.genetazioneNumeri()).getTradSPA()));
        }
        // replacing wrong characters
        String temp = paroleInizializzate.toString();
        temp = temp.replace("[", "").replace("]", "").replace(", ", " ");
        txtParole.setText(temp);
    }

    public void openActivity1(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}