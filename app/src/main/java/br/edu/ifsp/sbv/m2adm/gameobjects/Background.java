package br.edu.ifsp.sbv.m2adm.gameobjects;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Background {

    Bitmap background;
    int backgroundPosition;

    public Background(Bitmap bmp) {
        this.background = bmp;

        backgroundPosition = 0;
    }

    public void update() {

        backgroundPosition -= 5;
        if (backgroundPosition < (-background.getWidth() / 2))
            backgroundPosition = backgroundPosition - (-background.getWidth() / 2);
    }

    public void draw(Canvas canvas) {


        canvas.drawBitmap(background, backgroundPosition, 0, null);
    }
}

