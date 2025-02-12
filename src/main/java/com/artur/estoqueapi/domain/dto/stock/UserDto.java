package com.artur.estoqueapi.domain.dto.stock;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserDto {
    private String username;
    private String password;
}
