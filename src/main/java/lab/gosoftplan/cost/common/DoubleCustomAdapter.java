package lab.gosoftplan.cost.common;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.Gson;
import com.google.gson.JsonPrimitive;

public class DoubleCustomAdapter extends TypeAdapter<Double> {

  @Override
  public void write(final JsonWriter out, final Double value) throws IOException {
    out.value(value.toString().replace(".", ","));
  }

  @Override
  public Double read(final JsonReader reader) throws IOException {
    final JsonPrimitive jsonContent = new Gson().fromJson(reader, JsonPrimitive.class);

    String valueToParse = jsonContent.getAsString().replace(",", ".");
    valueToParse = (valueToParse.isBlank()) ? "0" : valueToParse;

    return new Gson().fromJson(valueToParse, Double.class);
  }

}