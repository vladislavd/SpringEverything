package com.microservices.goodsservice.manager;

import com.microservices.goodsservice.model.Goods;
import org.springframework.stereotype.Component;

@Component
public class GoodsManager {

    public Goods getGoodsById(Long id) {
       Goods goods = new Goods();
       goods.setId(id);
       goods.setName("Goods1");
       return goods;
    }

}
