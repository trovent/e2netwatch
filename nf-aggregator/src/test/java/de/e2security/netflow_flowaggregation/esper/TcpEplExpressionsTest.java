package de.e2security.netflow_flowaggregation.esper;

public final class TcpEplExpressionsTest {
	
	public static String selectNetStreamOrdered() {
		return "select * from NetflowEventOrdered";
	}
	
	public static String selectTcpConnections() {
		return "select * from TcpConnection";
	}
}