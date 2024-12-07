package com.sports.fitMap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "site_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id 값이 없을 경우 null 처리

    @Column
    private String username; // 닉네임

    @Column
    private String password; // 비밀번호

    @Column(unique = true)
    private String email; // 이메일(아이디)

    @Column
    private String address; // 주소

    @Column
    private String remarks; // 비고
}
