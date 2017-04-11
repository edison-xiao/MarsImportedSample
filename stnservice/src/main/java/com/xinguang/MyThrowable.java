package com.xinguang;

/**
 * Created by fanzhengchen on 4/10/17.
 */

public class MyThrowable extends Throwable {

    public MyThrowable() {
        super();
    }

    public MyThrowable(String message) {
        super(message);
    }

    public String printCodeLine() {
        StackTraceElement element = getStackTrace()[0];
        return "(" + element.getFileName() + ":" + element.getLineNumber() + ")";
    }

    public static String printDefault(){
        return new MyThrowable().printCodeLine();
    }
}
