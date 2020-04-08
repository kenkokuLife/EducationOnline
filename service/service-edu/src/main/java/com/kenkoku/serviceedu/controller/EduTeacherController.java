package com.kenkoku.serviceedu.controller;


import com.kenkoku.serviceedu.entity.EduTeacher;
import com.kenkoku.serviceedu.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author jojo
 * @since 2020-04-08
 */
@RestController
@RequestMapping("/serviceedu/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @GetMapping
    public List<EduTeacher> findAllTeacher() {
        return teacherService.list(null);
    }
}

