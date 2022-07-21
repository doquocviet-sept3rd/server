package com.spring.server.model.enumeration;

/**
 * @author Do Quoc Viet
 * @version 1.0
 * @since July 21, 2022 - 22:11:10
 */
public enum Status {

    SERVER_UP("SERVER_UP"),
    SERVER_DOWN("SERVER_DOWN");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
