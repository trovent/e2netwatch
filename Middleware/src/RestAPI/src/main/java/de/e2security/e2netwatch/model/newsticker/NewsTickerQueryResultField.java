
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


package de.e2security.e2netwatch.model.newsticker;

import com.fasterxml.jackson.annotation.JsonSetter;

public class NewsTickerQueryResultField {
	private String _host;
	private String text;
	private String $timestamp;
	private int priority;
	private String _eventid;
	
	public String getHost() {
		return _host;
	}
	public void setHost(final String host) {
		_host = host;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public String get$timestamp() {
		return $timestamp;
	}
	@JsonSetter("@timestamp")
	public void set$timestamp(String $timestamp) {
		this.$timestamp = $timestamp;
	}

	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getEventid() {
		return _eventid;
	}
	public void setEventid(final String eventid) {
		_eventid = eventid;
	}
	
	
}