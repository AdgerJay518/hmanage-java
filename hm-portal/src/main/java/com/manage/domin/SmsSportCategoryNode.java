package com.manage.domin;

import com.manage.model.SmsSportCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by jonyon on 2021/9/12.
 */
@Getter
@Setter
public class SmsSportCategoryNode extends SmsSportCategory {
    @ApiModelProperty("子分类集合")
    private List<SmsSportCategoryNode> children;
}
