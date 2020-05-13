package lab.gosoftplan.cost;

import com.google.gson.JsonArray;
import lab.gosoftplan.cost.common.FileToJSON;

public class App {

    static final String basePath = System.getProperty("user.dir");

    public static void main(String[] args) {

        String pathToFile = basePath + "/src/main/resources/dados-entrada-servicos-composicoes.json";

        JsonArray inputJsonData = FileToJSON.readFile(pathToFile);

        CostCalculatorService costCalculate = new CostCalculatorService();
        costCalculate.process(inputJsonData);

    }
}
