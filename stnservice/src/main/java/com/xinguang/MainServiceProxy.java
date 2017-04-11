package com.xinguang;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;

import com.tencent.mars.Mars;


/**
 * Created by fanzhengchen on 4/10/17.
 */

public class MainServiceProxy implements ServiceConnection {


    /**
     * MainServiceProxy 全局单例
     */
    private static volatile MainServiceProxy mInstance;


    /**
     * 用于发送接收数据的接口引用
     */
    private MarsService mMarsService;

    /**
     * 进程Context的引用，用于启动MarsServiceImpl这个service
     */
    private Context mContext;


    private MainServiceProxy() {
        Mars.loadDefaultMarsLibrary();
    }

    public static MainServiceProxy getInstance() {
        MainServiceProxy proxy = mInstance;

        if (proxy == null) {
            synchronized (MainServiceProxy.class) {
                if (proxy == null) {
                    proxy = new MainServiceProxy();
                    mInstance = proxy;
                }
            }
        }
        return proxy;
    }

    public void init(Context context, Looper looper) {
        mContext = context;
        /**
         * 启动marsService
         */
        startMarsService();
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        mMarsService = MarsService.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        mMarsService = null;
    }

    /**
     * 启动MarsService
     */
    private void startMarsService() {
        Intent intent = new Intent(mContext, MainServiceNative.class);
        mContext.startService(intent);

        if (!mContext.bindService(intent, mInstance, Service.BIND_AUTO_CREATE)) {
            Throwable throwable = new Throwable("bind service failed");
            throw new RuntimeException(throwable);
        }
    }

    public void send(TaskWrapper wrapper) {


        if (mMarsService == null) {
            return;
        }
        try {
            mMarsService.send(wrapper);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
