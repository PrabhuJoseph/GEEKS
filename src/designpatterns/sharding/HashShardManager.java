package designpatterns.sharding;

public class HashShardManager extends ShardManager {

  @Override
  public void storeData(Data data) {
    int shardCount = shardMap.size();
    int dataId = data.getKey();
    int shardId = data.getKey() % shardCount;
    shardId = ((shardId == 0) ? shardCount : shardId);
    System.out.println("SHARD="+shardId);
    shardMap.get(shardId).storeData(data);
  }

}
