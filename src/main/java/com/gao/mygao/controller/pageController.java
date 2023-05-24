package com.gao.mygao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: pageController
 * Package: com.gao.mygao.controller
 * Description:
 * Author: my
 * Creat: 2023/4/22 20:21
 * @author 11
 */
//@Controller
//@RequestMapping("/toPage")
public class pageController {
//    @RequestMapping("/{page}")
    public String toLogin(@PathVariable String page){
        return page;
    }
}
