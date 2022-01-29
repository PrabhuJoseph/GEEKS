package designpatterns.sharding;

public class App {
  public static void main(String[] args) {
    Shard shard1 = new Shard(1);
    Shard shard2 = new Shard(2);
    Shard shard3 = new Shard(3);
    ShardManager manager = new HashShardManager();
    manager.addNewShard(shard1);
    manager.addNewShard(shard2);
    manager.addNewShard(shard3);

    Data data1 = new Data(1, "Prabhu", Data.DataType.type1);
    Data data2 = new Data(2, "Joshua", Data.DataType.type1);
    Data data3 = new Data(3, "Jacob", Data.DataType.type1);

    manager.storeData(data1);
    manager.storeData(data2);
    manager.storeData(data3);

    System.out.println(manager.getShardById(1).getDataById(1).getValue());

  }
}
