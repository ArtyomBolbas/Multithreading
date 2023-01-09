package org.example.yuriy_tkach_youtube.concurrency_1;

public class InsufficientFundException extends RuntimeException {

    public InsufficientFundException(String message) {
        super(message);
    }

    public InsufficientFundException(String message, Throwable cause) {
        super(message, cause);
    }

}
