package com.test.cart.controller;

import com.test.cart.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("cart")
public class CartController {
    @Resource
    private CartService cartService;
    @RequestMapping("add/{sku}")
    public String add(@PathVariable String sku, Model model, @CookieValue(required = false) String cart, HttpServletResponse response){
        cartService.add(sku,model,cart,response);
        return "cart";
    }
    @RequestMapping("update/{sku}/{num}")
    @ResponseBody
    public float update(@CookieValue String cart,@PathVariable String sku,@PathVariable int num,HttpServletResponse response ){
         return cartService.update(cart,sku,num,response);
    }
    @RequestMapping("delete/{sku}")
    public String delete(@PathVariable String sku,@CookieValue String  cart,Model model,HttpServletResponse response){

       cartService.delete(sku,cart,model,response);
       return "cart";
    }


//查看购物车
    @RequestMapping("lookcart")
  public  String lookcart(@CookieValue(required = false) String cart,Model model){
     cartService.lookcart(cart,model);
     return "cart";
  }
  @RequestMapping("toOrder")
  public String toOrder(@CookieValue(required = false) String cart,Model model){
        cartService.toOrder(cart,model);
        return "order";
  }

}
