// MarsService.aidl
package mark.com.stnservice;

import mark.com.stnservice.TaskWrapper;
// Declare any non-default types here with import statements

interface MarsService {


    void send(TaskWrapper wrapper);
}
