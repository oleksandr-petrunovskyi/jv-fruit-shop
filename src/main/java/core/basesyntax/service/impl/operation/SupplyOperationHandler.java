package core.basesyntax.service.impl.operation;

import core.basesyntax.dao.WarehouseDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    private final Map<String, Integer> warehouse = new WarehouseDaoImpl().getWarehouse();

    @Override
    public void handle(FruitTransaction transaction) {
        for (Map.Entry<String, Integer> entry : warehouse.entrySet()) {
            if (entry.getKey().equals(transaction.getFruit())) {
                entry.setValue(entry.getValue() + transaction.getQuantity());
            }
        }
    }
}
