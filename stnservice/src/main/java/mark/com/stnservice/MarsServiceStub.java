package mark.com.stnservice;

import android.content.Context;
import android.os.RemoteException;

import com.tencent.mars.app.AppLogic;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.mars.stn.StnLogic;

import java.io.ByteArrayOutputStream;

/**
 * Created by fanzhengchen on 4/10/17.
 */

public class MarsServiceStub extends MarsService.Stub implements StnLogic.ICallBack, SdtLogic.ICallBack, AppLogic.ICallBack {


    private final Context mContext;


    public MarsServiceStub(Context context) {
        mContext = context;
    }

    @Override
    public void send(TaskWrapper wrapper) throws RemoteException {

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
        return new String[0];
    }

    @Override
    public void onPush(int cmdid, byte[] data) {

    }

    @Override
    public boolean req2Buf(int taskID, Object userContext, ByteArrayOutputStream reqBuffer, int[] errCode, int channelSelect) {
        return false;
    }

    @Override
    public int buf2Resp(int taskID, Object userContext, byte[] respBuffer, int[] errCode, int channelSelect) {
        return 0;
    }

    @Override
    public int onTaskEnd(int taskID, Object userContext, int errType, int errCode) {
        return 0;
    }

    @Override
    public void trafficData(int send, int recv) {

    }

    @Override
    public void reportConnectInfo(int status, int longlinkstatus) {

    }

    @Override
    public int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream identifyReqBuf, ByteArrayOutputStream hashCodeBuffer, int[] reqRespCmdID) {
        return 0;
    }

    @Override
    public boolean onLongLinkIdentifyResp(byte[] buffer, byte[] hashCodeBuffer) {
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
    //---------------StnLogic 回调结束------------------------------


    /**
     * SdtLogic的回调
     * @param resultsJson
     */
    @Override
    public void reportSignalDetectResults(String resultsJson) {

    }

    /**
     * AppLogic的回调 以下均是
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
