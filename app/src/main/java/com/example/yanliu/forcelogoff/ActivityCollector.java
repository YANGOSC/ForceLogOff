package com.example.yanliu.forcelogoff;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanliu on 2016/1/25.
 */
public class ActivityCollector {
    //集合里面的对象是Activity，所以用来管理Activity
    public static List<Activity> activities = new ArrayList<Activity>();
    //向集合里添加Activity对象
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    //从集合里取出对象
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    //一次性销毁所有Activity
    public static void finishAll(){
        //Java的foreach方法
     for (Activity activity:activities){
         //判断activity是否finish
         if (!activity.isFinishing()){
             activity.finish();
         }
     }
    }
}
