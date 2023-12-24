package com.example.storagemanager.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodsDetailVO {
    private Integer goodsId;
    private String name;
    private Integer num;
    private Integer providerId;
    private String providerName;
    private String providerPhone;
    private Integer storageId;
    private String storageName;
    private Integer storageNum;
    private LocalDateTime gmtCreate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime goodsCreate;
    private LocalDateTime gsCreate;
}
