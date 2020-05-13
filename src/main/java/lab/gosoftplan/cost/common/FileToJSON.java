package lab.gosoftplan.cost.common;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonReader;

public final class FileToJSON {

  public static JsonArray readFile(final String filePath) {

    JsonArray jsonFileContent;

    try {
      final JsonReader reader = new JsonReader(new FileReader(filePath));
      jsonFileContent = new Gson().fromJson(reader, JsonArray.class);
      return jsonFileContent;

    } catch (final FileNotFoundException error) {
      error.printStackTrace();
      return null;
    }
  }

}