package sk.wolfesvk.colpuz;


import android.util.Log;

public final class Variables {
    static int xyxy = 0;
    int[] field;

    private static Variables instance = null;


    private Variables() {
        Log.i("variables1", String.valueOf(System.currentTimeMillis()));
        Log.i("variables1", String.valueOf(xyxy));
        xyxy++;

    }


    public static synchronized Variables getInstance() {
        if (instance == null) {
            instance = new Variables();
        }

        return instance;
    }



      void write(String text){
         Log.i("variables", text);
     }



//
//    public  static  Variables {
//    }
//



}