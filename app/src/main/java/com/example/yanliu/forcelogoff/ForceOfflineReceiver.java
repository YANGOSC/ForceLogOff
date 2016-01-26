package com.example.yanliu.forcelogoff;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

public class ForceOfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");

        //AlertDialog.Builder来构建一个对话框，一定调用setCancelable()将对话框设为不可取消
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("Warning");
        dialogBuilder.setMessage("You are forced to be offline!");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //销毁所有活动并且重新启动LoginActivity这个活动
                ActivityCollector.finishAll();
                Intent intent = new Intent(context, LoginActivity.class);
                //由于我们是在广播接收器里面启动活动的，因此一定要给Intent加入FLAG_ACTIVITY_NEW_TASK这个标志。
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        AlertDialog alertDialog = dialogBuilder.create();
        //需要设置AlertDialog的类型，保证在广播接收器中可以正常弹出
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }
}
