package sk.wolfesvk.colpuz;


import android.util.Log;

public final class DataPool {
    
    public static final int FIELD_CELL_WIDTH = 10;
    public static final int FIELD_CELL_HEIGHT = 15;

    public static int fieldPxWidth;
    public static int fieldPxHeight;

    public static int shiftDown;
    public static int shiftRight;

    public static int[] field;

    private static DataPool instance = null;


    private DataPool() {

    }


    public static synchronized DataPool getInstance() {
        if (instance == null) {
            instance = new DataPool();
        }

        return instance;
    }



      void write(String text){
         Log.i("DataPool", text);
     }



//
//    public  static  DataPool {
//    }
//



}