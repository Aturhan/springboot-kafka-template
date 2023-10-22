package com.abdullahturhan.accountservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {
    private String user_id;
    private String user_firstname;
    private String user_lastname;
    private String user_email;
    private Double balance;
}
