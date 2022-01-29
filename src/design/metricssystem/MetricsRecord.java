package design.metricssystem;

import design.metricssystem.MetricsInfo;

import java.util.ArrayList;
import java.util.List;

public class MetricsRecord {
  private long timestamp;
  private String context;
  List<MetricsInfo> metrics;

  public MetricsRecord(long timestamp, String context) {
    this.timestamp = timestamp;
    this.context = context;
    metrics = new ArrayList<>();
  }

  public long getTimestamp() {
    return timestamp;
  }

  public String getContext() {
    return context;
  }

  public List<MetricsInfo> getMetrics() {
    return metrics;
  }

  public void addMetrics(MetricsInfo info) {
    metrics.add(info);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(context + "-" + timestamp);
    sb.append("\n");
    for (MetricsInfo info : metrics) {
      sb.append(info.toString());
    }
    return sb.toString();
  }
}
