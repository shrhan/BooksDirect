package org.books.direct.web.exception.custom;

public class ForbiddenOperationException extends RuntimeException {

  private static final long serialVersionUID = 7234461506198757125L;

  public ForbiddenOperationException(String msg, Throwable cause) {
    super(msg, cause);
  }

  public ForbiddenOperationException(String msg) {
     super(msg);
   }
}
