package github.alexheal.restbackend.controller;

import github.alexheal.restbackend.domain.LoginInfo;
import github.alexheal.restbackend.domain.UserInfo;
import github.alexheal.restbackend.exception.InvalidUserNameException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BankController {
    Map<String, UserInfo> users = Map.of(
            "ALex", UserInfo.builder().username("Alex").build(),
            "Olga", UserInfo.builder().username("Olga").build(),
            "Invan", UserInfo.builder().username("Invan").build()
    );

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

    @GetMapping("user/getAll")
    public List<UserInfo> getAllUsersInfo() {
        return users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
