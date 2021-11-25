package com.example.mehraj;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.ContactsContract;

public class SharedPrefrences {


    public  static  final String PREFS_NAME="my_pref";
    public static void storePlayerName(Context context,String name)
    {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("playername", name);
        editor.commit();
    }


    public static String getPlayerName(Context context)
    {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return settings.getString("playername", "defaultValue");
    }


}
