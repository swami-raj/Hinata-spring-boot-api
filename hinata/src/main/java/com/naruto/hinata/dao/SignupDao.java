package com.naruto.hinata.dao;

import com.naruto.hinata.entity.SignupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignupDao extends CrudRepository<SignupEntity,Long> {
    public List<SignupEntity> findAll();
    public SignupEntity findById(long id);



}
