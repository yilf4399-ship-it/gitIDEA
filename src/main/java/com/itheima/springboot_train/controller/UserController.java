package com.itheima.springboot_train.controller;

import com.itheima.springboot_train.common.Page;
import com.itheima.springboot_train.entity.User;
import com.itheima.springboot_train.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController  // 可返回JSON数据
@RequestMapping("/api/users") // 设置请求路径前缀
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    // 查询总用户列表
    @GetMapping("/all")
    public List<User> getAllUsers() {
        List<User> result = userService.findAllUsers();
        log.info("result={}", result);
        return result;
    }

    // 分页查询
    @GetMapping("/list")
    public Page<User> getUserList(
        @RequestParam(defaultValue = "1") Integer pageNum,
        @RequestParam(defaultValue = "10") Integer pageSize,
        @RequestParam(required = false) String accountname,
        @RequestParam(required = false) String phone,
        @RequestParam(required = false) String email) {
        Page<User> result = userService.findPage(pageNum, pageSize, accountname, phone, email);
//        log.info("result={}", result);
        return result;
    }

    // 获取用户详情
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        log.info("请求获取用户详情，id={}", id);
        User user = userService.findById(id);
        if (user == null) {
            log.warn("未找到用户，id={}", id);
            return null;
        }
        log.info("找到用户，id={}, user={}", id, user);
//        System.out.println("nihao");
        return user;
    }

    // 新增用户
    @PostMapping
    public Boolean addUser( @RequestBody User user) {
        boolean result = userService.addUser(user);
        return result;
    }

    // 更新用户信息
    @PutMapping("/{id}")
    public Boolean updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        boolean result = userService.updateUser(user);
        return result;
    }

    // 删除用户
    @DeleteMapping("/{id}")
    public Boolean deleteUser(@PathVariable Long id) {
        boolean result = userService.deleteUser(id);
        return result;
    }
}
