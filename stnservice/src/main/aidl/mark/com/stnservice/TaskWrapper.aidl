// TaskWrapper.aidl
package mark.com.stnservice;

// Declare any non-default types here with import statements

interface TaskWrapper {
     byte[] req2buf();

     int buf2resp(in byte[] buf);
}
