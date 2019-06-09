package com.week.controller;

import com.week.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author week
 * @Title: ItemParamItemController
 * @ProjectName taotaoJar
 * @Description: 展示商品规格参数
 * @date 2019/6/717:23
 */
@Controller
public class ItemParamItemController {
    @Autowired
    private ItemParamItemService itemParamItemService;

    @RequestMapping("/showitem/{itemId}")
    public String showItemParam(@PathVariable Long itemId, Model model) {
        String string = itemParamItemService.getItemParamByItemId(itemId);
        model.addAttribute("itemParam", string);
        return "item";
    }
}
