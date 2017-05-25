package br.edu.ifsp.sbv.m2adm.flappybird;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import br.edu.ifsp.sbv.m2adm.R;

public class Audio {
    private SoundPool soundPool;

    public static int JUMP;
    public static int SCORE;
    public static int COLIDE;

    public Audio(Context context) {
        this.soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);

        JUMP = this.soundPool.load(context, R.raw.jump, 1);
        SCORE = this.soundPool.load(context, R.raw.score, 1);
        COLIDE = this.soundPool.load(context, R.raw.colide, 1);
    }

    public void play(int id) {
        this.soundPool.play(id, 1, 1, 1, 0, 1);
    }
}
