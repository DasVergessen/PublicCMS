package com.publiccms.common.api;

import java.util.function.Supplier;

import javax.servlet.http.HttpServletResponse;

import com.publiccms.entities.sys.SysSite;
import com.publiccms.entities.trade.TradeOrder;
import com.publiccms.entities.trade.TradeRefund;

public interface PaymentGateway extends Container<String> {
    String getAccountType();

    default Supplier<String> keyFunction() {
        return () -> getAccountType();
    }

    boolean enable(short siteId);

    boolean pay(SysSite site, TradeOrder order, String callbackUrl, HttpServletResponse response);

    boolean refund(SysSite site, TradeOrder order, TradeRefund refund);
}
