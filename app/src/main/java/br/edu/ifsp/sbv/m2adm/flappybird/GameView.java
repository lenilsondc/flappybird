package br.edu.ifsp.sbv.m2adm.flappybird;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import br.edu.ifsp.sbv.m2adm.R;
import br.edu.ifsp.sbv.m2adm.flappybird.gameobjects.Background;
import br.edu.ifsp.sbv.m2adm.flappybird.gameobjects.Bird;
import br.edu.ifsp.sbv.m2adm.flappybird.gameobjects.GameOver;
import br.edu.ifsp.sbv.m2adm.flappybird.gameobjects.Pipes;
import br.edu.ifsp.sbv.m2adm.flappybird.gameobjects.Score;

public class GameView extends SurfaceView implements Runnable, View.OnTouchListener {

    boolean isRunning;
    SurfaceHolder holder = getHolder();

    public GameView(Context context) {
        super(context);

        setOnTouchListener(this);
        init();
    }

    public void resume() {
        isRunning = true;
    }

    public void pause() {
        isRunning = false;
    }

    @Override
    public void run() {

        Canvas canvas;

        while (isRunning) {

            if (!holder.getSurface().isValid()) continue;

            canvas = holder.lockCanvas();

            if(colisor.colides()){
                audio.play(Audio.COLIDE);
                new GameOver(screen).draw(canvas);
                pause();
            }else {

                update();
                render(canvas);
            }

            holder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        bird.jump();
        return false;
    }


    Screen screen;

    Bird bird;
    Background background;
    Pipes pipes;
    Score score;
    Colisor colisor;
    Audio audio;

    public void init() {

        screen = new Screen(getContext());
        audio = new Audio(getContext());

        bird = new Bird(getContext(), screen, audio);

        background = new Background(getContext(), screen);

        score = new Score(audio);
        pipes = new Pipes(getContext(), screen, score);

        colisor = new Colisor(bird, pipes);
    }

    public void update() {


        background.update();

        bird.plane();
        pipes.move();

    }

    public void render(Canvas canvas) {
        background.draw(canvas);
        bird.draw(canvas);
        pipes.draw(canvas);
        score.draw(canvas);
    }

    // better fps controll method
    // desired fps
    private final static int MAX_FPS = 50;

    // maximum number of frames to be skipped
    private final static int MAX_FRAME_SKIPS = 5;

    // the frame period
    private final static int FRAME_PERIOD = 1000 / MAX_FPS;

    //@Override
    public void run2() {

        Canvas canvas;

        long beginTime;        // the time when the cycle begun
        long timeDiff;        // the time it took for the cycle to execute
        int sleepTime;        // ms to sleep (<0 if we're behind)
        int framesSkipped;    // number of frames being skipped

        sleepTime = 0;

        while (isRunning) {
            canvas = null;
            // try locking the canvas for exclusive pixel editing
            // in the surface
            try {
                canvas = this.holder.lockCanvas();
                synchronized (holder) {
                    beginTime = System.currentTimeMillis();
                    framesSkipped = 0;    // resetting the frames skipped
                    // update game state
                    update();
                    // render state to the screen
                    // draws the canvas on the panel
                    render(canvas);
                    // calculate how long did the cycle take
                    timeDiff = System.currentTimeMillis() - beginTime;
                    // calculate sleep time
                    sleepTime = (int) (FRAME_PERIOD - timeDiff);

                    if (sleepTime > 0) {
                        // if sleepTime > 0 we're OK
                        try {
                            // send the thread to sleep for a short period
                            // very useful for battery saving
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException e) {
                        }
                    }

                    while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS) {
                        // we need to catch up
                        // update without rendering
                        this.update();
                        // add frame period to check if in next frame
                        sleepTime += FRAME_PERIOD;
                        framesSkipped++;
                    }
                }
            } finally {
                // in case of an exception the surface is not left in
                // an inconsistent state
                if (canvas != null) {
                    holder.unlockCanvasAndPost(canvas);
                }
            }    // end finally
        }
    }
}
