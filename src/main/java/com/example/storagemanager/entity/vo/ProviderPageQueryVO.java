package com.example.storagemanager.entity.vo;

import com.example.storagemanager.entity.Provider;
import lombok.Data;

import java.util.List;

@Data
public class ProviderPageQueryVO {
    private List<Provider> list;
    private Integer total;
}
