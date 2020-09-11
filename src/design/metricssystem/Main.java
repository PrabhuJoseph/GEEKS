package design.metricssystem;

public class Main {
  public static void main(String[] args) throws Exception {
    MetricsSystem metricsSystem = new MetricsSystem();
    metricsSystem.register("jmxsource", new JMXMetricsSource());
    metricsSystem.register("filesink", new FileSink());
    Thread.sleep(3000);
    metricsSystem.stop();
  }
}
