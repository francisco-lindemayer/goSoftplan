package lab.gosoftplan.cost;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import lab.gosoftplan.cost.common.ItemType;
import lab.gosoftplan.cost.common.UnitSymbol;
import lab.gosoftplan.cost.common.DoubleCustomAdapter;

public class Item {

  @SerializedName("codigoItem")
  private Long code;

  @SerializedName("descricaoItemComposicao")
  private String description;

  @SerializedName("unidadeItem")
  private UnitSymbol unitSymbol;

  @SerializedName("tipoItem")
  private ItemType itemType;

  @SerializedName("quantidadeComposicao")
  @JsonAdapter(DoubleCustomAdapter.class)
  private Double quantity;

  @SerializedName("valorUnitario")
  @JsonAdapter(DoubleCustomAdapter.class)
  private Double unitValue;

  @Expose(deserialize = false)
  private Double totalValue;

  Item() {
    this.unitValue = Double.valueOf(0);
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

  public String getUnitSymbol() {
    return this.unitSymbol.name();
  }

  public void setUnitSymbol(String unitSymbol) {
    this.unitSymbol = UnitSymbol.valueOf(unitSymbol);
  }

  public String getItemType() {
    return this.itemType.name();
  }

  public void setItemType(String itemType) {
    this.itemType = ItemType.valueOf(itemType);
  }

  public Double getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public Double getUnitvalue() {
    return this.unitValue;
  }

  public void setUnitvalue(Double unitValue) {
    this.unitValue = unitValue;
  }

  public Double getTotalvalue() {
    return this.totalValue;
  }

  protected void totalize() {
    Double result = Math.floor((this.unitValue * this.quantity) * 100) / 100;
    this.totalValue = result;
  }

  protected boolean isComposition() {
    return this.itemType == ItemType.COMPOSICAO;
  }
}