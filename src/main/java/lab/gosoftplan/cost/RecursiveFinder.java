package lab.gosoftplan.cost;

import com.google.gson.JsonArray;

public class RecursiveFinder {

  protected Double findComposition(JsonArray contentToComposition, Long compositionCode) {

    final int FIRST_POSITION = 0;
    final JsonArray contentToFind = contentToComposition.deepCopy();

    Composition compositionFound = new Composition();

    while (contentToFind.size() > FIRST_POSITION) {

      Composition composition = CompositionMapper.jsonToObject(contentToFind.get(FIRST_POSITION));

      if (composition.getCode().equals(compositionCode)) {

        if (compositionFound.getCode() == null) {
          compositionFound = CompositionMapper.jsonToObject(contentToFind.get(FIRST_POSITION));
        }

        Item item = ItemMapper.jsonToObject(contentToFind.get(FIRST_POSITION));

        if (item.isComposition()) {
          Double totalValueCompositeType = findComposition(contentToComposition, item.getCode());
          item.setUnitvalue(totalValueCompositeType);
        }

        compositionFound.addItem(item);
      }

      contentToFind.remove(FIRST_POSITION);
    }

    return compositionFound.getTotalValue();
  }
}