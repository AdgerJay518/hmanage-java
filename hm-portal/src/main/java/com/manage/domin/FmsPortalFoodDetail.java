package com.manage.domin;

import com.manage.model.FmsFood;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by jonyon on 2021/10/15.
 */
@Getter
@Setter
public class FmsPortalFoodDetail {
    @ApiModelProperty("食品信息")
    private FmsFood food;
}
