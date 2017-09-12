package com.demo.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.demo.common.Stall;
import com.demo.common.StallQualifier;
import com.demo.common.StallType;

@Path(value = "heartbeat")
public class HeartBeatResource {

	@Inject
	@StallQualifier(StallType.VEGE)
	private Stall stall;
	
	@Inject
	private MetricRegistry metric;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHealCheck() {
		System.out.println(" Health check is invoked"+metric);
		//Meter requests = metric.meter("requests");
		//requests.mark();
		return Response.ok().entity(stall.getName()).build();
	}
}
