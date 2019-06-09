package com.week.service;

import com.week.pojo.EUTreeNode;

import java.util.List;



public interface ItemCatService {

	List<EUTreeNode> getCatList(long parentId);
}
