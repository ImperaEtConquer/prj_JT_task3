package exceptions;

import view.Messages;

public class AlreadyExistException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlreadyExistException() {
        super(Messages.ALREADY_EXISTS);
    }

}