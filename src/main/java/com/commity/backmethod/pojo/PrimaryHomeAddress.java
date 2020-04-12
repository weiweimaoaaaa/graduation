package com.commity.backmethod.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PrimaryHomeAddress implements Serializable {
    private String province;
    private String city;
    private String county;
    private String street;
    private String community;
    private String unit;
    private String homeNumber;
}
