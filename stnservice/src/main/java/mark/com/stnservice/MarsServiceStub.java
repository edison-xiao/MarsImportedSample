package mark.com.stnservice;

import android.content.Context;
import android.os.RemoteException;

import com.orhanobut.logger.Logger;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.xlog.Log;

import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by fanzhengchen on 4/10/17.
 */

public class MarsServiceStub extends MarsService.Stub implements StnLogic.ICallBack, SdtLogic.ICallBack, AppLogic.ICallBack {

    private static final String TAG = MarsServiceStub.class.getName();

    private final Context mContext;

    private static Map<Integer, TaskWrapper> TASK_ID_TO_WRAPPER = new ConcurrentHashMap<>();
    private static Map<TaskWrapper, Integer> WRAPPER_TO_TASK_ID = new ConcurrentHashMap<>();


    public MarsServiceStub(Context context) {
        mContext = context;
    }

    @Override
    public void send(TaskWrapper wrapper) throws RemoteException {

        System.out.println("start task");
        StnLogic.Task task = new StnLogic.Task(StnLogic.Task.ELong,
                Profile.CMD_ID_SEND_MESSAGE
                , "", null);
//        task.shortLinkHostList = DebugProfile.HOSTS;

        TASK_ID_TO_WRAPPER.put(task.cmdID, wrapper);

        StnLogic.startTask(task);
    }

    /**
     * StnLogic 回调开始
     *
     * @return
     */
    @Override
    public boolean makesureAuthed() {
        return false;
    }

    @Override
    public String[] onNewDns(String host) {
        return new String[]{
                "172.16.25.79",
//                "118.89.24.72"
        };
    }

    @Override
    public void onPush(int cmdid, byte[] data) {

    }

    @Override
    public boolean req2Buf(int taskID, Object userContext, ByteArrayOutputStream reqBuffer, int[] errCode, int channelSelect) {
        Log.i("fuck", taskID + "");
        TaskWrapper wrapper = TASK_ID_TO_WRAPPER.get(taskID);
        try {
            reqBuffer.write(wrapper.req2buf());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int buf2Resp(int taskID, Object userContext, byte[] respBuffer, int[] errCode, int channelSelect) {
//        int result = respBuffer.length;
        System.out.println("fuck buf2Resp");
        TaskWrapper wrapper = TASK_ID_TO_WRAPPER.get(taskID);
        int result = StnLogic.RESP_FAIL_HANDLE_TASK_END;
        try {
            result = wrapper.buf2resp(respBuffer);
        } catch (Exception e) {
            TASK_ID_TO_WRAPPER.remove(taskID);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int onTaskEnd(int taskID, Object userContext, int errType, int errCode) {
        return 0;
    }

    @Override
    public void trafficData(int send, int recv) {
        Logger.i("trafficData %s", "send " + send + " recv:" + recv);
    }

    @Override
    public void reportConnectInfo(int status, int longlinkstatus) {
        Logger.i("report ConnectInfo %s", String.format("status %d longLinkStatus %d", status, longlinkstatus));
    }

    /**
     * 发送心跳后收到的回调
     *
     * @param identifyReqBuf
     * @param hashCodeBuffer
     * @param reqRespCmdID
     * @return
     */
    @Override
    public int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream identifyReqBuf, ByteArrayOutputStream hashCodeBuffer, int[] reqRespCmdID) {
        System.out.println("get long link " + MyThrowable.printDefault());
        for (int id : reqRespCmdID) {
            System.out.println("id " + id);
        }
        return StnLogic.ECHECK_NOW;
    }

    @Override
    public boolean onLongLinkIdentifyResp(byte[] buffer, byte[] hashCodeBuffer) {
        System.out.println("on long link resp " + MyThrowable.printDefault());
        return false;
    }


    @Override
    public void requestDoSync() {

    }

    @Override
    public String[] requestNetCheckShortLinkHosts() {
        return new String[0];
    }

    @Override
    public boolean isLogoned() {
        return false;
    }

    @Override
    public void reportTaskProfile(String taskString) {

    }
    //---------------StnLogic 回调的方法到此为止 以下都是SdtLogic的回调------------------------------


    /**
     * SdtLogic的回调
     *
     * @param resultsJson
     */
    @Override
    public void reportSignalDetectResults(String resultsJson) {
        Logger.json(resultsJson);
    }

    /**
     * AppLogic的回调 以下均是
     *
     * @return
     */
    @Override
    public String getAppFilePath() {
        return null;
    }

    @Override
    public AppLogic.AccountInfo getAccountInfo() {
        return null;
    }

    @Override
    public int getClientVersion() {
        return 0;
    }

    @Override
    public AppLogic.DeviceInfo getDeviceType() {
        return null;
    }
}
