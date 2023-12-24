package com.example.storagemanager.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
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
@TableName("Goods")
@ApiModel(value="Goods对象", description="")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer providerId;

    private Integer num;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;


}
