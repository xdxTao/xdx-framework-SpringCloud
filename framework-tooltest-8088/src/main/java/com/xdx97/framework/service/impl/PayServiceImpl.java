package com.xdx97.framework.service.impl;


import com.xdx97.framework.service.PayService;
import com.xdx97.framework.utils.pay.Alipay;
import com.xdx97.framework.utils.pay.AlipayBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private Alipay alipay;

    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }

}
