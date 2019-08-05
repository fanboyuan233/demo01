package com.czxy.service;

import com.czxy.dao.PowerMapper;
import com.czxy.dao.UserMapper;
import com.czxy.domain.Power;
import com.czxy.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PowerMapper powerMapper;

    public List<User>login(User user){
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",user.getUsername());
        criteria.andEqualTo("password",user.getPassword());
        List<User> userList = userMapper.selectByExample(example);
        return userList;
    }


    public List<User> register(User user){
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",user.getUsername());
        List<User> list = userMapper.selectByExample(example);
        return list;
    }

    public void addUser(User user){
        userMapper.insert(user);
    }

    public List<User>findAll(){
        List<User> users = userMapper.selectAll();
        List<Power> powers = powerMapper.selectAll();
        for (User user : users) {
            for (Power power : powers) {
                if (user.getPid()==power.getPid()){
                    user.setPower(power);
                }
            }
        }
        return users;
    }
}
