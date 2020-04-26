package com.kenkoku.serviceedu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kenkoku.serviceedu.entity.vo.TeacherQuery;
import com.kenkoku.serviceedu.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author jojo
 * @since 2020-04-08
 */
public interface EduTeacherService extends IService<EduTeacher> {

    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);
}
