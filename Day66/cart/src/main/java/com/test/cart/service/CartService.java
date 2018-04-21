package com.test.cart.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.test.cart.entity.Commodity;
import com.test.cart.util.Base64Util;
import com.test.cart.util.HttpUtil;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class CartService {

    public void add(String sku, Model model, String cookie, HttpServletResponse response) {
        //购物车
        Map<String,Commodity> car = null;
        if (StringUtils.isEmpty(cookie)){
            car = new HashMap<>();

        }else {
            car = getCart(cookie);
        }
        //购物车中有sku对应的商品
        if (car.containsKey(sku)){
            Commodity commodity = car.get(sku);
            //将商品数量加1
            commodity.setNum(commodity.getNum()+1);
        }else {
            //第一次购买
            String path = "http://localhost:8083/commodity/findCommBySku/"+sku;
                String json = HttpUtil.getJSON(path);
            // /将json转化为对象
            Commodity commodity = JSON.parseObject(json,Commodity.class);

            commodity.setNum(1);
            car.put(commodity.getSku(),commodity);

        }
        //把购物车送到购物车页面
        model.addAttribute("car",car.values());
        model.addAttribute("total",total(car));
        addCookie(car,response);
    }

    //总价款
    public float total(Map<String,Commodity> cart){
        float x= 0;
        Collection<Commodity> cs = cart.values();
        for (Commodity m:cs){
            x+=m.getPrice()*m.getNum();
        }
        return x;
    }



    public void lookcart(String cookie, Model model) {
        if (cookie !=null){
            Map<String, Commodity> cart1 = getCart(cookie);
            System.out.println("!!!!!!!!");
            model.addAttribute("car",cart1.values());
            model.addAttribute("total",total(cart1));
        }else {
            model.addAttribute("car",null);
            model.addAttribute("total",0);
        }

    }

    public Map<String,Commodity> getCart(String cookie) {
        String json= Base64Util.decode(cookie);
        return JSON.parseObject(json,new TypeReference<Map<String,Commodity>>(){});
    }
    public void addCookie(Map<String, Commodity> car,HttpServletResponse res) {
        String carjson = JSON.toJSONString(car);
        //创建cookie
        Cookie ck=new Cookie("cart", Base64Util.encode(carjson));
        ck.setMaxAge(60*60*24);
        ck.setPath("/");
        res.addCookie(ck);
    }

    public float update(String cookie, String sku, int num, HttpServletResponse response) {
        //从cookie中获取cart
        Map<String,Commodity> car = getCart(cookie);
        //从购物车中获取商品
        Commodity commodity = car.get(sku);
        //修改商品数量
        commodity.setNum(num);
        //更新cookie
        addCookie(car,response);
        return total(car);
    }

    public void delete(String sku, String cookie, Model model, HttpServletResponse response) {

        Map<String,Commodity> car = getCart(cookie);
        car.remove(sku);
        addCookie(car,response);
        model.addAttribute("car",car.values());
        model.addAttribute("total",total(car));
    }

    public void toOrder(String cookie, Model model) {
        Map<String, Commodity> cart1 = getCart(cookie);
        model.addAttribute("cs",cart1.values());
        model.addAttribute("total",total(cart1));
    }
}
