package com.alipay.config;

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000119646955";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCO4MmOM+a553Xgcamx9Hs91y6qTpVVTsAF8PdsTApB5jgUI9yUt4IixBh4b3v8w9tXtc1U1HE0BVXpv7hPUhTsBATJ53YWzC4C998Xv/guxDmp8HelzayUTpb51ODmq5a0VmArBVW5Uepn4+yrwC6AKsScwZwtmRCTvFWdW4+MS1nRQ9/HQdjPQmWONWlVCgQF8xFFFkUOnr4ZBIkFVk7gk7sF1ciz0mGSNsaOKTlb4sCSKrUtyfpBTun+OtYGbxz0tGBvJPHMSBpUbYmIWKnSLsSr/2psjMYpcnZ5wDK7pw86zNdFRI5tZfDV5OvaNrpUbAZDLS5s+iSYFt5C2vs5AgMBAAECggEAQ93un4dzvzZ8vYIAEzGIINXHqsntETp459mQDXcJIEhUtuxZ6KJKRG1VGlAKWwRFeiI3SGYo54bpSkDxMWxR19II3Eb/xtBxwqMu6z8aikxW/6vjiXRq13+FI2LE+Yzj5wFoaMb98ys/5t1THDoLXIH0Jmmo39fnEeXR3Q8S3pZrjCIAQBERbzhILA3EP2anivcW1ZuF7RjUuWU2OTKmuvVRumaOFZG3DET7eIQtfrUBz/lixBYM7dYM7AaCvnaV+ZtgirSsaTcpBXJ2fYY6b9FtORUX+zGnhlB1z+IU1Zl91pqD8Ufw7+WGgpBGdhA1ddP0A5Lii/IYw1nEisk8oQKBgQDk/6HlsU1bSXnBJHAAvz2+oLVgZOMS35kIKqHdf8prd7tuZrVsm2/N9Ap1WoFUxHzBHIud00GN8YIT6YYvbAKhNPMOcty7hyhnCbWRtZDvKucQalZp4xHV3CkRIFD91fffEPSA1Bz1WN1x/+ze756YrSfIMTV3sVmmMTltXVAtVQKBgQCfuZc3oWZPCmIQ+mQ4RS7Y+pvedimHaGI+bJ4t0At8Z3q5zNSqezvv62A1ydqqS59LpqxoRyr6e1xQpPwbfDML24HAMntesrLE1gOLEyo3CvvfybVckq1cGMmZttrpxOs9x+pxBbTT8ieigku5pEK94nb3f9PGmPvigPZXxvw2VQKBgQCQ73aBUPl76IImCzDUWDX1G/QQAWpyvJA3yfvOnB36bLp1Qo5bIfneaTHhWpn2k7G965o2Fsor04oXnjqucvcrHr8jCvHHwuCAbnW7tiX4Kbg6/IKa2/ui1ogrbb+1GKKcTTfi/d0iL89gYrGB3DkNurIuE28axWXPOOJ25JNlTQKBgD6Orc84A54Jbwc/SmlPj12kKdAjb3h9RZ01ZW6EATukO8jxlImA4qTBB1mJyX7RR36VtQjSdt7L2ggr1iHdrxCB1Hu2SeN5EdNODu01gF82ihfIJKQxPnzHqI3vtCXC3m/AEO5bUcuBGEzpw0beMtW0EOw2wHcUC/NWlyUh5j5RAoGAYClB3eK0fAY3p2Jl8NO68AhGhJhoE/XaH5qs4+8TLTGnlF7GHxYQZu7o8wbhw/N90/yx3eUIjUrl9B3OVpfOR2JXya5sp9Xhu03KPQEQ84wXskPLUvWSQo0gziqPd/J7t803vUBI+GMnRbbizbXvKD0x/yg60TOOv/o5r98rr4s=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjnFHh5tICkFhomP/Q/zZnCnYaGu3rs/oO3/MsqG8VnhJMieocGId0Km3n1SHkpYgUG5JtVJPhKoQwRT9RSlFSYt5zZbZBIqtPB01LE8SP1sRi7LkVFLarP0dOMBsBoQHwjGbv25ctlIpFWfaz4A6WFIFpP+XTnZO4YasAjdzuw0reHhid2Og3ED8QtkxTXG658vGh9Ys65f+SKf/HF6rOOFgRFHAHT/2/ojgPmSYO0WjNy0Qkl2XQQOkulzxfJJOCH+KgSqbqNmqwlktn06AT6TkpizTyEYlRIeaa8xL9SrkLP/iFPq+DfuY8x85r8+vEMK1wTA5lcv6GPJ9kFaNHQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://mehbjv.natappfree.cc/bookstoe/alipay/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://mehbjv.natappfree.cc/bookstore/alipay/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

}
