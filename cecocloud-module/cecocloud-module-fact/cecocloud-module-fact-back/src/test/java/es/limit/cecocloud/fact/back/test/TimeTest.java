/**
 * 
 */
package es.limit.cecocloud.fact.back.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

/**
 * @author limit
 *
 */
public class TimeTest {

	@Test
	public void tt() {
		Date t1 = new Date();
		t1.setTime(47574786);
		Date t2 = new Date();
		t2.setTime(47574000);
		System.out.println(">>> t1: " + getOnlyTimeWithoutMillisecondsFromDate(t1)); 
		System.out.println(">>> t2: " + getOnlyTimeWithoutMillisecondsFromDate(t2));
		//assertEquals(t1 / 1000, t2 / 1000);
		assertEquals(getOnlyTimeWithoutMillisecondsFromDate(t1), getOnlyTimeWithoutMillisecondsFromDate(t2));
	}

	private static long getOnlyTimeWithoutMillisecondsFromDate(Date date) {
		return (date.getTime() % (24*60*60*1000L)) / 1000;
	}

}
