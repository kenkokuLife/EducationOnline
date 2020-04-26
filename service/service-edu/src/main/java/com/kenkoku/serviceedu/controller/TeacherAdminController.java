package com.kenkoku.serviceedu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kenkoku.commonutils.R;
import com.kenkoku.serviceedu.entity.vo.TeacherQuery;
import com.kenkoku.serviceedu.entity.EduTeacher;
import com.kenkoku.serviceedu.service.EduTeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherAdminController {
    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation(value = "ページング講師リスト")
    @GetMapping("{page}/{limit}")
    public R pageList(
        @ApiParam(name = "page", value = "現ページ", required = true)
        @PathVariable Long page,

        @ApiParam(name = "limit", value = "ページのレコード表示数", required = true)
        @PathVariable Long limit,

        @ApiParam(name = "teacherQuery", value = "条件付きサーチ", required = false)
                TeacherQuery teacherQuery){

        Page<EduTeacher> pageParam = new Page<>(page, limit);

        //クエリ検索
        teacherService.pageQuery(pageParam, teacherQuery);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return R.ok().data("total", total).data("rows", records);
    }
}
