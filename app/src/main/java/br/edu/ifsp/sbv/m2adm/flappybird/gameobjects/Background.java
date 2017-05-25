package br.edu.ifsp.sbv.m2adm.flappybird.gameobjects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import br.edu.ifsp.sbv.m2adm.R;
import br.edu.ifsp.sbv.m2adm.flappybird.Screen;

public class Background {

    Bitmap background;
    int backgroundPosition;

    public Background(Context context, Screen screen) {
        Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.background);

        this.background = Bitmap.createScaledBitmap(bmp, bmp.getWidth(), screen.getHeight() ,false);

        backgroundPosition = 0;
    }

    public void update() {

        backgroundPosition -= 1;
        if (backgroundPosition < (-background.getWidth() / 2))
            backgroundPosition = backgroundPosition - (-background.getWidth() / 2);
    }

    public void draw(Canvas canvas) {


        canvas.drawBitmap(background, backgroundPosition, 0, null);
    }
}

