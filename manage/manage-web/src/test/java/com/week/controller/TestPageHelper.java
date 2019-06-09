package com.week.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.week.mapper.TbItemMapper;
import com.week.pojo.TbItem;
import com.week.pojo.TbItemExample;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author week
 * @Title: TestPageHelper
 * @ProjectName taotaoJar
 * @Description: TODO
 * @date 2019/5/2120:28
 */


public class TestPageHelper {
    @Test
    public void testPageHelper(){
        //创建一个spring容器
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        //从spring容器总后的Mapper的代理对象
        TbItemMapper mapper= applicationContext.getBean(TbItemMapper.class);
        //执行查询，分页
        PageHelper.startPage(1,10);
        TbItemExample example=new TbItemExample();
        List<TbItem> list= mapper.selectByExample(example);
        for(TbItem tbItem:list){
            System.out.println(tbItem.getTitle());
        }
        PageInfo<TbItem> pageInfo=new PageInfo<>(list);
        long total=pageInfo.getTotal();
        System.out.println("一共有"+total);

    }
}
