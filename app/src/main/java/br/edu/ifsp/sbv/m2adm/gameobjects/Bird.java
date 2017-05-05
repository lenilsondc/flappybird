package br.edu.ifsp.sbv.m2adm.gameobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Bird {

    private int x = 100;
    private int y = 400;
    private float r = 50;

    public void draw(Canvas canvas){

        Paint paint = new Paint();
        paint.setColor(Color.RED);

        canvas.drawCircle(x, y, r, paint);
    }

    public void jump(){
        this.y -= 150;
    }

    public void plane(){
        y += 10;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }
}
