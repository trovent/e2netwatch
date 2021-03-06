
/*
    Copyright (C) 2017 e-ito Technology Services GmbH
    e-mail: info@e-ito.de
    
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/


package hr.eito.model.lara.rules.dto.out;

import com.fasterxml.jackson.annotation.JsonProperty;

import hr.eito.model.lara.rules.dto.Flow;

/**
 * Lara Rules flow class
 * 
 * @author Hrvoje
 *
 */
public class FlowOut {
	
	@JsonProperty("source")
	private IpFlowEntityOut source;
	@JsonProperty("destination")
	private IpFlowEntityOut destination;
	@JsonProperty("service")
	private PortFlowEntityOut service;
	
	public FlowOut(final Flow flow) {
		if (flow != null) {
			this.source = (flow.getService()!=null ? new IpFlowEntityOut(flow.getSource()) : null);
			this.destination = (flow.getService()!=null ? new IpFlowEntityOut(flow.getDestination()) : null);
			this.service = (flow.getService()!=null ? new PortFlowEntityOut(flow.getService()) : null);			
		}
	}
	
	public IpFlowEntityOut getSource() {
		return source;
	}
	public void setSource(IpFlowEntityOut source) {
		this.source = source;
	}
	public IpFlowEntityOut getDestination() {
		return destination;
	}
	public void setDestination(IpFlowEntityOut destination) {
		this.destination = destination;
	}
	public PortFlowEntityOut getService() {
		return service;
	}
	public void setService(PortFlowEntityOut service) {
		this.service = service;
	}

}
