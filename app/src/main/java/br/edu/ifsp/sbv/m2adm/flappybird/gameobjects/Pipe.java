package br.edu.ifsp.sbv.m2adm.flappybird.gameobjects;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import br.edu.ifsp.sbv.m2adm.R;
import br.edu.ifsp.sbv.m2adm.flappybird.Screen;

public class Pipe {

    private int x;
    private int bottomHeight;
    private int topHeight;
    private int width = 100;
    private Screen screen;
    private int color;
    private Bitmap spriteBottom;
    private Bitmap spriteTop;

    public Pipe(Context context, Screen screen, int x) {
        this.screen = screen;
        this.x = x;
        this.bottomHeight = screen.getHeight() - width - randonHeight();
        this.topHeight = 0 + width + randonHeight();

        color = Color.GREEN;

        Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.pipe);

        this.spriteBottom = Bitmap.createScaledBitmap(bmp, width, bottomHeight, false);
        this.spriteTop = Bitmap.createScaledBitmap(bmp, width, topHeight, false);
    }

    public void draw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(color);

        canvas.drawBitmap(spriteBottom, x, bottomHeight, paint);
        canvas.drawBitmap(spriteBottom, x, 0, paint);
        //canvas.drawRect(x, 0, x + width, topHeight, paint);
    }

    public void move() {
        this.x -= 5;
    }

    public boolean isOffScreen() {
        return x + width <= 0;
    }

    public int randonHeight() {
        return (int) (Math.random() * 150);
    }

    public int getX() {
        return x;
    }

    public boolean colidesWith(Bird bird) {

        if (bird.getY() - bird.getR() < topHeight || bird.getY() + bird.getR() > bottomHeight) {
            return x - bird.getX() < bird.getR();
        }

        return false;
    }
}

