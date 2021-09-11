package com.coder.springboot.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.lang.annotation.Documented;

/**
 * Created by kougavin on 11/09/2021.
 */
@Data
@Document
public class User implements Serializable {

    @Id
    private Long id;

    private String userName;
    private String note;
}
