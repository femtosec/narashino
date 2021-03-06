package jp.co.myogadanimotors.kohinata.event.order;

import jp.co.myogadanimotors.bunkyo.eventprocessing.BaseEvent;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

public final class NewOrder extends BaseEvent<IAsyncOrderListener> {

    private final long requestId;
    private final long parentOrderId;
    private final long accountId;
    private final String symbol;
    private final String mic;
    private final OrderSide orderSide;
    private final BigDecimal orderQuantity;
    private final BigDecimal priceLimit;
    private final Orderer orderer;
    private final OrderDestination destination;
    private final Map<String, String> extendedAttributes = new ConcurrentHashMap<>();

    public NewOrder(long eventId,
                    long creationTime,
                    IAsyncOrderListener eventListener,
                    long requestId,
                    long parentOrderId,
                    long accountId,
                    String symbol,
                    String mic,
                    OrderSide orderSide,
                    BigDecimal orderQuantity,
                    BigDecimal priceLimit,
                    Orderer orderer,
                    OrderDestination destination,
                    Map<String, String> extendedAttributes) {
        super(eventId, creationTime, eventListener);
        this.requestId = requestId;
        this.parentOrderId = parentOrderId;
        this.accountId = accountId;
        this.symbol = requireNonNull(symbol);
        this.mic = requireNonNull(mic);
        this.orderSide = requireNonNull(orderSide);
        this.orderQuantity = orderQuantity;
        this.priceLimit = priceLimit;
        this.orderer = requireNonNull(orderer);
        this.destination = requireNonNull(destination);
        if (extendedAttributes != null) {
            this.extendedAttributes.putAll(extendedAttributes);
        }
    }

    public long getRequestId() {
        return requestId;
    }

    public long getParentOrderId() {
        return parentOrderId;
    }

    public long getAccountId() {
        return accountId;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getMic() {
        return mic;
    }

    public OrderSide getOrderSide() {
        return orderSide;
    }

    public BigDecimal getOrderQuantity() {
        return orderQuantity;
    }

    public BigDecimal getPriceLimit() {
        return priceLimit;
    }

    public Orderer getOrderer() {
        return orderer;
    }

    public OrderDestination getDestination() {
        return destination;
    }

    public Map<String, String> getExtendedAttributes() {
        return new ConcurrentHashMap<>(extendedAttributes);
    }

    public String getExtendedAttribute(String key) {
        return extendedAttributes.get(key);
    }

    @Override
    protected void callEventListener(IAsyncOrderListener eventListener) {
        eventListener.processNewOrder(this);
    }

    @Override
    public StringBuilder toStringBuilder() {
        StringBuilder sb = super.toStringBuilder()
                .append(", requestId: ").append(requestId)
                .append(", parentOrderId: ").append(parentOrderId)
                .append(", accountId: ").append(accountId)
                .append(", symbol: ").append(symbol)
                .append(", mic: ").append(mic)
                .append(", orderSide: ").append(orderSide)
                .append(", orderQuantity: ").append(orderQuantity)
                .append(", priceLimit: ").append(priceLimit)
                .append(", orderer: ").append(orderer)
                .append(", destination: ").append(destination);

        if (extendedAttributes != null) {
            for (Map.Entry<String, String> entry : extendedAttributes.entrySet()) {
                sb.append(", [").append(entry.getKey()).append(":").append(entry.getValue()).append("]");
            }
        }

        return sb;
    }
}
