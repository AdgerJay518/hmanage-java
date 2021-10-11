package com.manage.domin;

import com.manage.model.PlanItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by jonyon on 2021/10/10.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PlanItemList extends PlanItem {
    //积分
    private Integer integration;
    //成长值
    private Integer growth;
}
