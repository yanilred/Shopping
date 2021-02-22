package com.tcs.shopping.exceptions;

public class ClientRequestException extends RuntimeException{
	
	  private static final long serialVersionUID = 5861310537366287163L;

	    public ClientRequestException() {
	        super();
	    }

	    public ClientRequestException(final String message, final Throwable cause) {
	        super(message, cause);
	    }

	    public ClientRequestException(final String message) {
	        super(message);
	    }

	    public ClientRequestException(final Throwable cause) {
	        super(cause);
	    }

}
