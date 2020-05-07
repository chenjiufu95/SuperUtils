package pers.julio.notepad.SuperUtils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

/**
 * ClassName:  SpUtils
 * Description: 本地数据持久化 基类，可通过继承 根据具体业务逻辑扩展
 * Author;  julio_chan  2020/5/1 8:00
 */
public class SpUtils {
    public static final String FILE_DEFAULT = "Sp";
    public static final String KEY_TEMPLATE = "%1$s_Template_(%2$d)";

    ///////////////////////////////////// 条目操作(清空/移除) //////////////////////////////////////////////
    public static void ClearItems(Context context, String fileName) {
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        sp.edit().clear().commit();
    }
    public static void removeItem(Context context, String key) {
        removeItem(context, SpUtils.FILE_DEFAULT,key);
    }
    public static void removeItem(Context context, String fileName, String key) {
        if (context == null) return;
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }
    public static void removeItemsByKeyword(Context context, String fileName, String keyWord) {
        Map<String, ?> map = getMap(context, fileName);
        if (map == null) return;
        Set<String> keys = map.keySet();
        if (keys == null) return;
        for (String key : keys) {
            if (key.contains(keyWord))  removeItem(context,fileName,key);
        }
    }
    public static Map<String, ?> getMap(Context context, String fileName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getAll();
    }
    /////////////////////////////////////// 操作（基础数据类型） ////////////////////////////////////////////
    public static void putInt(Context context, String fileName, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(key, value);
        edit.commit();
    }
    public static int getInt(Context context, String fileName, String key, int defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defValue);
    }

    public static void putInt(Context context, String key, int value) {
        putInt(context, FILE_DEFAULT, key,value);
    }
    public static int getInt(Context context, String key, int defValue) {
        return getInt(context, FILE_DEFAULT,key,defValue);
    }
   //--------------------------------------------------------------------------------------------------
    public static void putString(Context context, String fileName, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(key, value);
        edit.commit();
    }
    public static String getString(Context context, String fileName, String key, String defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defValue);
    }

    public static void putString(Context context, String key, String value) {
        putString(context, FILE_DEFAULT,key,value);
    }
    public static String getString(Context context, String key, String defValue) {
        return getString(context, FILE_DEFAULT,key,defValue);
    }
    //--------------------------------------------------------------------------------------------------
    public static void putFloat(Context context,String fileName, String key, float value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putFloat(key, value);
        edit.commit();
    }
    public static float getFloat(Context context,String fileName, String key, float defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getFloat(key, defValue);
    }
    public static void putFloat(Context context, String key, float value) {
        putFloat(context, FILE_DEFAULT,key,value);
    }
    public static float getFloat(Context context, String key, float defValue) {
        return getFloat(context, FILE_DEFAULT,key,defValue);
    }
    //--------------------------------------------------------------------------------------------------
    public static void putBoolean(Context context,String fileName, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }
    public static boolean getBoolean(Context context,String fileName, String key, boolean defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defValue);
    }
    public static void putBoolean(Context context, String key, boolean value) {
        putBoolean(context, FILE_DEFAULT,key,value);
    }
    public static boolean getBoolean(Context context, String key, boolean defValue) {
        return getBoolean(context, FILE_DEFAULT,key,defValue);
    }
    //--------------------------------------------------------------------------------------------------

    /////////////////////////////////////// 操作（复杂数据类型） 示例 ////////////////////////////////////////////
}
