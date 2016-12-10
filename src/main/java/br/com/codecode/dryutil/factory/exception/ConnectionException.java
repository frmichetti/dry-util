package br.com.codecode.dryutil.factory.exception;

public class ConnectionException extends Exception {

    private static final long serialVersionUID = -6097217251751227573L;

    public ConnectionException(){}
 
    public ConnectionException(String msg) {
	super(msg);
    }

    public ConnectionException(String message, Throwable cause) {
	super(message, cause);	
    }

    public ConnectionException(Throwable cause) {
	super(cause);
    }
}
