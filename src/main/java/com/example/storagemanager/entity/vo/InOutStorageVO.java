package com.example.storagemanager.entity.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InOutStorageVO {
    private String goodsName;
    private LocalDateTime gmtCreate;
    private Integer num;
    private String storageName;
    private String userName;
}
