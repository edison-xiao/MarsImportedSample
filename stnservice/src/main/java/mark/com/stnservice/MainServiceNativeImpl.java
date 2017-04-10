package mark.com.stnservice;

import com.tencent.mars.app.AppLogic;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.mars.stn.StnLogic;

import java.io.ByteArrayOutputStream;

/**
 * Created by fanzhengchen on 4/10/17.
 */
@Deprecated
public class MainServiceNativeImpl implements StnLogic.ICallBack,SdtLogic.ICallBack, AppLogic.ICallBack {

    /**
     * AppLogic 的回调接口实现
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

    /**
     * SDT 组件的回调方法，以下均不是
     * @param resultsJson
     */
    @Override
    public void reportSignalDetectResults(String resultsJson) {

    }

    /**
     * STN 回调
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

    /**
     * encoder
     * @param taskID
     * @param userContext
     * @param reqBuffer
     * @param errCode
     * @param channelSelect
     * @return
     */
    @Override
    public boolean req2Buf(int taskID, Object userContext, ByteArrayOutputStream reqBuffer, int[] errCode, int channelSelect) {
        return false;
    }

    /**
     * decoder
     * @param taskID
     * @param userContext
     * @param respBuffer
     * @param errCode
     * @param channelSelect
     * @return
     */
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
}
