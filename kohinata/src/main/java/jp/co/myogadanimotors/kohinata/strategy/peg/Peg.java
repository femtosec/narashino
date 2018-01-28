package jp.co.myogadanimotors.kohinata.strategy.peg;

import jp.co.myogadanimotors.myogadani.master.strategy.IStrategyDescriptor;
import jp.co.myogadanimotors.myogadani.strategy.AbstractStrategy;
import jp.co.myogadanimotors.myogadani.strategy.IStrategyParameters;
import jp.co.myogadanimotors.myogadani.strategy.context.StrategyContext;

public class Peg extends AbstractStrategy {

    public Peg(IStrategyDescriptor strategyDescriptor, StrategyContext context, IStrategyParameters strategyParameters) {
        super(strategyDescriptor, context, strategyParameters);
    }

    @Override
    protected void doAction() {
        // todo: to be implemented
    }
}
