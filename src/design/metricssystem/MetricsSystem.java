package design.metricssystem;

import design.metricssystem.MetricsRecord;
import design.metricssystem.MetricsSink;
import design.metricssystem.MetricsSource;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class MetricsSystem {
  private final Map<String, MetricsSource> allSources;
  private final Map<String, MetricsSink> allSinks;
  private final MetricsCollector collector;

  public MetricsSystem() {
    allSources = new HashMap<>();
    allSinks = new HashMap<>();
    collector = new MetricsCollector(1000);
    collector.start();
  }

  public <T extends MetricsSink> void register(String name, T sink) {
    allSinks.put(name, sink);
  }

  public <T extends MetricsSource> void register(String name, T source) {
    allSources.put(name, source);
  }

  class MetricsCollector extends Thread {
    private final int interval;
    public MetricsCollector(int interval) {
      this.interval = interval;
    }
    @Override
    public void run() {
      while (!Thread.currentThread().isInterrupted()) {
        List<MetricsRecord> records = new ArrayList<>();
        for (MetricsSource source : allSources.values()) {
          MetricsRecord record = source.getMetrics();
          records.add(record);
        }
        for (MetricsSink sink : allSinks.values()) {
          sink.putMetrics(records.toArray(new MetricsRecord[0]));
        }
        try {
          Thread.sleep(interval);
        } catch (Exception e) {
          System.err.println("MetricsCollector thread interrupted: " + e.getMessage());
          return;
        }
      }
    }
  }

  public void stop() {
    if (collector != null) {
      collector.interrupt();
    }
    for (MetricsSink sink : allSinks.values()) {
      if (sink instanceof Closeable) {
        try {
          ((Closeable) sink).close();
        } catch (Exception e) {
          System.err.println("Failed to close sink " + sink.getClass().getName() + "due to " + e.getMessage());
        }
      }
    }
  }

}
