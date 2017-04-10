package mark.com.stnservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by fanzhengchen on 4/10/17.
 */

public class MainServiceImpl extends Service implements MarsService {


    /**
     * MarsService桩 消息发送接收的真正执行者
     */
    MarsServiceStub stub;

    @Override
    public void onCreate() {
        super.onCreate();
        stub = new MarsServiceStub(this);
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
}
