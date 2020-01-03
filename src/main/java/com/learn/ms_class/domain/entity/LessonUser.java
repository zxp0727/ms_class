package com.learn.ms_class.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName LessonUser
 * @Description 课程用户关系实体
 * @Author ZhouXiaoPing
 * @Date 2020/1/3 16:11
 **/
@Table(name = "lesson_user")
@Entity
@Data
public class LessonUser {
    @Column
    @Id
    private Integer lessonId;
    @Column
    private Integer userId;
}
