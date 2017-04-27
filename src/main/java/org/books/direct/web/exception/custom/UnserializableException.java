package org.books.direct.web.exception.custom;

public class UnserializableException extends RuntimeException {

  private static final long serialVersionUID = -2101654954265930613L;

  public UnserializableException(String message) {
    super(message);
  }

  public UnserializableException(Throwable cause) {
    super(cause);
  }

  public UnserializableException(String message, Throwable cause) {
    super(message, cause);
  }

}
