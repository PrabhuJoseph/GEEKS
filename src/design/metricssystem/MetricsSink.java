package design.metricssystem;

import design.metricssystem.MetricsRecord;

public interface MetricsSink {
  public void putMetrics(MetricsRecord[] metricsRecord);
}
