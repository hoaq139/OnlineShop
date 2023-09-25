package com.example.onlineshop.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccountDTOResponse {
    int id;
    String username;
    String email;
}
