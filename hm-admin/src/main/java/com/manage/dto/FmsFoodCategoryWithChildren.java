package com.manage.dto;

import com.manage.model.FmsFoodCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *
 * @author jonyon
 * @date 2021/10/24
 */
@Data
public class FmsFoodCategoryWithChildren extends FmsFoodCategory {
    @Getter
    @Setter
    @ApiModelProperty("子级分类")
    private List<FmsFoodCategory> children;
}
