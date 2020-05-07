package pers.julio.notepad.SuperUtils;

import android.content.Context;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/** 日志打印 基类：为便于日志筛选分析，只支持 e/d 级别 日志打印，可通过继承 根据具体业务逻辑扩展
 * ClassName:  LogUtils
 * Author;  julio_chan  2020/5/1 8:00
 */
public class LogUtils {
    public static String KEY_DEBUG = "【D";  // 默认Key 便于筛选日子


    ////////////////////////////////// 基础日志打印(常用的) /////////////////////////////////////
    public static boolean E = true;  // 是否开启 Error日志打印功能
    public static boolean D = true;  // 是否开启 Debug日志打印功能
    public static void d(String tag, String message) {
        if (D) Log.d(tag, message);
    }
    public static void e(String tag, String message) {
        if (E) { Log.e(tag, message); }
    }
    public static void e(String tag, String message, Throwable tr) { if (E) { Log.e(tag, message, tr); } }

    ////////////////////////////////// 打印日志持续时间 /////////////////////////////////////
    public static long startLogTimeInMillis = 0;
    public static void prepareLog(String tag) {
        startLogTimeInMillis =  Calendar.getInstance().getTimeInMillis();
        d(tag, "日志计时开始：" + startLogTimeInMillis);
    }
    /** 描述：打印这次的执行时间毫秒，需要首先调用prepareLog().*/
    public static void d(String tag, String message, boolean printTime) {
        long endLogTimeInMillis = Calendar.getInstance().getTimeInMillis();
        d(tag, message + ":" + (endLogTimeInMillis - startLogTimeInMillis) + "ms");
        startLogTimeInMillis = 0;
    }

    ////////////////////////////////// 自定义(可变参数)文件打印 /////////////////////////////////////
    public static void e(Context context, String format, Object... args) {
        String text = buildMessage(format, args);
        e(context, text);
    }
    public static void d(Context context, String format, Object... args) {
        String text = buildMessage(format, args);
        d(context,text);
    }
    private static String buildMessage(String format, Object... args) {
        String msg = (args == null) ? format : String.format(Locale.US, format, args);
        StackTraceElement[] trace = new Throwable().fillInStackTrace().getStackTrace();
        String caller = "<unknown>";
        for (int i = 2; i < trace.length; i++) {
            Class<?> clazz = trace[i].getClass();
            if (!clazz.equals(LogUtils.class)) {
                String callingClass = trace[i].getClassName();
                callingClass = callingClass.substring(callingClass.lastIndexOf('.') + 1);
                callingClass = callingClass.substring(callingClass.lastIndexOf('$') + 1);
                caller = callingClass + "." + trace[i].getMethodName();
                break;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Thread.currentThread().getId(), caller, msg);
    }

    ////////////////////////////////// 自定义日志(可打印到文件) /////////////////////////////////////
    //public static final String FILE_DEBUG =  "/data/data/am.doit.dohome/debug.txt";
    public static void eLog2File(String filePath,String tag, String message) {
        e(tag ,message);
        toFile(filePath,tag, message);
    }
    public static void dLog2File(String filePath,String tag, String message) {
        d(tag ,message);
        toFile(filePath,tag, message);
    }
    private  static void toFile(final String filePath, String tag, String content) {
        if (content == null) return;
        if (!createOrExistsFile(filePath)) return;
        String time = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
        final String dateLogContent = time + " " + tag + " " + content + '\r'+ '\n';
        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedWriter bw = null;
                try {
                    bw = new BufferedWriter(new FileWriter(filePath, true));
                    bw.write(dateLogContent);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        bw.close();
                    } catch (IOException e) { e.printStackTrace(); }
                }
            }
        }).start();
    }
    public static boolean createOrExistsFile(final String filePath) {
        return createOrExistsFile(getFileByPath(filePath));
    }
    public static boolean createOrExistsFile(final File file) {
        if (file == null) return false;
        // 如果存在，是文件则返回true，是目录则返回false
        if (file.exists()) return file.isFile();
        if (!createOrExistsDir(file.getParentFile())) return false;
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static File getFileByPath(final String filePath) {
        return "".equals(filePath) ? null : new File(filePath);
    }
    public static boolean createOrExistsDir(final File file) {
        return file != null && (file.exists() ? file.isDirectory() : file.mkdirs());
    }
}
