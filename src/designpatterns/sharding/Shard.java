package designpatterns.sharding;

import java.util.HashMap;
import java.util.Map;

public class Shard {
  private int id;
  private Map<Integer, Data> dataStore;

  public Shard(final int id) {
    this.id = id;
    this.dataStore = new HashMap<>();
  }

  public void storeData(Data data) {
    dataStore.put(data.getKey(), data);
  }

  public void clearData() {
    dataStore.clear();
  }

  public Data getDataById(final int id) {
    return dataStore.get(id);
  }

  public int getId() {
    return id;
  }

}
