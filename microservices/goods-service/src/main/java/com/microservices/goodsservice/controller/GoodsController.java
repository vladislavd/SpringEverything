package com.microservices.goodsservice.controller;

import com.microservices.goodsservice.manager.GoodsManager;
import com.microservices.goodsservice.model.Goods;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/goods")
@RestController
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsManager goodsManager;

    @GetMapping
    public Goods getGoods(@RequestParam("id") Long id) {
       return goodsManager.getGoodsById(id);
    }
}
