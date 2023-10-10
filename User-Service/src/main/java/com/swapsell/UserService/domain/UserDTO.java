package com.swapsell.UserService.domain;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
