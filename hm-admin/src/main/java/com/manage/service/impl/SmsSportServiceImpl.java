package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.dao.SmsSportDao;
import com.manage.dto.SmsSportQueryParam;
import com.manage.dto.SmsSportResult;
import com.manage.mapper.SmsSportMapper;
import com.manage.model.SmsSport;
import com.manage.service.SmsSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  运动列表操作实现类
 * @author jonyon
 * @date 2021/8/17
 */
@Service
public class SmsSportServiceImpl implements SmsSportService {
    @Autowired
    private SmsSportMapper smsSportMapper;

    @Autowired
    private SmsSportDao sportDao;

    @Override
    public List<SmsSport> list(SmsSportQueryParam sportQueryParam,
                               Integer pageSize,
                               Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        SmsSport smsSport = new SmsSport();
        if (sportQueryParam.getKeyword()!=null){
            smsSport.setName("%"+sportQueryParam.getKeyword()+"%");
        }
        if (sportQueryParam.getSportSn()!=null){
            smsSport.setSportSn("%"+sportQueryParam.getSportSn()+"%");
        }
        if (sportQueryParam.getSportCategoryId()!=null){
            smsSport.setSportCategoryId(sportQueryParam.getSportCategoryId());
        }
        return smsSportMapper.selectBySport(smsSport);
    }

    @Override
    public SmsSportResult getUpdateInfo(Long id) {
        return sportDao.getUpdateInfo(id);
    }

    @Override
    public int update(Long id, SmsSport smsSport) {
        int count;
        //更新信息
        smsSport.setId(id);
        smsSportMapper.updateByPrimaryKeySelective(smsSport);
        count = 1;
        return count;
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {

        return smsSportMapper.updateStatusByIds(recommendStatus,ids);
    }

    @Override
    public int create(SmsSport smsSport) {
        int count;
        smsSport.setId(null);
        smsSportMapper.insertSelective(smsSport);
        count = 1;
        return count;
    }

    @Override
    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        return smsSportMapper.deleteByIds(ids);
    }
}
