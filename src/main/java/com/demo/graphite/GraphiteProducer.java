package com.demo.graphite;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;

@ApplicationScoped
@Startup
public class GraphiteProducer {

	static final MetricRegistry metrics = new MetricRegistry();
	final Graphite graphite = new Graphite(new InetSocketAddress("0.0.0.0", 2003));
	final GraphiteReporter reporter = GraphiteReporter.forRegistry(metrics)
	                                                  .prefixedWith("web1.example.com")
	                                                  .convertRatesTo(TimeUnit.SECONDS)
	                                                  .convertDurationsTo(TimeUnit.MILLISECONDS)
	                                                  .filter(MetricFilter.ALL)
	                                                  .build(graphite);
	
	
	@PostConstruct
	private void initGraphiteProducer() {
		//reporter.start(1, TimeUnit.SECONDS);
		System.out.println(" ................... Graphite produce reports ........");
	}
	
	@Produces
	public MetricRegistry getMetrics() {
		System.out.println(" Get Metrics ==="+metrics);
		return metrics;
	}
	
	
}
