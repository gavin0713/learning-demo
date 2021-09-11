package com.coder.springboot.enumerration;

import lombok.Data;

/**
 * Created by kougavin on 11/09/2021.
 */
public enum SexEnum {
    FEMALE(0, "女"),
    MALE(1, "男");


    private final int code;
    private final String name;

    SexEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static SexEnum getSexEnum(int code) {
        for (SexEnum item : SexEnum.values()) {
            if (item.code == code) {
                return item;
            }
        }
        return null;
    }
}
