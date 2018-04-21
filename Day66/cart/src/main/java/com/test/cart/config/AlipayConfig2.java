package com.test.cart.config;

public class AlipayConfig2 {
    // 商户appid
    public static String app_id = "2016073100131091";
    // 私钥 pkcs8格式的
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCdFH1Mk5a8zhwkdv1DkJXdOD3E33PTl+VDAABtWInHjiOdkg8hJMJOvTU2cGXlYxPwsbDunfawkrqvt/xzRSir8LXnIjBP6xDbgoqlZk/ufEb8J+8DLFw+TLVBPeKz6GdcSrmsx2YVjWTLGDPYdivCC8Ms6f8TZE8oYCmytu8/Ms6r6Vlv8acWB4bgO8EsC72VfzBwYUoIjL4IkRu1IkAdqzCeelMy6srFRXxDsI8cqRS2duq3EZBIal/nsoESJlsTYX5MPXRovgY+vdEVVpKgJoEOZ+3nuTbP7FK3MakAZ3O5ZejqW8rquT0pnXfuZRJQsjbpZuYKP8Up4cVuK7GNAgMBAAECggEAZ9Fp+xm0z/bdrNAkFerS0hJg6OTTFe9XrI+suJiC/6yXJ4aojzxPXGE7cU6aWiDAxh17Fkq7B/sCfi75IGp+Nh3y69+x1LBFRP+jiSv0+meTNwdhtlQ0Z0ylo4g2dLfO0LXmwCZN90Krcnv9kDySMT868U16tCNhGgtso9y6haaStvEZwCG9u80pJwpZXRIpZ8s0mQRpL9JAECXb9CRq7MCTPflO4Dg7VUNOEwS7bQSmxmQ+z+H2gjE2u2gGvy4vTWj76QJgZfLxgXi9/3Lo2iASEy3hhjEIi7iVLzoc37DVwIv2Bblek5Z6k0a6fUb/O5MpaUKA+3sSU8x9BBGutQKBgQDOk16oN/NByT3fcT0Swx3pR68oiUaRCqI21cefRhgGbYJmP446TnW1srI3uy+UW5HtyKJju50J2tQINcbVa1/OyJI3dVCg9pvWjbCfGjURL8/I9vmOVf/pc3yy2CLC2YVyPAC+1Hzob6MIXrcGFUhzL09Vao4UMu48E7GCyh4luwKBgQDCqYskrEefsH/LbOrbKlA2plsDPQDJmR8BYiPVp21JIuifowiyknDjgz5QBtFO57IDHO2rBBRYoo5aOIzgQ0WgSe7rAcvDDhDoeiyHPwcY25XnXyDBqosZDSlvg+dOWYjvxNDNqegmbLT4hBaevewK71MYRMehpMAlWNa+4bEtVwKBgFEIZh0+tWGc+3RnCzoM5/LWd9NC5jeHIFK6UXAdIteCpaBOVhBxLqNz0Y0jFGrx8LCB/5F3ywZOnNYLok+dqxuGejTfBB3gHwlu01XWBfMT+kIu/33iJl0BPG07c4dTpJFHEFPLLqRPBnkGDm2Ic78bU9eB0PIDeIiAgSV4+5J5AoGAaWuwMzgpwc2wJ9bgibisoCwPdf1/g64tIG6pwXdetBD3shx1BWBRSqU1BdnrWLQZr53nCIq5ChdeyHV/taQ4/MmNXjAmzYe8mGox2zzC9y9US201LCzUD8kU+5OPnNrYUiFgg0DUvJp6l2vRZD6uqm1ZrvbwthWnCZLHGbDYZxkCgYAW73Ib3y0mtiV3w4oEYDUrjCWtNyl0SXA86zr3CKPKJ5zCzkt4MgHjnJP989HuV5uDIrxmPB3bRbuHpqiG2JQRPY3cnFQAVVsu1dyk8gCIlpCf2syrILu2u2B1wazPshuZNBUwbiBGy6ufKhwsH1M727MNksqo5I3fFQEMcdmaqg==";
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi6B3ValT/3BdVAAMJGBrwq07jcNoHmb8gxKfapHA8jYNMfuJuhg7b+qTV7M4s4VVKRUg0JC8EE03ZSVQrDBiJDk9OMP6l7DHf/bQH2MZaoD6LNz+uUKEmSQwOw0XY1jja5OCSlm16N1SohfRM4Ul5jhJL0EGxKJSw8xPl45eYMYRoWi3upou048Z2wtf2Sn+nOqxBwOv1PMjmpzNVtANOTengaygBA6JK4vNwkftcnxg0SLdZVz8bEmtIsR1nVcuivWTIEcanNv2dIrjQAebqQ7WJZV/krrs8ugqJl03GpyylhoENII9mEliU1qOmNB84Oap3CZrwQS+0ZzdZZT8cQIDAQAB" ;
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/notify_url.jsp";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://localhost:8082/order/payback";
    // 请求网关地址
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    public static String charset = "UTF-8";
    // 返回格式
    public static String format = "json";
    // 日志记录目录
    public static String log_path = "/log";
    // RSA2
    public static String sign_type = "RSA2";
}
