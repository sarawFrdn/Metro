package com.androidlearn.newmetrow.config;

import android.content.Context;
import android.content.SharedPreferences;

public class AppConfig {

    SharedPreferences sh ;
    SharedPreferences.Editor editor;

    public AppConfig(Context context){

        sh = context.getSharedPreferences("setting",Context.MODE_PRIVATE);
        editor = sh.edit();

    }

    public void saveStation(String name , String english){
        editor.putString("title",name);
        editor.putString("englishTitle",english);
        editor.commit();
    }
    public String getTitle(){

        return sh.getString("title","");
    }

    public String getEnglishTitle(){
        return sh.getString("englishTitle","");
    }

    public void setFont(int size){
        editor.putInt("Fontsize",size);
    }

    public int getFont(){
        return sh.getInt("Fontsize",12);
    }



}
