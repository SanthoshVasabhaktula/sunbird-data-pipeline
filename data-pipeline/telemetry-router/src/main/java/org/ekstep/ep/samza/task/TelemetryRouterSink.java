package org.ekstep.ep.samza.task;

import org.apache.samza.task.MessageCollector;
import org.ekstep.ep.samza.core.BaseSink;
import org.ekstep.ep.samza.core.JobMetrics;
import org.ekstep.ep.samza.domain.Event;

public class TelemetryRouterSink extends BaseSink {

	private JobMetrics metrics;
	private TelemetryRouterConfig config;
	
	public TelemetryRouterSink(MessageCollector collector, JobMetrics metrics, TelemetryRouterConfig config) {

		super(collector);
		this.metrics = metrics;
		this.config = config;
	}

	public void toPrimaryRoute(Event event) {
		toTopic(config.getPrimaryRouteTopic(), event.did(), event.getJson());
		metrics.incSuccessCounter();
	}

	public void toErrorTopic(Event event, String errorMessage) {
		event.markFailure(errorMessage, config);
		toTopic(config.failedTopic(), event.mid(), event.getJson());
		metrics.incErrorCounter();
	}

	public void toMalformedTopic(String message) {
		toTopic(config.malformedTopic(), null, message);
		metrics.incErrorCounter();
	}

	public void toSecondaryRoute(Event event) {
		toTopic(config.getSecondaryRouteTopic(), event.did(), event.getJson());
		metrics.incSuccessCounter();
	}
}