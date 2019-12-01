package com.malviya.pmp.exception;

public class UserBlockedException extends Exception {
	   //without Error Exception
    public UserBlockedException() {
    }
    
    //With error exception
    public UserBlockedException(String errDec) {
        super(errDec);
    }

}
