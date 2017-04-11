package mark.com.stnservice;

/**
 * Created by fanzhengchen on 4/10/17.
 */

public interface Profile {

    public static final int CMD_ID_SEND_MESSAGE = 3;

    String getHost();

    int[] getLongLinkPorts();

    short getProduceId();
}
