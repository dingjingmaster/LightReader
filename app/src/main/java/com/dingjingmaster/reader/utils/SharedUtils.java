package com.dingjingmaster.reader.utils;

import android.content.Context;
import android.content.SharedPreferences.Editor;

/**
 * Created by DingJing on 2017/11/22.
 */

// 实现标记的写入和读取
public class SharedUtils {

    private static final String FILE_NAME = "lightreader";
    private static final String MODE_NAME = "welcome";

    // 获取值
    public static boolean getWelcomeBoolean(Context context) {

        return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getBoolean(MODE_NAME, false);
    }

    // 写入
    public static void putWelcomeBoolean(Context context, boolean isFirst) {

        Editor editor = context.getSharedPreferences(FILE_NAME, Context.MODE_APPEND).edit();
        editor.putBoolean(MODE_NAME, isFirst);
        editor.commit();
    }
}
