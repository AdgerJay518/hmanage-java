package com.manage.domin;

import com.manage.model.SmsSport;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by jonyon on 2021/9/30.
 */
@Getter
@Setter
public class PmsPortalSportDetail {
    @ApiModelProperty("运动信息")
    private SmsSport sport;
}
