package sk.wolfesvk.colpuz;


import android.util.Log;

public final class Pool {
    
    public static final int FIELD_CELL_HEIGHT = 10;
    public static final int FIELD_CELL_WIDTH = 15;
    public static int[] field;

    private static Pool instance = null;


    private Pool() {

    }


    public static synchronized Pool getInstance() {
        if (instance == null) {
            instance = new Pool();
        }

        return instance;
    }



      void write(String text){
         Log.i("Pool", text);
     }



//
//    public  static  Pool {
//    }
//



}