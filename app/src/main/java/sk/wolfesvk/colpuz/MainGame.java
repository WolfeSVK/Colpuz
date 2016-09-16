package sk.wolfesvk.colpuz;


import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainGame extends Activity implements View.OnTouchListener{
    GameView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        gv = new GameView(this);
        gv.setOnTouchListener(this);

        setContentView(gv);
    }

    @Override
    protected void onPause(){
        super.onPause();
        gv.pause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        gv.resume();
    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        gv.getTouch(event.getX(),event.getY());
        return false;
    }
}

