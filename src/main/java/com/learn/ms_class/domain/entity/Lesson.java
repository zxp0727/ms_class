package com.learn.ms_class.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName Lesson
 * @Description 课程实体
 * @Author ZhouXiaoPing
 * @Date 2020/1/3 16:06
 **/
@Table(name = "lesson")
@Entity
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String title;
    @Column
    private String cover;
    @Column
    private BigDecimal price;
    @Column
    private String description;
    @Column
    private Date createTime;
    @Column
    private String videoUrl;
}
