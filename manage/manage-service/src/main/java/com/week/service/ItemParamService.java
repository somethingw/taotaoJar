package com.week.service;


import com.week.pojo.EUDataGridResult;
import com.week.pojo.TaotaoResult;
import com.week.pojo.TbItemParam;

public interface ItemParamService {

	TaotaoResult getItemParamByCid(long cid);
	EUDataGridResult getItemList(int page, int rows);
	TaotaoResult insertItemParam(TbItemParam itemParam);
}
