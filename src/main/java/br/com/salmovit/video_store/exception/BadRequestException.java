package br.com.salmovit.video_store.exception;

public class BadRequestException extends RuntimeException{
	
	public BadRequestException(String message) {
		super(message);
	}

}
