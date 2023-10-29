package com.swapsell.AuthenticationService.domain;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private  String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
