package designpatterns.sharding;

public class RangeShardManager extends ShardManager {

    private int getShardId(final Data.DataType type) throws Exception {
        switch (type) {
            case type1:
              return 1;
            case type2:
              return 2;
            case type3:
              return 3;
            default:
              throw new Exception("Invalid DataType");
        }
    }

    @Override
    public void storeData(Data data) {
      Data.DataType type = data.getType();
      try {
          int shardId = getShardId(type);
          shardMap.get(shardId).storeData(data);
      } catch (Exception e) {
        System.err.println("Failed to store data: " + e.getMessage());
      }
    }
}
