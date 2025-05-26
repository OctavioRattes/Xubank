import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        Menu menu = new Menu(clientes);
        menu.iniciar();
    }
}