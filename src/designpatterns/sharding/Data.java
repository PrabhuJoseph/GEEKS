package designpatterns.sharding;

public class Data {
  private int key;
  private String value;
  private DataType type;

  enum DataType {
      type1, type2, type3
  }

  public Data(final int key, final String value, final DataType type) {
    this.key = key;
    this.value = value;
    this.type = type;
  }

  public void setKey(final int key) {
    this.key = key;
  }

  public void setValue(final String value) {
    this.value = value;
  }

  public void setType(final DataType type) {
    this.type = type;
  }

  public int getKey() {
    return this.key;
  }

  public String getValue() {
    return this.value;
  }

  public DataType getType() {
    return this.type;
  }
}
