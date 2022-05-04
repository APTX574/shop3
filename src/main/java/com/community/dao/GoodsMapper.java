package com.community.dao;

import com.community.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;
/**
 * @author aptx
 */
@Mapper
public interface GoodsMapper {
	Goods getGoodsByid(int id);


	Goods getGoodsBytitle(String title);

	int insertGoods(Goods goods);

	List<Goods> getGoods();
}
