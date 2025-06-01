import controller.MenuController;
import view.MenuView;

public class Main {
    public static void main(String[] args) {

        MenuView menu = new MenuView();
        MenuController menuController = new MenuController(menu);
    }
}
