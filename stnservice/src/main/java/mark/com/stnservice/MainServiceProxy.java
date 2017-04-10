package mark.com.stnservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;

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

    }

    /**
     * 启动MarsService
     */
    private void startMarsService() {
        Intent intent = new Intent(mContext, MainServiceImpl.class);
        mContext.startService(intent);
    }
}
