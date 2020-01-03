package com.learn.ms_class.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName UserDTO
 * @Description UserDTO
 * @Author ZhouXiaoPing
 * @Date 2020/1/3 16:47
 **/
@Data
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private BigDecimal money;
    private String role;
    private Date regTime;
}
