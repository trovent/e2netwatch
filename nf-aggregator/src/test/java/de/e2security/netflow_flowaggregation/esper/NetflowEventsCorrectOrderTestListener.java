package de.e2security.netflow_flowaggregation.esper;

import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

import de.e2security.netflow_flowaggregation.model.protocols.NetflowEventOrdered;

public class NetflowEventsCorrectOrderTestListener implements UpdateListener {

	private static final Logger LOG = LoggerFactory.getLogger(NetflowEventsCorrectOrderTestListener.class);

	private boolean stdout = false;
	
	NetflowEventsCorrectOrderTestListener(boolean stdout) {
		this.stdout = stdout;
	}

	private Queue<ZonedDateTime> dates = new ArrayDeque<>();
	private Queue<NetflowEventOrdered> netflowsOrdered = new ArrayDeque<>();
	
	@Override
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		NetflowEventOrdered event = (NetflowEventOrdered) newEvents[0].getUnderlying();
		ZonedDateTime last_switched = (ZonedDateTime) event.getLast_switched();
		if (stdout) LOG.info(last_switched.toString());
		dates.add(last_switched);
		netflowsOrdered.add(event);
	}
	
	public Queue<ZonedDateTime> getDates() {
		return dates;
	}
	
	public Queue<NetflowEventOrdered> getNetflowsOrdered() {
		return netflowsOrdered;
	}

}