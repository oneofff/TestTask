import dao.exeption.DaoException;
import service.UiService;


public class Start {

    public static void main(String[] args) throws DaoException {
       UiService uiService =new UiService();
       uiService.start();
    }
}
