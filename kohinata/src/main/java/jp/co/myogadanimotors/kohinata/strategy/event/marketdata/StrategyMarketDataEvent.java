package jp.co.myogadanimotors.kohinata.strategy.event.marketdata;

import jp.co.myogadanimotors.kohinata.event.marketdata.DepthEntry;
import jp.co.myogadanimotors.kohinata.strategy.event.BaseStrategyEvent;
import jp.co.myogadanimotors.kohinata.strategy.event.IStrategyEventListener;
import jp.co.myogadanimotors.kohinata.strategy.event.StrategyEventType;

import java.math.BigDecimal;

public final class StrategyMarketDataEvent extends BaseStrategyEvent {

    private final long productId;
    private final String symbol;
    private final String mic;
    private final BigDecimal lastPrice;
    private final BigDecimal lastTradeVolume;
    private final DepthEntry[] bidDepth;
    private final DepthEntry[] offerDepth;

    public StrategyMarketDataEvent(long eventId,
                                   long creationTime,
                                   IStrategyEventListener eventListener,
                                   long productId,
                                   String symbol,
                                   String mic,
                                   BigDecimal lastPrice,
                                   BigDecimal lastTradeVolume,
                                   DepthEntry[] bidDepth,
                                   DepthEntry[] offerDepth) {
        super(eventId, creationTime, eventListener);
        this.productId = productId;
        this.symbol = symbol;
        this.mic = mic;
        this.lastPrice = lastPrice;
        this.lastTradeVolume = lastTradeVolume;
        this.bidDepth = bidDepth;
        this.offerDepth = offerDepth;
    }

    @Override
    public StrategyEventType getStrategyEventType() {
        return StrategyEventType.MarketData;
    }

    public long getProductId() {
        return productId;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getMic() {
        return mic;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public BigDecimal getLastTradeVolume() {
        return lastTradeVolume;
    }

    public DepthEntry[] getBidDepth() {
        return bidDepth;
    }

    public DepthEntry[] getOfferDepth() {
        return offerDepth;
    }

    @Override
    protected void callStrategyEventListener(IStrategyEventListener strategyEventListener) {
        strategyEventListener.processStrategyMarketDataEvent(this);
    }

    @Override
    public StringBuilder toStringBuilder() {
        StringBuilder sb = super.toStringBuilder()
                .append(", productId: ").append(productId)
                .append(", symbol: ").append(symbol)
                .append(", mic: ").append(mic)
                .append(", lastPrice: ").append(lastPrice)
                .append(", lastTradeVolume: ").append(lastTradeVolume)
                .append(", offer: ");

        for (DepthEntry depthEntry : offerDepth) {
            sb.append(depthEntry.toString());
        }

        sb.append(", bid: ");

        for (DepthEntry depthEntry : bidDepth) {
            sb.append(depthEntry.toString());
        }

        return sb;
    }
}
