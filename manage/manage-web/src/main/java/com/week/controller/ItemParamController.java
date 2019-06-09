package com.week.controller;

import com.week.pojo.EUDataGridResult;
import com.week.pojo.TaotaoResult;
import com.week.pojo.TbItemParam;
import com.week.service.ItemParamService;
import com.week.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author week
 * @Title: ItemParamController
 * @ProjectName taotaoJar
 * @Description: 商品规格参数模板管理
 * @date 2019/6/715:35
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/query/itemcatid/{itemCatId}")
    @ResponseBody
    public TaotaoResult getItemParamByid(@PathVariable Long itemCatId){
        TaotaoResult result=itemParamService.getItemParamByCid(itemCatId);
        return  result;
    }

    @RequestMapping("/save/{cid}")
    @ResponseBody
    public  TaotaoResult insertItemParam(@PathVariable Long cid,String paramData){
        TbItemParam itemParam=new TbItemParam();
        itemParam.setItemCatId(cid);
        itemParam.setParamData(paramData);
        TaotaoResult result=itemParamService.insertItemParam(itemParam);
        return  result;
    }
    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemParamList(Integer page,Integer rows){
        EUDataGridResult result=itemParamService.getItemList(page,rows);
        System.out.println(page+"-"+rows);
        System.out.println(JsonUtils.objectToJson(result));
        return result;
    }

}
