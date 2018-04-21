package com.test.cart.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.test.cart.config.AlipayConfig2;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public String pay(String json) {
    //获得初始化的AlipayClinet
        AlipayClient client = new DefaultAlipayClient(
                AlipayConfig2.gatewayUrl,
                AlipayConfig2.app_id,
                AlipayConfig2.merchant_private_key,
                "json", AlipayConfig2.charset,
                AlipayConfig2.alipay_public_key,
                AlipayConfig2.sign_type);
        //设置请求参数
        //serverUrl, appId, privateKey, format, charset, alipayPublicKey
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig2.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig2.notify_url);
//请求
        try {
            alipayRequest.setBizContent(json);
            String result = client.pageExecute(alipayRequest).getBody();
            return result;
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }
}
