package com.manage.dto;

import com.manage.model.SmsSportCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *
 * @author jonyon
 * @date 2021/8/17
 */
@Data
public class SmsSportCategoryWithChildren extends SmsSportCategory{
    @Getter
    @Setter
    @ApiModelProperty("子级分类")
    private List<SmsSportCategory> children;
}
