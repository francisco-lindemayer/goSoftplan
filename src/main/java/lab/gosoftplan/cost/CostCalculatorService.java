package lab.gosoftplan.cost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonArray;

public class CostCalculatorService {

  private final Map<Long, Composition> compositionMap;

  public CostCalculatorService() {
    compositionMap = new HashMap<Long, Composition>();
  }

  public Map<Long, Composition> process(JsonArray fullContentToComposition) {

    try {

      if (fullContentToComposition.size() == 0) {
        return compositionMap;
      }

      fullContentToComposition.forEach(dataComposition -> {

        Composition composition = CompositionMapper.jsonToObject(dataComposition);
        Item item = ItemMapper.jsonToObject(dataComposition);

        if (item.isComposition()) {
          Double compositionValue = findValueComposition(fullContentToComposition, item.getCode());
          item.setUnitvalue(compositionValue);
        }

        if (compositionMap.containsKey(composition.getCode())) {
          composition = compositionMap.get(composition.getCode());
          composition.addItem(item);
          compositionMap.replace(composition.getCode(), composition);
        } else {
          composition.addItem(item);
          compositionMap.put(composition.getCode(), composition);
        }
      });

      CompositionPrinter.print(new ArrayList<Composition>(compositionMap.values()));

      return compositionMap;

    } catch (Exception error) {
      System.err.println(error);
    }
    return compositionMap;
  }

  private Double findValueComposition(JsonArray fullContentToComposition, Long compositionCode) {

    RecursiveFinder finder = new RecursiveFinder();

    Double totalValueCompositeType = finder.findComposition(fullContentToComposition, compositionCode);

    return totalValueCompositeType;
  }
}