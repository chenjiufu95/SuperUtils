package pers.julio.notepad.SuperUtils;

import android.app.Activity;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;

/**
 * ClassName:  StatusBarUtils
 * Description: 指定 状态栏的样式
 * Author;  julio_chan  2020/5/7 10:32
 */
public class StatusBarUtils {
    public static void setLightStatusBar(@NonNull Activity activity, boolean lightStatusBar){
        final Window window = activity.getWindow();
        View decor = window.getDecorView();
        int ui = decor.getSystemUiVisibility();
        if (lightStatusBar) {
            ui |=View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        } else {
            ui &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        }
        decor.setSystemUiVisibility(ui);
    }
}
