package mark.com.stnservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.tencent.mars.BaseEvent;
import com.tencent.mars.Mars;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.mars.stn.StnLogic;

/**
 * Created by fanzhengchen on 4/10/17.
 */

public class MainServiceImpl extends Service implements MarsService {


    /**
     * MarsService桩 消息发送接收的真正执行者
     */
    MarsServiceStub stub;

    /**
     * Mars初始化所用版本号，IP地址以及端口
     */
    private static final Profile mProfile = new DebugProfile();

    @Override
    public void onCreate() {
        super.onCreate();
        stub = new MarsServiceStub(this);

        /**
         * mars基础组件初始化
         */
        StnLogic.setCallBack(stub);
        SdtLogic.setCallBack(stub);
        AppLogic.setCallBack(stub);

        /**
         *
         * Initialize the Mars PlatformComm
         */
        Mars.init(this, new Handler(Looper.getMainLooper()));

        StnLogic.setLonglinkSvrAddr(mProfile.getHost(),
                mProfile.getLongLinkPorts());

        StnLogic.setClientVersion(mProfile.getProduceId());

        Mars.onCreate(true);
        BaseEvent.onForeground(true);
        StnLogic.makesureLongLinkConnected();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("on start command " + (new MyThrowable().printCodeLine()));
        int result = super.onStartCommand(intent, flags, startId);

//        send(new TextTaskWrapper("wwwwwwwwwwwwwwwwwww"));
        try {
            send(new TextTaskWrapper("wwwwwwwwwwwwwwwwwwww"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

    @Override
    public void send(TaskWrapper wrapper) throws RemoteException {
        stub.send(wrapper);
    }

    @Override
    public IBinder asBinder() {
        return stub;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Mars.onDestroy();
    }
}
