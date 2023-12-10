package Master;

import Utilities.Files;

public class Main {
    static Files files = new Files();
    static Menu menu = new Menu();

    public static void main(String[] args) {
        files.ReadFiles();
        menu.MainMenu();
        files.WriteFiles();
    }
}

