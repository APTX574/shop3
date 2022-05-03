package com.community.controller;

import com.alibaba.fastjson.JSONObject;
import com.community.entity.Goods;
import com.community.service.GoodsService;
import com.community.util.CommunityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/getGoods", method = RequestMethod.GET)
    @ResponseBody
    public String getGoods() {
        Map<String, Object> map = new HashMap<>();
        map.put("goods", goodsService.getGoods());
        return CommunityUtil.getJsonString(200, "success", map);

    }

    @ResponseBody
    @RequestMapping(value = "/addgoods", method = RequestMethod.POST)
    public String addGoods(@RequestBody String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        Goods goods = new Goods();
        goods.setContent(jsonObject.getString("content"));
        goods.setTitle(jsonObject.getString("title"));
        goods.setPrice(jsonObject.getDouble("price"));
        goods.setStatus(0);
        goods.setCreateTime(new Date());
        goodsService.addGoods(goods);
        return CommunityUtil.getJsonString(200, "success");
    }

    @ResponseBody
    @RequestMapping(value = "/getgoodsbyid", method = RequestMethod.GET)
    public String getUserByname(int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("goods", goodsService.getGoodsById(id));
        return CommunityUtil.getJsonString(200, "success", map);
    }

    @ResponseBody
    @RequestMapping(value = "/getgoodsbytitle", method = RequestMethod.GET)
    public String getUserBytitle(String title) {
        Map<String, Object> map = new HashMap<>();
        map.put("goods", goodsService.getGoodesByTitle(title));
        return CommunityUtil.getJsonString(200, "success", map);
    }


}
