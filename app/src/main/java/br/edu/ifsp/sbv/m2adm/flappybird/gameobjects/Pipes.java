package br.edu.ifsp.sbv.m2adm.flappybird.gameobjects;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.edu.ifsp.sbv.m2adm.flappybird.Screen;

public class Pipes {
    private List<Pipe> pipes;
    private int pipeSpacing = 250;
    private int pipeCount = 5;
    private Screen screen;
    private Score score;

    public Pipes(Screen screen, Score score) {

        this.screen = screen;
        this.score = score;
        this.pipes = new ArrayList();

        for (int i = 0; i < pipeCount; i++) {
            pipes.add(new Pipe(screen, 200 + i * pipeSpacing));
        }
    }

    public void draw(Canvas canvas) {

        for (Pipe pipe : pipes) {
            pipe.draw(canvas);
        }
    }

    public void move() {

        ListIterator<Pipe> iterator = pipes.listIterator();

        while (iterator.hasNext()) {
            Pipe pipe = (Pipe) iterator.next();

            pipe.move();

            if (pipe.isOffScreen()) {
                score.increase();
                iterator.remove();

                Pipe newPipe = new Pipe(screen, getLastPipeX() + pipeSpacing);

                iterator.add(newPipe);
            }
        }
    }

    public int getLastPipeX() {
        int lastPipeX = 0;

        for (Pipe pipe : pipes) {
            lastPipeX = Math.max(pipe.getX(), lastPipeX);
        }

        return lastPipeX;
    }

    public boolean colidesWith(Bird bird){
        for (Pipe pipe : pipes) {
           if(pipe.colidesWith(bird)){
               return true;
           }
        }

        return false;
    }
}
