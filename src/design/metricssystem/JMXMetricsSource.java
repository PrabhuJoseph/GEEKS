package design.metricssystem;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class JMXMetricsSource implements MetricsSource {

  static final float M = 1024*1024;

  @Override
  public MetricsRecord getMetrics() {
    MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();
    float memory = memoryUsage.getUsed() / M;
    MetricsRecord record = new MetricsRecord(System.currentTimeMillis(), "jmx");
    record.addMetrics(new MetricsInfo("memoryUsed", memory));
    return record;
  }
}
