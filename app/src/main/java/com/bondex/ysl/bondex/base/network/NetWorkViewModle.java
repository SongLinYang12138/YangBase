package com.bondex.ysl.bondex.base.network;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bondex.ysl.bondex.base.utils.NoDoubleClickListener;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.http.NetworkUtil;

/**
 * date: 2018/12/24
 * Author: ysl
 * description:
 */
public class NetWorkViewModle extends BaseViewModel {

    private Context context;

    public NoDoubleClickListener listener = new NoDoubleClickListener() {
        @Override
        public void noDouble(View v) {

            boolean isConnected = NetworkUtil.isNetworkAvailable(context);

            Log.i("aaa", " isConnected  " + isConnected);
            if (!isConnected) {

                MaterialDialog.Builder dialog = new MaterialDialog.Builder(context);

                dialog.title("是否跳转到设置界面，打开wifi?");
                dialog.onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        settingNetwork();
                    }
                });
                dialog.positiveText("确定");
                dialog.negativeText("取消");
                dialog.onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        dialog.dismiss();
                    }
                });
                dialog.build().show();
            } else {

                try {

                    String msg = NetworkUtil.isWifi(context) ? "当前网络是wifi" : "当前网络是移动流量";

                    Toast.makeText(context, "网络连接正常 "+msg, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    };

    public void setContext(Context context) {
        this.context = context;
    }

    public NetWorkViewModle(@NonNull Application application) {
        super(application);

//        receiver.setResult(this);

    }

    @Override
    public void onCreate() {
        super.onCreate();

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
//        context.registerReceiver(receiver, filter);
    }


    /**
     * 判断手机系统的版本！如果API大于10 就是3.0+
     * 因为3.0以上的版本的设置和3.0以下的设置不一样，调用的方法不同
     */
    private void settingNetwork() {

        Intent intent = null;
        if (Build.VERSION.SDK_INT > 10) {
            intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
        } else {
            intent = new Intent();
            ComponentName component = new ComponentName("com.android.settings", "com.android.settings.WirelessSettings");
            intent.setComponent(component);
            intent.setAction("android.intent.action.VIEW");
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


//    @Override
//    public void result(NetworkInfo network) {
//
//        boolean isConnected = network.isConnected();
//
//        Log.i("aaa", "isConnected " + isConnected);
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();

//        context.unregisterReceiver(receiver);
    }
}
