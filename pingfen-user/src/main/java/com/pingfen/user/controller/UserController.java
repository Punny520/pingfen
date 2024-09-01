package com.pingfen.user.controller;

import cn.hutool.core.util.StrUtil;
import com.pingfen.user.common.Result;
import com.pingfen.user.dto.UserDTO;
import com.pingfen.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: UserController
 * @author: Punny
 * @date: 2024/8/25 23:09
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 根据手机号获取验证码
     * @param phoneNumber
     * @return
     */
    @GetMapping("/getCode")
    public Result code(@RequestParam("phoneNumber") String phoneNumber){
        // TODO 验证phoneNumber
        userService.getCode(phoneNumber);
        return Result.ok(phoneNumber);
    }

    /**
     * 用户登录
     * @param userDTO
     * @return
     */
    @PostMapping("/doLogin")
    public Result doLogin(@RequestBody UserDTO userDTO){
        //TODO 验证
        return userService.doLogin(userDTO);
    }

    /**
     * 添加新用户
     * @param userDTO
     * @return
     */
    @PostMapping("/addUser")
    public Result addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }
}
