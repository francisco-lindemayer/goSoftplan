package lab.gosoftplan.cost;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lab.gosoftplan.cost.common.UnitSymbol;

public class Composition {

  @SerializedName("codigoComposicao")
  private Long code;

  @SerializedName("descricaoComposicao")
  private String description;

  @SerializedName("unidadeComposicao")
  private UnitSymbol unitSymbol;

  @Expose(deserialize = false)
  private Double totalValue;

  @Expose(deserialize = false)
  private Map<Long, Item> item;

  Composition() {
    this.item = new HashMap<Long, Item>();
    this.totalValue = Double.valueOf(0);
  }

  public Long getCode() {
    return this.code;
  }

  public void setCode(Long code) {
    this.code = code;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public UnitSymbol getUnitSymbol() {
    return this.unitSymbol;
  }

  public void setUnitSymbol(String unitSymbol) {
    this.unitSymbol = UnitSymbol.valueOf(unitSymbol);
    ;
  }

  public Map<Long, Item> getItems() {
    return this.item;
  }

  public Item getItem(Long code) {
    return this.item.get(code);
  }

  public void addItem(Item item) {
    this.item.put(item.getCode(), item);
    sumItens();
  }

  public Double getTotalValue() {
    final int SCALE = 2;

    BigDecimal totalValue = new BigDecimal(this.totalValue.toString()).setScale(SCALE, RoundingMode.HALF_EVEN);

    return totalValue.doubleValue();
  }

  public String getFormattedTotalValue() {

    NumberFormat formatter = NumberFormat.getInstance(new Locale("pt", "BR"));
    formatter.setMinimumFractionDigits(2);

    String formattedTotalValue = formatter.format(this.totalValue);

    return formattedTotalValue;
  }

  private void sumItens() {
    this.totalValue = this.item.entrySet().stream().mapToDouble(item -> {
      item.getValue().totalize();
      return item.getValue().getTotalvalue();
    }).sum();
  }

}