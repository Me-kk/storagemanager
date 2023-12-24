package com.example.storagemanager.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PageQueryGoodsDTO {
    private String name;
    private Integer providerId;
    private Integer storageId;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
    private Integer page;
    private Integer pageSize;
}
