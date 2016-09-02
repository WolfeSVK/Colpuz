package sk.wolfesvk.colpuz;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable {

    SurfaceHolder holder;
    Thread thread = null;
    boolean isRunning = true;
    float x,y;

    public GameView(Context context) {
        super(context);
        holder = getHolder();
    }

    public void pause() {
        isRunning = false;
        while (true) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
        thread = null;
    }

    public void getTouch(float xTouch, float yTouch){
        x = xTouch;
        y = yTouch;
    }


    public void resume() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while (isRunning) {
            if (!holder.getSurface().isValid())
                continue;

            Canvas canvas = holder.lockCanvas();
            canvas.drawRGB(02, 02, 150);
            if(x !=0 && y != 0){
                Bitmap test = BitmapFactory.decodeResource(getResources(),R.drawable.button);
                canvas.drawBitmap(test,x-test.getWidth()/2,y-test.getHeight()/2,null);

            }

            holder.unlockCanvasAndPost(canvas);

        }

    }


}
