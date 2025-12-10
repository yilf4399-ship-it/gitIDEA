package com.itheima.springboot_train.mapper;


import com.itheima.springboot_train.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
public interface UserMapper {
    // 查询用户列表，模糊查询和分页查询
    List<User> findUsers(@Param("accountname") String accountname ,
                         @Param("phone") String phone,
                         @Param("email") String email,
                         @Param("start") int start,
                         @Param("limit") int limit);
    // 统计用户数量
    int countUsers(@Param("accountname") String accountname,
                   @Param("phone") String phone,
                   @Param("email") String email);
    // 添加用户  --单个普通参数无需命名，会自动绑定参数
    User findById(Long id);
    // 添加用户
    int addUser(User user); // 返回受影响行数
    // 更新用户
    int updateUser(User user);
    // 删除用户
    int deleteUser(Long id);


    List<User> findAllUsers();
}
