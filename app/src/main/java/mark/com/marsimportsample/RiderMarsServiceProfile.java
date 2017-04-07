package mark.com.marsimportsample;

/**
 * Created by fanzhengchen on 4/7/17.
 */

public class RiderMarsServiceProfile implements MarsServiceProfile {

    static final short MAGIC = 0x0110;
    static final short PRODUCT_ID = 200;
    static final String LONG_LINK_HOST = "172.16.14.115";
    static final int[] LONG_LINK_PORTS = new int[]{8007};
    static final int SHORT_LINK_PORT = 8080;

    @Override
    public short magic() {
        return MAGIC;
    }

    @Override
    public short productID() {
        return PRODUCT_ID;
    }

    @Override
    public String longLinkHost() {
        return LONG_LINK_HOST;
    }

    @Override
    public int[] longLinkPorts() {
        return LONG_LINK_PORTS;
    }

    @Override
    public int shortLinkPort() {
        return SHORT_LINK_PORT;
    }
}
