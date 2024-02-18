package deques;
public class EmptyDeckException extends RuntimeException {
    public EmptyDeckException(String err) {
      super(err);
    }
  }