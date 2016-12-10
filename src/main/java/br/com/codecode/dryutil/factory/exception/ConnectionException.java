package br.com.codecode.dryutil.factory.exception;

public class ConnectionException extends Exception {

    private static final long serialVersionUID = -6097217251751227573L;

    public ConnectionException() {
	System.out.println("Troubles on Connection");
    }
 
    public ConnectionException(String msg) {
	super(msg);
    }
}
