package com.learn.ms_class.controller;

import com.learn.ms_class.domain.entity.Lesson;
import com.learn.ms_class.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LessonController
 * @Description LessonController
 * @Author ZhouXiaoPing
 * @Date 2020/1/3 16:52
 **/
@RestController
@RequestMapping("/lesson")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @GetMapping("/buyLessonById/{id}")
    public Lesson bugLessonById(@PathVariable Integer id){
        return lessonService.buyLessonById(id);
    }
}
