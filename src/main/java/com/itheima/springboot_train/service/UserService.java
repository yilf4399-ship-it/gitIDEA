package com.itheima.springboot_train.service;

import com.itheima.springboot_train.common.Page;
import com.itheima.springboot_train.entity.User;

import java.util.List;

public interface UserService {
    //分页查询用户列表
    Page<User> findPage(Integer pageNum, Integer pageSize, String accountname, String phone, String email);
    // 根据ID查询用户
    User findById(Long id);
    // 添加用户
    boolean addUser(User user);
    // 更新用户
    boolean updateUser(User user);
    // 删除用户
    boolean deleteUser(Long id);

    List<User> findAllUsers();
}
