package com.example.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ESUserInfoService implements IESUserInfoService {
    
    @Autowired
    private ESUserInfoRepository esUserInfoRepository;

    public UserInfo queryUserInfoById(String id) {
        Optional<UserInfo> result = esUserInfoRepository.findById(id);
        return result == null ? null : result.get();
    }

    public UserInfo queryUserInfoByUserName(String userName) {
        return esUserInfoRepository.findByUserName(userName);
    }

    public void save(UserInfo userInfo) {
        esUserInfoRepository.save(userInfo);
    }

}
