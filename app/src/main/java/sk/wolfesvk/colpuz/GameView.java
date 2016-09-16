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
    float touchX, touchY;

    Variables variables;


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

    public void getTouch(float xTouch, float yTouch) {
        touchX = xTouch;
        touchY = yTouch;
    }


    public void resume() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {

        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 30;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        int fps = TARGET_FPS;
        long lastFpsTime = 0;

        variables =  Variables.getInstance();
        variables.write("testicek");


        while (isRunning) {

            //          startTime = System.nanoTime();


            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double) OPTIMAL_TIME);

            lastFpsTime += updateLength;
            fps++;

            if (lastFpsTime >= 1000000000) {
                lastFpsTime = 0;
                fps = 0;
            }


            update(delta);
            render();


            try {
                if ((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000 > 0)
                    thread.sleep((lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


    void update(double delta) {

    }


    void render() {

        if (holder.getSurface().isValid()) {


            Canvas canvas = holder.lockCanvas();
            canvas.drawRGB(02, 02, 150);
            if (touchX != 0 && touchY != 0) {
                Bitmap test = BitmapFactory.decodeResource(getResources(), R.drawable.button);
                canvas.drawBitmap(test, touchX - test.getWidth() / 2, touchY - test.getHeight() / 2, null);
            }

            holder.unlockCanvasAndPost(canvas);
        }
    }


}



