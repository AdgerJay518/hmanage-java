package com.manage.domin;

import com.manage.model.CmsSubject;
import com.manage.model.HomeAdvertise;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by jonyon on 2021/9/26.
 */
@Getter
@Setter
public class HomeContentResult {
    //轮播广告
    private List<HomeAdvertise> advertiseList;
    //推荐专题
    private List<CmsSubject> subjectList;
}
