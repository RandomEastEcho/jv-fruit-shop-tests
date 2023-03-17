package core.basesyntax.strategy.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.FruitShopException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handlers.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void initializeOperation(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getFruit() == null) {
            throw new FruitShopException("Invalid input data");
        }
        if (fruitTransaction.getQuantity() < 0) {
            throw new FruitShopException(fruitTransaction.getQuantity() + " is invalid quantity!");
        }
        Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}