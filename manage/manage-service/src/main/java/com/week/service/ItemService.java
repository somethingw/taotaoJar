package com.week.service;

import com.week.pojo.EUDataGridResult;
import com.week.pojo.TaotaoResult;
import com.week.pojo.TbItem;

/**
 * @author week
 * @Title: ItemService
 * @ProjectName taotaoJar
 * @Description: TODO
 * @date 2019/5/1816:43
 */
public interface ItemService {
    TbItem getItemByID(long itemId);
    EUDataGridResult getItemList(int page,int rows);
    TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception;
}
