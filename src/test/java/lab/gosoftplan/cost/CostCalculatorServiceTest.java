package lab.gosoftplan.cost;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import com.google.gson.JsonArray;
import org.junit.jupiter.api.Test;
import lab.gosoftplan.cost.common.FileToJSON;

public class CostCalculatorServiceTest {

    static final String basePath = System.getProperty("user.dir");

    @Test
    public void checkTotalValueTest() {

        String pathToFile = basePath + "/src/main/resources/dados-entrada-servicos-composicoes.json";
        JsonArray inputJsonData = FileToJSON.readFile(pathToFile);
        Map<Long, Composition> listCalculatedComposition;
        CostCalculatorService costCalculate;
        Double totalValue;

        costCalculate = new CostCalculatorService();
        listCalculatedComposition = costCalculate.process(inputJsonData);

        totalValue = listCalculatedComposition.get(Long.valueOf(94793)).getTotalValue();
        assertEquals(128.60, totalValue, "Valor incorreto para a composição 94793");

        totalValue = listCalculatedComposition.get(Long.valueOf(98561)).getTotalValue();
        assertEquals(28.73, totalValue, "Valor incorreto para a composição 98561");

        totalValue = listCalculatedComposition.get(Long.valueOf(87286)).getTotalValue();
        assertEquals(289.97, totalValue, "Valor incorreto para a composição 87286");

        totalValue = listCalculatedComposition.get(Long.valueOf(88830)).getTotalValue();
        assertEquals(1.25, totalValue, "Valor incorreto para a composição 88830");

        totalValue = listCalculatedComposition.get(Long.valueOf(88831)).getTotalValue();
        assertEquals(0.22, totalValue, "Valor incorreto para a composição 88831");

    }

    @Test
    public void checkUnitSymbolTest() {

        String pathToFile = basePath + "/src/main/resources/dados-entrada-servicos-composicoes.json";
        JsonArray inputJsonData = FileToJSON.readFile(pathToFile);
        Map<Long, Composition> listCalculatedComposition;
        CostCalculatorService costCalculate;
        String unitSymbol;

        costCalculate = new CostCalculatorService();
        listCalculatedComposition = costCalculate.process(inputJsonData);

        unitSymbol = listCalculatedComposition.get(Long.valueOf(94793)).getUnitSymbol().toString();
        assertEquals("UN", unitSymbol, "Unidade incorreta para a composição 94793");

        unitSymbol = listCalculatedComposition.get(Long.valueOf(98561)).getUnitSymbol().toString();
        assertEquals("M2", unitSymbol, "Unidade incorreta para a composição 98561");

        unitSymbol = listCalculatedComposition.get(Long.valueOf(87286)).getUnitSymbol().toString();
        assertEquals("M3", unitSymbol, "Unidade incorreta para a composição 87286");

        unitSymbol = listCalculatedComposition.get(Long.valueOf(88830)).getUnitSymbol().toString();
        assertEquals("CHP", unitSymbol, "Unidade incorreta para a composição 88830");

        unitSymbol = listCalculatedComposition.get(Long.valueOf(88831)).getUnitSymbol().toString();
        assertEquals("CHI", unitSymbol, "Unidade incorreta para a composição 88831");

    }

    @Test
    public void emptyList() {

        String pathToFile = basePath + "/src/main/resources/emptyFile.json";
        JsonArray inputJsonData = FileToJSON.readFile(pathToFile);
        Map<Long, Composition> listCalculatedComposition;
        CostCalculatorService costCalculate;

        costCalculate = new CostCalculatorService();
        listCalculatedComposition = costCalculate.process(inputJsonData);

        assertEquals(0, listCalculatedComposition.size(), "Não retornou uma lista vazia");

    }

}