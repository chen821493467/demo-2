package com.example.es.repository;

import com.example.pojo.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsUserRepository extends ElasticsearchRepository<User, String> {

}
