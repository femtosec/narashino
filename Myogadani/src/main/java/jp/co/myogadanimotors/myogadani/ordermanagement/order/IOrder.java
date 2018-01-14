package jp.co.myogadanimotors.myogadani.ordermanagement.order;

import jp.co.myogadanimotors.myogadani.common.OrderSide;

import java.math.BigDecimal;

public interface IOrder {
    long getOrderId();
    OrderState getOrderState();
    int getVersion();
    long getAccountId();
    String getSymbol();
    String getMic();
    OrderSide getOrderSide();
    BigDecimal getOrderQuantity();
    BigDecimal getExecQuantity();
    BigDecimal getCancelledQuantity();
    BigDecimal getExpiredQuantity();
    BigDecimal getRejectedQuantity();
    BigDecimal getExposedQuantity();
    BigDecimal getRemainingQuantity();
    BigDecimal getAvailableQuantity();
    BigDecimal getPriceLimit();
}