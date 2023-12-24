package com.example.storagemanager.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author guopei
 * @since 2023-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Outstorage对象", description="")
public class Outstorage implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer goodsId;

    private Integer userId;

    private Integer num;

    private Integer storageId;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;


}
