package com.itheima.springboot_train.entity;
import lombok.Data;

// 自动生成getter/setter/toString等方法--需要依赖lombok
@Data
public class User {
    private Long id;            // 用户ID
    private String accountname;    // 用户名
    private String phone;       // 电话号码
    private String email;       // 邮箱
    private String role;        // 角色
    private String password;    // 密码
    private String remark;      // 备注
}
