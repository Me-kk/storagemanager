package com.example.storagemanager.entity.dto;

import lombok.Data;

@Data
public class UpdatePasswordDTO {
    private String username;
    private String password;
    private String newPassword;
}
