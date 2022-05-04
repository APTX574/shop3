package com.community.service;

import com.community.dao.GoodsMapper;
import com.community.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GoodsService {
	@Autowired
	GoodsMapper goodsMapper;

	public int addGoods(Goods goods) {
		return goodsMapper.insertGoods(goods);
	}

	public Goods getGoodsById(int id) {
		return goodsMapper.getGoodsByid(id);
	}

	public Goods getGoodesByTitle(String title) {
		return goodsMapper.getGoodsBytitle(title);
	}

	public List<Goods> getGoods() {
		return goodsMapper.getGoods();
	}
}
