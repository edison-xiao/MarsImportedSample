package mark.com.stnservice;

import android.os.RemoteException;

import com.tencent.mars.xlog.Log;

/**
 * Created by fanzhengchen on 4/10/17.
 */

public class TextTaskWrapper extends TaskWrapper.Stub {

    private static final String TAG = TextTaskWrapper.class.getName();

    private String mRequest;
    private String mResponse = "null";

    public TextTaskWrapper(String request) {
        mRequest = request;
    }

    @Override
    public byte[] req2buf() throws RemoteException {
        StackTraceElement element = new Throwable().getStackTrace()[0];
        Log.i(TAG, String.format("%s (%s:%d)", mRequest, element.getFileName(),
                element.getLineNumber()));
        return mRequest.getBytes();
//        return ByteBuffer.wrap(mRequest.getBytes());
//        return mRequest.getBytes();
    }

    @Override
    public int buf2resp(byte[] buf) throws RemoteException {
        mResponse = new String(buf);
        System.out.println("response " + mResponse);
        return buf.length;
    }
}
