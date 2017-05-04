package br.edu.ifsp.sbv.m2adm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new GameView(this);

        /*setContentView(gameView);*/

        setContentView(R.layout.activity_main);
        FrameLayout container = (FrameLayout)findViewById(R.id.container);

        container.addView(gameView);

        new Thread(gameView).start();
    }

    @Override
    protected void onResume() {
        super.onResume();

        gameView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        gameView.pause();
    }
}
