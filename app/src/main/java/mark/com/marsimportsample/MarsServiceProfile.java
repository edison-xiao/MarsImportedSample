package mark.com.marsimportsample;

/**
 * Created by fanzhengchen on 4/7/17.
 */

public interface MarsServiceProfile {

    short magic();

    short productID();

    String longLinkHost();

    int[] longLinkPorts();

    int shortLinkPort();
}
