package lab.gosoftplan.cost;

import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

public class CompositionPrinter {

  protected static void print(List<Composition> compositionList) {

    StringBuilder bodyContentToConsole = new StringBuilder();

    compositionList.sort(Comparator.comparing(Composition::getCode).reversed());

    compositionList.stream().forEach(composition -> {

      StringJoiner lineContent = new StringJoiner(" ");
      lineContent.add(composition.getCode().toString());
      lineContent.add(composition.getDescription());
      lineContent.add(composition.getUnitSymbol().toString());
      lineContent.add(composition.getFormattedTotalValue());

      bodyContentToConsole.append(lineContent);
      bodyContentToConsole.append(System.lineSeparator());
    });

    System.out.println(bodyContentToConsole.toString());
  }
}