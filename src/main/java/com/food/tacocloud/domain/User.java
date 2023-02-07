package com.food.tacocloud.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String address;
}
