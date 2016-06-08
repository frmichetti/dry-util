/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package frmichetti.com.dry.factory.exception;


public class ConnectionException extends Exception {

	private static final long serialVersionUID = -6097217251751227573L;

	/**
	 * Creates a new instance of <code>ConnectionException</code> without detail
	 * message.
	 */    
	private ConnectionException() {
		System.out.println("Troubles on Connection");
	}

	/**
	 * Constructs an instance of <code>ConnectionException</code> with the
	 * specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public ConnectionException(String msg) {		
		super(msg);		
	}
}
