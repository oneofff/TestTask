package dao.exeption;

public class UserSaveError extends Exception {
  public   UserSaveError()
  {
      super("Error Save User to file");
  }
}
