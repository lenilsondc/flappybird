package br.edu.ifsp.sbv.m2adm.flappybird.gameobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import br.edu.ifsp.sbv.m2adm.flappybird.Screen;

public class GameOver {

    private Screen screen;

    public GameOver(Screen screen) {
        this.screen = screen;
    }

    public void draw(Canvas canvas) {

        String message = "GAME OVER";

        Paint paint = new Paint();
        paint.setTextSize(50);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setColor(Color.RED);
        paint.setShadowLayer(2, 3, 3, Color.BLACK);

        canvas.drawText(String.format(message), screen.getWidth() / 2 - paint.measureText(message) / 2, screen.getHeight() / 2, paint);
    }
}
