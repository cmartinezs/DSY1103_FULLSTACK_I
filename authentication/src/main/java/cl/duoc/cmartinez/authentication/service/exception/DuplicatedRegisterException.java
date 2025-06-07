package cl.duoc.cmartinez.authentication.service.exception;

public class DuplicatedRegisterException extends RuntimeException {
  public DuplicatedRegisterException(String message) {
    super(message);
  }

  public DuplicatedRegisterException(String message, Throwable cause) {
    super(message, cause);
  }
}
