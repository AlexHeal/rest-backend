package github.alexheal.restbackend.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginInfo  {
    String username;
    String password;
}
