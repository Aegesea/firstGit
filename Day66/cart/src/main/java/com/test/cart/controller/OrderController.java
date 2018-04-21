package com.test.cart.controller;

import com.alibaba.fastjson.JSON;
import com.test.cart.entity.Commodity;
import com.test.cart.service.CartService;
import com.test.cart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;
    @Resource
    private JmsTemplate jmsTemplate;
    @RequestMapping("saveOrder")
    @ResponseBody
    public String saveOrder(@CookieValue(required =false) String cart){
        //订单编号
        String orderNo = UUID.randomUUID().toString().replaceAll("-","");
        Map<String,Commodity> map = cartService.getCart(cart);
        //订单金额
        float total = cartService.total(map);
        Map<String,Object> data = new HashMap<>();
        data.put("out_trade_no",orderNo);
        data.put("total_amount",total);
        data.put("subject","你的订单");
        data.put("body","body");
        data.put("product_code","FAST_INSTANT_TRADE_PAY");

        String json = JSON.toJSONString(data);

        data.put("detail",map.values());
        String json1 = JSON.toJSONString(data);
        //发送消息
        jmsTemplate.convertAndSend("mall_order",json1);
        String result = orderService.pay(json);
        return result;

    }
    @RequestMapping("payback")
    public String payback(){
        return "payend";
    }
}
