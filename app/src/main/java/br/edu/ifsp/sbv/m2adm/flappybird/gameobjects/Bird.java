package br.edu.ifsp.sbv.m2adm.flappybird.gameobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import br.edu.ifsp.sbv.m2adm.flappybird.Screen;

public class Bird {

    private int x = 100;
    private int y = 400;
    private int r = 50;
    private Screen screen;
    private float speed = 10;
    private float gravity = 1;

    public Bird(Screen screen) {
        this.screen = screen;
    }

    public void draw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(Color.RED);

        canvas.drawCircle(x, y, r, paint);
    }

    public void jump() {
        speed = -15;
        if (y + speed > r) {
            y += speed;
        }else {
            y = r;
        }
    }

    public void plane() {

        float limit = y + speed + r;

        if (limit < screen.getHeight()) {
            speed += gravity;
            y += speed;
        }else {
            y = screen.getHeight() - r;
        }

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

    public void setR(int r) {
        this.r = r;
    }
}
