package com.learn.ms_class.service.impl;

import com.learn.ms_class.domain.UserDTO;
import com.learn.ms_class.domain.entity.Lesson;
import com.learn.ms_class.domain.entity.LessonUser;
import com.learn.ms_class.repository.LessonRepository;
import com.learn.ms_class.repository.LessonUserRepository;
import com.learn.ms_class.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @ClassName LessonServiceImpl
 * @Description 课程服务
 * @Author ZhouXiaoPing
 * @Date 2020/1/3 16:20
 **/
@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private LessonUserRepository lessonUserRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Lesson buyLessonById(Integer id) {
        Lesson lesson = this.lessonRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("课程不存在！"));
        LessonUser lessonUser = this.lessonUserRepository.findByLessonId(lesson.getId());
        if(lessonUser != null){
            return lesson;
        }
        LessonUser lessonUser1 = this.lessonUserRepository.findById(lesson.getId()).orElse(null);
        if(lessonUser1 != null){
            return lesson;
        }

        //不存在查询当前登陆用户信息。
        //todo 用户登陆信息
        UserDTO userDTO = restTemplate.getForObject(
                "http://127.0.0.1:8081/user/getById/{userId}",
                UserDTO.class,
                1
        );
        //
        if(userDTO == null){
            throw new RuntimeException("用户不存在");
        }
        BigDecimal money = userDTO.getMoney().subtract(lesson.getPrice());
        if(money.doubleValue() < 0){
            throw new RuntimeException("用户余额不足");
        }
        //todo  扣费新增关系记录
        return lesson;
    }
}
