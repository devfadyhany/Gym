package Master;

import Utilities.Files;

public class Main {
    public static void main(String[] args) {
        Files files = new Files();
        files.ReadFiles();
        Menu menu = new Menu();
        menu.MainMenu();
        files.WriteFiles();
    }
}

