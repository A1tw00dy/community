package com.travel.enums;

public enum  NotificationTypeEnum {
    UNREAD(0),READ(1)
    ;
    private int status;

    public int getStatus() {
        return status;
    }

    NotificationTypeEnum(int status) {
        this.status = status;
    }
}
