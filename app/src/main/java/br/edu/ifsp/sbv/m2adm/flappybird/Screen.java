package br.edu.ifsp.sbv.m2adm.flappybird;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class Screen {
    private DisplayMetrics metrics;
    private Context context;

    public Screen(Context context){

        this.context = context;

        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        metrics = new DisplayMetrics();

        display.getMetrics(metrics);
    }

    public int getWidth(){
        return metrics.widthPixels;
    }

    public int getHeight(){
        return metrics.heightPixels;
    }
}
