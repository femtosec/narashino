package jp.co.myogadanimotors.myogadani.strategy;

import jp.co.myogadanimotors.bunkyo.config.IConfigAccessor;
import jp.co.myogadanimotors.kohinata.master.strategy.IStrategyDescriptor;
import jp.co.myogadanimotors.kohinata.strategy.IStrategy;
import jp.co.myogadanimotors.kohinata.strategy.IStrategyFactory;
import jp.co.myogadanimotors.kohinata.strategy.context.StrategyContext;
import jp.co.myogadanimotors.myogadani.strategy.parameter.BaseStrategyParameters;
import jp.co.myogadanimotors.myogadani.strategy.peg.Peg;

public class StrategyFactory implements IStrategyFactory {

    private final IConfigAccessor strategyConfigAccessor;

    public StrategyFactory(IConfigAccessor strategyConfigAccessor) {
        this.strategyConfigAccessor = strategyConfigAccessor;
    }

    @Override
    public IStrategy create(IStrategyDescriptor strategyDescriptor, StrategyContext context) {
        switch (strategyDescriptor.getName()) {
            case "Peg":     // test
                return new Peg(strategyDescriptor, context, new BaseStrategyParameters(strategyDescriptor.getName(), strategyConfigAccessor));
        }

        return null;
    }
}