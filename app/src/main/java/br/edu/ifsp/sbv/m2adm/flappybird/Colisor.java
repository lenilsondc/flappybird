package br.edu.ifsp.sbv.m2adm.flappybird;


import br.edu.ifsp.sbv.m2adm.flappybird.gameobjects.Bird;
import br.edu.ifsp.sbv.m2adm.flappybird.gameobjects.Pipes;

public class Colisor {
    private Bird bird;
    private Pipes pipes;

    public Colisor(Bird bird, Pipes pipes) {
        this.bird = bird;
        this.pipes = pipes;
    }

    public boolean colides(){

        return pipes.colidesWith(bird);
    }
}
