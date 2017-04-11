package mark.com.stnservice;

import java.util.ArrayList;

/**
 * Created by fanzhengchen on 4/10/17.
 */

public class DebugProfile implements Profile {


    public static final ArrayList<String> HOSTS = new ArrayList<String>() {{

        add("172.16.25.79");
        add("118.89.24.72");
    }};

    @Override
    public String getHost() {
//        return "118.89.24.72";
        return "172.16.25.79";
    }

    @Override
    public int[] getLongLinkPorts() {
//        return new int[]{8081};
        return new int[]{12345};

    }

    @Override
    public short getProduceId() {
        return 1;
    }
}
