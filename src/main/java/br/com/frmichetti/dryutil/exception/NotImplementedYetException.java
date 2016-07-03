/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.frmichetti.dryutil.exception;

public class NotImplementedYetException extends Exception {

	private static final long serialVersionUID = -2610410571625018163L;

	/**
	 * Creates a new instance of <code>NotImplementedYetException</code> without detail
	 * message.
	 */   
	public NotImplementedYetException() {
		System.out.println("TODO [NOT IMPLEMENTED YET]");
	}
	/**
	 * Constructs an instance of <code>NotImplementedYetException</code> with the
	 * specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public NotImplementedYetException(String msg) {
		super(msg);
	}

}
