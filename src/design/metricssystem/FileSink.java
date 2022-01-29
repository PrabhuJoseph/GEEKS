package design.metricssystem;

import java.io.Closeable;
import java.io.PrintStream;

public class FileSink implements MetricsSink, Closeable {
  private final PrintStream writer;

  public FileSink() {
    this.writer = System.out;
  }

  public void putMetrics(MetricsRecord[] metricsRecords) {
    for (MetricsRecord record : metricsRecords) {
      writer.println(record);
    }
    writer.flush();
  }

  public void close() {
    writer.close();
  }

}
