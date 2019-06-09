package com.week.controller;

import com.week.pojo.EUDataGridResult;
import com.week.pojo.TaotaoResult;
import com.week.pojo.TbItem;
import com.week.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author week
 * @Title: ItemController
 * @ProjectName taotaoJar
 * @Description: 商品管理controller
 * @date 2019/5/1816:56
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        TbItem tbItem=itemService.getItemByID(itemId);
        System.out.println("进来了");
        return tbItem;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page,Integer rows){
        EUDataGridResult result=itemService.getItemList(page,rows);
        return result;
    }
    @RequestMapping(value="/item/save", method= RequestMethod.POST)
    @ResponseBody
    private TaotaoResult createItem(TbItem item, String desc, String itemParams) throws Exception {
        TaotaoResult result = itemService.createItem(item, desc, itemParams);
        return result;
    }
}
