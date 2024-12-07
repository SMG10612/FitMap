package com.sports.fitMap.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id; // 사용자 고유 ID

    private String username; // 닉네임

    private String password; // 비밀번호

    private String email; // 이메일(아이디)

    private String address; // 주소

    private String remarks; // 비고
}
