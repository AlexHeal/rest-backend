package github.alexheal.restbackend.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserInfo {
    Date loginDate;
    String username;
}
