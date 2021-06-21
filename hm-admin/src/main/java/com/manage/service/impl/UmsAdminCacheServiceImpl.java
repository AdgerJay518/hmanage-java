package com.manage.service.impl;

import com.manage.model.UmsAdmin;
import com.manage.model.UmsResource;
import com.manage.common.service.RedisService;
import com.manage.service.UmsAdminCacheService;
import com.manage.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsAdminCacheServiceImpl implements UmsAdminCacheService {
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private RedisService redisService;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;
    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        return (List<UmsResource>) redisService.get(key);
    }

    @Override
    public void setResourceList(Long adminId, List<UmsResource> resourceList) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisService.set(key, resourceList, REDIS_EXPIRE);
    }

    @Override
    public void delResourceList(Long adminId) {
        String key=REDIS_DATABASE+":"+REDIS_KEY_RESOURCE_LIST+":"+adminId;
        redisService.del(key);
    }

    @Override
    public UmsAdmin getAdmin(String username) {
        String key=REDIS_DATABASE+":"+REDIS_KEY_ADMIN+":"+username;
        return (UmsAdmin) redisService.get(key);
    }

    @Override
    public void setAdmin(UmsAdmin admin) {
        String key=REDIS_DATABASE+":"+REDIS_KEY_ADMIN+":"+admin.getUsername();
        redisService.set(key,admin,REDIS_EXPIRE);
    }

    @Override
    public void delAdmin(Long adminId) {
        UmsAdmin admin = adminService.getById(adminId);
        if (admin!=null){
            String key=REDIS_DATABASE+":"+REDIS_KEY_ADMIN+":"+admin.getUsername();
            redisService.del(key);
        }
    }
}
