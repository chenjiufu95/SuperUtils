package pers.julio.notepad.SuperUtils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * ClassName:  DisplayUtils
 * Description: < 显示工具类 >
 * Author: julio_chan  2020/5/7 11:18
 */
public class DisplayUtils {
    public static int getScreenWidth(Context ctx){
        WindowManager wm = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        if(wm!=null){
            wm.getDefaultDisplay().getMetrics(dm);
        }
        return dm.widthPixels;
    }
    public static int getScreenHeight(Context ctx){
        WindowManager wm = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }
    public static float getScreenDensity(Context ctx){
        WindowManager wm = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.density;
    }
}
