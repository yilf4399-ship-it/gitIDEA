package com.itheima.springboot_train.service.impl;

import com.itheima.springboot_train.common.Page;
import com.itheima.springboot_train.entity.User;
import com.itheima.springboot_train.mapper.UserMapper;
import com.itheima.springboot_train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> findPage(Integer pageNum, Integer pageSize, String accountname, String phone, String email) {
        // 计算当前页起始索引
        int start = (pageNum-1)*pageSize;
        // 调用Mapper查询用户列表
        Page<User> result = new Page<>();
        result.setRows(userMapper.findUsers(accountname, phone, email, start, pageSize));
        result.setTotal((long)userMapper.countUsers(accountname, phone, email));
        result.setPageSize(pageSize);
        result.setPageNum(pageNum);
        // 计算总页数
        result.setPages((int) Math.ceil((double) result.getTotal() / pageSize));
        return result;
    }

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }
    @Transactional // 开启事务回滚
    @Override
    public boolean addUser(User user) {
//        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
//
//        }
        return userMapper.addUser(user) > 0;
    }
    @Transactional
    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user) > 0;
    }
    @Transactional
    @Override
    public boolean deleteUser(Long id) {
        return userMapper.deleteUser(id) > 0;
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

}
