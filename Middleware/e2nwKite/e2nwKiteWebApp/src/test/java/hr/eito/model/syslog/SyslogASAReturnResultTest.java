
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


package hr.eito.model.syslog;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.ArrayList;

import hr.eito.model.QueryResult;
import hr.eito.model.Hits;
import hr.eito.model.Hit;

/**
 * Tests the SyslogASAReturnResult.
 *
 * @author Steve Chaplin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/config/app-config.xml" })
@ActiveProfiles("test")
public class SyslogASAReturnResultTest {

	/**
	 * Runs before the tests start.
	 */
	@BeforeClass
	public static void testStart() { }
	
	/**
	 * Runs after the tests end.
	 */
	@AfterClass
	public static void testEnd() { }

	/**
	 * Test with a dummy result set.
	 */
	@Test
	public void testEmptyResults() {

		QueryResult<SyslogASAQueryResultField> q = new QueryResult<SyslogASAQueryResultField>();

		SyslogASAReturnResult d = new SyslogASAReturnResult(q);

		Assert.assertEquals(0, d.getData().size());
		Assert.assertEquals(0, d.getRecordsTotal());
		Assert.assertEquals(0, d.getRecordsFiltered());
	}

	/**
	 * Test with a broken result set (hits but no sub-hits).
	 */
	@Test
	public void testBrokenResults_00() {
		Hits<SyslogASAQueryResultField> h = new Hits<SyslogASAQueryResultField>();

		QueryResult<SyslogASAQueryResultField> q = new QueryResult<SyslogASAQueryResultField>();
		q.setHits(h);

		SyslogASAReturnResult d = new SyslogASAReturnResult(q);

		Assert.assertEquals(0, d.getData().size());
		Assert.assertEquals(0, d.getRecordsTotal());
		Assert.assertEquals(0, d.getRecordsFiltered());
	}

	/**
	 * Test with broken result set (hits but no data in array).
	 */
	@Test
	public void testBrokenResults_01() {
		List<Hit<SyslogASAQueryResultField>> hits = new ArrayList<Hit<SyslogASAQueryResultField>>();
		hits.add(new Hit<SyslogASAQueryResultField>());

		Hits<SyslogASAQueryResultField> h = new Hits<SyslogASAQueryResultField>();
		h.setHits(hits);

		QueryResult<SyslogASAQueryResultField> q = new QueryResult<SyslogASAQueryResultField>();
		q.setHits(h);

		SyslogASAReturnResult d = new SyslogASAReturnResult(q);

		Assert.assertEquals(1, d.getData().size());
		Assert.assertEquals(0, d.getRecordsTotal());
		Assert.assertEquals(1, d.getRecordsFiltered());
	}

	/**
	 * Test with a correct result set.
	 */
	@Test
	public void testResults() {

		final String message = "Message";
		final String asaFw = "asafw";
		final String timestamp = "2016-12-22T10:11:12.000+01:00";

		SyslogASAQueryResultField f = new SyslogASAQueryResultField();
		f.setMessage(message);
		f.setAsa_fw(asaFw);
		f.setTimestamp(timestamp);

		Hit<SyslogASAQueryResultField> hit = new Hit<SyslogASAQueryResultField>();
		hit.set_source(f);

		List<Hit<SyslogASAQueryResultField>> hits = new ArrayList<Hit<SyslogASAQueryResultField>>();
		hits.add(hit);

		Hits<SyslogASAQueryResultField> h = new Hits<SyslogASAQueryResultField>();
		h.setHits(hits);

		QueryResult<SyslogASAQueryResultField> q = new QueryResult<SyslogASAQueryResultField>();
		q.setHits(h);

		SyslogASAReturnResult d = new SyslogASAReturnResult(q);

		Assert.assertEquals(1, d.getData().size());
		Assert.assertEquals(0, d.getRecordsTotal());
		Assert.assertEquals(1, d.getRecordsFiltered());
		Assert.assertEquals(message, d.getData().get(0).getMessage());
		Assert.assertEquals(asaFw, d.getData().get(0).getAsa_fw());
		Assert.assertEquals(timestamp, d.getData().get(0).getTimestamp());
	}
}
