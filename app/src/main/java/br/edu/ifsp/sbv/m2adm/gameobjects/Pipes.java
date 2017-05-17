package br.edu.ifsp.sbv.m2adm.gameobjects;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.edu.ifsp.sbv.m2adm.Screen;

public class Pipes {
    private List<Pipe> pipes;
    private int pipeSpacing = 250;
    private int pipeCount = 5;
    private Screen screen;

    public Pipes(Screen screen) {

        this.screen = screen;
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

        while(iterator.hasNext()){
            Pipe pipe = (Pipe) iterator.next();

            pipe.move();

            if(pipe.isOffScreen()){
                iterator.remove();

                Pipe newPipe = new Pipe(screen, getLastPipeX() + pipeSpacing);

                iterator.add(newPipe);
            }
        }
    }

    public int getLastPipeX(){
        int lastPipeX = 0;

        for(Pipe pipe : pipes){
            lastPipeX = Math.max(pipe.getX(), lastPipeX);
        }

        return lastPipeX;
    }
}
