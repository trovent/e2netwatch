package de.e2security.netflow_flowaggregation.exceptions;

public class TcpConnectionException extends Exception {
	private static final long serialVersionUID = 1L;

	public TcpConnectionException(String message) {
        super(message);
    }

}