package br.edu.ifsp.sbv.m2adm.flappybird.gameobjects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import br.edu.ifsp.sbv.m2adm.R;
import br.edu.ifsp.sbv.m2adm.flappybird.Audio;
import br.edu.ifsp.sbv.m2adm.flappybird.Screen;

public class Bird {

    private int x = 100;
    private int y = 400;
    private int r = 50;
    private Screen screen;
    private float speed = 2;
    private float gravity = 1;
    private Bitmap sprite;

    private Audio audio;

    public Bird(Context context, Screen screen, Audio audio) {
        this.screen = screen;

        Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.bird);
        this.sprite = Bitmap.createScaledBitmap(bmp, r * 2, r * 2, false);

        this.audio = audio;
    }

    public void draw(Canvas canvas) {

        canvas.drawBitmap(this.sprite, x - r, y - r, null);
    }

    public void jump() {
        speed = -15;
        if (y + speed > r) {
            y += speed;
            this.audio.play(Audio.JUMP);
        } else {
            y = r;
        }
    }

    public void plane() {

        float limit = y + speed + r;

        if (limit < screen.getHeight()) {
            speed += gravity;
            y += speed;
        } else {
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
