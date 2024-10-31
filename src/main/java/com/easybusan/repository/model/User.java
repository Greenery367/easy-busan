package com.easybusan.repository.model;

import java.sql.Timestamp;

import lombok.*;

import java.text.SimpleDateFormat;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data

public class User {
    private Integer user_id; // (pk) auto_increment
    private String email;
    private String password;
    private String type; // member, unknown, manager
    private String user_name;
    private Integer age;
    private Integer gender;
    private String user_legion;
    private Timestamp createdAt;
	private String createdAtFormat;

    public void getFormattedCreatedAt() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.createdAtFormat = formatter.format(createdAt);
    }
}
