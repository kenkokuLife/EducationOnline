package com.kenkoku.serviceedu.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "Teacherサーチ対象", description = "講師検索対象パッケージ化")
@Data
public class TeacherQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "教師氏名、曖昧検索")
    private String name;

    @ApiModelProperty(value = "肩書き　１高級講師　２チーフ講師")
    private Integer level;

    @ApiModelProperty(value = "サーチ開始時間", example = "2019-01-01 10:10:10")
    private String begin;//注意：String型のまま受け取る、データ変換は行わない

    @ApiModelProperty(value = "サーチ終了時間", example = "2019-01-01 10:10:10")
    private String end;//注意：String型のまま受け取る、データ変換は行わない
}
