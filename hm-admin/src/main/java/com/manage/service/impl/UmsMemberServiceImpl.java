package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.mapper.UmsMemberMapper;
import com.manage.model.UmsMember;
import com.manage.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by jonyon on 2021/11/2.
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private UmsMemberMapper memberMapper;

    @Override
    public List<UmsMember> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        UmsMember umsMember = new UmsMember();
        if (!StringUtils.isEmpty(keyword)){
            umsMember.setUsername("%" + keyword + "%");
        }
        return memberMapper.selectAllMember(umsMember.getUsername());
    }

    @Override
    public int updateStatus(Long id, UmsMember umsMember) {
        umsMember.setId(id);
        return memberMapper.update(umsMember);
    }

    @Override
    public int delete(Long id) {
        return memberMapper.delete(id);
    }
}
