package com.example.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ESUserInfoRepository extends ElasticsearchRepository<UserInfo, String> {
    
    UserInfo findByUserName(String userName);
    
}
