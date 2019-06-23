package io.github.wesleyosantos.apifirst.exception.core;

/**
 * Created by wesleyosantos91 on 2019-06-22.
 */
public class ObjectNotFoundException  extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
