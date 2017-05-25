package br.edu.ifsp.sbv.m2adm.flappybird.gameobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;


import br.edu.ifsp.sbv.m2adm.flappybird.Audio;

public class Score {
    private int score;

    Audio audio;

    public Score(Audio audio) {
        this.audio = audio;
    }

    public void draw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(80);
        paint.setTypeface(Typeface.DEFAULT_BOLD);

        canvas.drawText(String.format("%d", this.score), 100, 100, paint);
    }

    public void increase() {

        this.audio.play(Audio.SCORE);
        this.score++;
    }

    public int getScore() {
        return score;
    }
}
