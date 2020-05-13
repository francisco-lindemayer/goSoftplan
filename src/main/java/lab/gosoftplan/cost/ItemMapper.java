package lab.gosoftplan.cost;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class ItemMapper {
  public static Item jsonToObject(final JsonElement dataItem) {

    Gson gson = new Gson();
    Item item = gson.fromJson(dataItem, Item.class);

    return item;
  }

}