package github.alexheal.restbackend.controller;

import github.alexheal.restbackend.domain.LoginInfo;
import github.alexheal.restbackend.domain.UserInfo;
import github.alexheal.restbackend.exception.InvalidUserNameException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BankController {

    @PostMapping("user/login")
    public UserInfo login(@RequestBody LoginInfo loginInfo) {
        if (loginInfo.getUsername().equals("DemoUser")) {
            return UserInfo.builder()
                    .loginDate(new Date())
                    .username(loginInfo.getUsername())
                    .build();
        } else {
            throw new InvalidUserNameException();
        }
    }
}
