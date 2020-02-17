package com.xdx97.framework.controller;



import com.alipay.api.AlipayApiException;
import com.xdx97.framework.service.PayService;
import com.xdx97.framework.utils.pay.AlipayBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付宝沙箱测试
 *
 * @author 小道仙
 * @date 2020年2月17日
 */
@RestController
public class PayController {

    @Autowired
    private PayService payService;

    /**
     * 阿里支付
     * @param tradeNo
     * @param subject
     * @param amount
     * @param body
     * @return
     * @throws AlipayApiException
     */
    @PostMapping(value = "order/alipay")
    public String alipay(String outTradeNo, String subject, String totalAmount, String body) throws AlipayApiException {
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(outTradeNo);
        alipayBean.setSubject(subject);
        alipayBean.setTotal_amount(totalAmount);
        alipayBean.setBody(body);
        return payService.aliPay(alipayBean);
    }
}
