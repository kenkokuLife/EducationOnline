package com.kenkoku.serviceedu.controller;


import com.kenkoku.commonutils.R;
import com.kenkoku.serviceedu.entity.EduTeacher;
import com.kenkoku.serviceedu.service.EduTeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
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
@CrossOrigin //跨域
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation(value = "講師全員リスト")
    @GetMapping
    public R list() {
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("items", list);
    }

    @ApiOperation(value = "IDで講師を削除")
    @DeleteMapping("/delete/{id}")
    public R removeById(
            @ApiParam(name = "id", value = "講師ID", required = true)
            @PathVariable String id
            ){
        teacherService.removeById(id);
        return R.ok();
    }

    @ApiOperation(value = "IDで講師を検索")
    @GetMapping("/search/{id}")
    public R getById(
            @ApiParam(name = "id", value = "講師ID", required = true)
            @PathVariable String id){

        EduTeacher teacher = teacherService.getById(id);
        return R.ok().data("item", teacher);
    }

    @ApiOperation(value = "IDで講師を更新")
    @GetMapping("/update/{id}")
    public R updateById(
            @ApiParam(name = "id", value = "講師ID", required = true)
            @PathVariable String id,

            @ApiParam(name = "teacher", value = "ターゲット講師", required = true)
            @RequestBody EduTeacher teacher){

        teacher.setId(id);
        teacherService.updateById(teacher);
        return R.ok();
    }

    @ApiParam(value = "新規講師")
    @PostMapping("/add")
    public R save(
            @ApiParam(name = "teacher", value = "ターゲット講師", required = true)
            @RequestBody EduTeacher teacher){

        teacherService.save(teacher);
        return R.ok();
    }

    @PostConstruct
    public void testInsert() {
        EduTeacher eduTeacher = new EduTeacher();
        eduTeacher.setName("Jerry");
        eduTeacher.setIntro("賢い");

        teacherService.save(eduTeacher);
    }
}

