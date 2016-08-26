package mx.com.richmond.catalog;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import java.security.Principal;

public class MainActivity extends AppCompatActivity {
    public static final int segundos = 6;
    public static int milisegundos = segundos * 500;
    public static final int delay=2;
    private ProgressBar pbprogreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        pbprogreso = (ProgressBar) findViewById(R.id.pbprogreso);
        pbprogreso.setMax(maximoProgreso());
        empezarAnimacion();
    }

    public void empezarAnimacion(){
        new CountDownTimer(milisegundos,500){
            @Override
            public void onTick(long millisUnitFinished){
                pbprogreso.setProgress(establecerProgreso(millisUnitFinished));
            }
            @Override
            public void onFinish(){
                Intent nuevoFrom = new Intent(MainActivity.this, First.class);
                startActivity(nuevoFrom);
                finish();
            }
        }.start();
    }

    public int establecerProgreso(long miliseconds){
        return (int)((milisegundos-miliseconds)/500);
    }
    public int maximoProgreso(){
        return segundos-delay;
    }
}
