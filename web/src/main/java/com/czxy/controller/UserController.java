package com.czxy.controller;

import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<String> login(User user, HttpServletRequest request){
        System.out.println(user);
        try {
            List<User> list = userService.login(user);
            if (list.isEmpty()){
                return new ResponseEntity<>("用户名或密码错误", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("登陆成功",HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("服务器异常",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
