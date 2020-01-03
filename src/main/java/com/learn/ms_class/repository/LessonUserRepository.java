package com.learn.ms_class.repository;

import com.learn.ms_class.domain.entity.LessonUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonUserRepository extends CrudRepository<LessonUser, Integer> {
    LessonUser findByLessonId(Integer id);
}
