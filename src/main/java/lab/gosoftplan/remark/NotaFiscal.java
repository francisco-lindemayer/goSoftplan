package lab.gosoftplan.remark;

import java.text.NumberFormat;

public class NotaFiscal {

  private String number;
  private Double totalValue;

  public NotaFiscal(String number, Double totalValue) {
    this.number = number;
    this.totalValue = totalValue;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Double getTotalValue() {
    return this.totalValue;
  }

  public String getFormattedTotalValue() {
    String formattedValue = NumberFormat.getCurrencyInstance().format(this.totalValue);
    return formattedValue;
  }

  public void setTotalValue(Double totalValue) {
    this.totalValue = totalValue;
  }

}