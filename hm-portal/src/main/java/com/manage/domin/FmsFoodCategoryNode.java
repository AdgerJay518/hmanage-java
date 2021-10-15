package com.manage.domin;

import com.manage.model.FmsFoodCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by jonyon on 2021/10/15.
 */
@Getter
@Setter
public class FmsFoodCategoryNode extends FmsFoodCategory {
    @ApiModelProperty("子分类集合")
    private List<FmsFoodCategoryNode> children;
}
