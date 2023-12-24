package com.example.storagemanager.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class CommonQueryPageVO<T> {
    private List<T> list;
    private Long total;
}
