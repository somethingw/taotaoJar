package com.week.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author week
 * @Title: PageController
 * @ProjectName taotaoJar
 * @Description: TODO
 * @date 2019/5/2119:55
 */
@Controller
public class PageController {
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/{page}")
    public String showpage(@PathVariable String page){
        return page;
    }
}
