package com.example.storagemanager.entity.dto;

import lombok.Data;

@Data
public class InOutStoragePageQueryDTO {
    private String goodsName;
    private String storageName;
    private String userName;
    private Integer page;
    private Integer pageSize;
}
