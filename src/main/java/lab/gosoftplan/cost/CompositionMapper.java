package lab.gosoftplan.cost;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class CompositionMapper {
  public static Composition jsonToObject(final JsonElement dataComposition) {

    Gson gson = new Gson();
    Composition composition = gson.fromJson(dataComposition, Composition.class);

    return composition;
  }
}