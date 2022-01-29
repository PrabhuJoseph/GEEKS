package designpatterns.sharding;

import java.util.HashMap;
import java.util.Map;

public abstract class ShardManager {

  protected Map<Integer, Shard> shardMap;

  public ShardManager() {
    shardMap = new HashMap<>();
  }

  public abstract void storeData(Data data);

  public void addNewShard(final Shard shard) {
    shardMap.put(shard.getId(), shard);
  }

  public void removeShardById(final int id) {
    shardMap.remove(id);
  }

  public Shard getShardById(final int id) {
    return shardMap.get(id);
  }

}
