package com.abdullahturhan.emailservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateEvent {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
