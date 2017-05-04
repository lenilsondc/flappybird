package br.edu.ifsp.sbv.m2adm.gameobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Bird {

    private int x = 100;
    private int y = 100;
    private float r = 100;

    public void draw(Canvas canvas){

        Paint paint = new Paint();
        paint.setColor(Color.RED);

        canvas.drawCircle(x, y, r, paint);
    }
}
