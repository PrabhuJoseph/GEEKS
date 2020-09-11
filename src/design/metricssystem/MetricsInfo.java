package design.metricssystem;

public class MetricsInfo {
  private String name;
  private Number value;
  MetricsInfo(String name, Number value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return this.name;
  }

  public Number getValue() {
    return this.value;
  }

  public String toString() {
    return name + ":" + value;
  }

}
