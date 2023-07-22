package com.hty.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author hty
 * @date 2023-07-18 21:26
 * @email 1156388927@qq.com
 * @description
 * @other 更多请看www.autunomy.top
 */

@Data
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "passwd")
    private String passwd;

    @Column(name = "user_role")
    private String userRole;
}
