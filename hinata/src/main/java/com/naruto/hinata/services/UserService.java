package com.naruto.hinata.services;

import com.naruto.hinata.dao.SignupDao;
import com.naruto.hinata.dao.UserDao;
import com.naruto.hinata.dto.SignupDto;
import com.naruto.hinata.dto.UserDto;
import com.naruto.hinata.entity.SignupEntity;
import com.naruto.hinata.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
//    private static List<SignupEntity> list = new ArrayList<>();
    @Autowired
    UserDao userdao;

    @Autowired
    SignupDao signdao;

    public String login(UserDto userdto){
        UserEntity userentity = new UserEntity();
        userentity.setName(userdto.getName());
        userentity.setMail(userdto.getMail());
        userdao.save(userentity);
        return "success";
    }

//    @Autowired
//    SignupDao signupdao;
//    public String signup(SignupDto signupdto){
//        SignupEntity signupentity=new SignupEntity();
//        signupentity.setName(signupdto.getName());
//        signupentity.setGmail(signupdto.getGmail());
//        signupentity.setAddress(signupdto.getAddress());
//        signupdao.save(signupentity);
//        return "success saved";
//    }

    @Autowired
    SignupDao signupdao;
    public String signup(List<SignupDto> signupdtos) {
        signupdtos.forEach(signupDto -> {
            SignupEntity signupEntity = new SignupEntity();
            signupEntity.setName(signupDto.getName());
            signupEntity.setGmail(signupDto.getGmail());
            signupEntity.setAddress(signupDto.getAddress());
            signupdao.save(signupEntity);
        });
        return "success saved";
    }

    public List<SignupDto> getall(){

        List<SignupEntity> signupdata=new ArrayList<>();
        signupdata.addAll(signupdao.findAll()) ;
        List<SignupDto>signdtos=new ArrayList<>();

        signupdata.forEach(signup->{
            SignupDto signupdto=new SignupDto();
            signupdto.setId(signup.getId());
            signupdto.setName(signup.getName());
            signupdto.setGmail(signup.getGmail());
            signupdto.setAddress(signup.getAddress());
            signdtos.add(signupdto);
        });

        return signdtos;
    }

    public SignupDto getUser(Long id) {
        SignupDto dto = new SignupDto();
        Optional<SignupEntity> optionalUser = signdao.findById(id);
        if (optionalUser.isPresent()) {
            SignupEntity user = optionalUser.get();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setGmail(user.getGmail());
        }
        return dto;
    }

    public void delete(Long id) {
        signupdao.deleteById(id);
    }

    public SignupDto updateDetail(SignupDto signupdto, Long id) {
        Optional<SignupEntity> optionalUser = signdao.findById(id);
        if (optionalUser.isPresent()) {
            SignupEntity signupEntity = optionalUser.get();
            signupEntity.setName(signupdto.getName());
            signupEntity.setGmail(signupdto.getGmail());
            signupEntity.setAddress(signupdto.getAddress());
            signupdao.save(signupEntity);
            signupdto.setId(signupEntity.getId());
            return signupdto;
        }
        return null;
    }
}
