package com.kenkoku.eduservice;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class AutoCodeGenerator {
    @Test
    public void generateBase() {

        //1.コード生成ツールを初期化
        AutoGenerator mpg = new AutoGenerator();

        //2.グローバル設定
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("jojo");
        gc.setOpen(false);//自動生成後エクスプローラーを開くかどうか
        gc.setFileOverride(false);//再度生成後に上書きするかどうか
        /*
        mpがservice層のコードを生成する。デフォルトのインタフェースに頭文字がI
        UcenterService
         */
        gc.setServiceName("%sService");//serviceインタフェースの頭文字Iを削除
        gc.setIdType((IdType.ID_WORKER));//主キー生成ルール
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);//Swagger2モードを有効

        mpg.setGlobalConfig(gc);

        //3.ソース元を配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/guli?serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("test");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //4.パッケージ設定
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("serviceedu");
        pc.setParent("com.kenkoku");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        //5.生成ルール設定
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("edu_teacher");
        strategy.setNaming(NamingStrategy.underline_to_camel);//テーブルから反映される実体のネーミングルール
        strategy.setTablePrefix(pc.getModuleName() + "_");//実体を生成時に前のジャンル名を除去

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//カラム名から反映される実体のネーミングルール
        strategy.setEntityLombokModel(true);//lombok モデル @Accessors(chain = true) setterリンク操作

        strategy.setRestControllerStyle(true);//restful api スタイルコントローラ
        strategy.setControllerMappingHyphenStyle(true);//urlにキャメルエスケープ

        mpg.setStrategy(strategy);

        //6.実行
        mpg.execute();
    }
}
