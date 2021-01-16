import java.util.Scanner;
import jdk.javadoc.internal.doclets.formats.html.resources.standard;

interface Button { // abstract product 1
    void pressed();
}

interface CheckBox { // abstract product 2
    void clicked();
}

class MacOSButton implements Button { // Concrete product 1
    @Override
    public void pressed() {
        System.out.println("Created MacOS button");
    }
}

class WindowsButton implements Button { // Concrete product 1
    @Override
    public void pressed() {
        System.out.println("Created windows button");
    }
}

class MacOSCheckBox implements CheckBox { // Concrete product 2
    @Override
    public void clicked() {
        System.out.println("Created MacOS Checkbox");
    }
}

class WindowsCheckBox implements CheckBox { // Concrete product 2
    @Override
    public void clicked() {
        System.out.println("Created Windows Checkbox");
    }
}

interface GUIFactory { // Abstract factory
    Button createButton();
    CheckBox createCheckBox();
}

class MacOSFactory implements GUIFactory { // Concrete factory 1
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox();
    }
}

class WindowsFactory implements GUIFactory { // Concrete factory 2
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}

class Application {
    private Button button;
    private CheckBox checkBox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    public void actions() {
        button.pressed();
        checkBox.clicked();
    }
}

public class abstractFactory {

    private static Application configure() {
        Application app = null;
        GUIFactory factory;
        Scanner input = new Scanner(System.in);
        System.out.print("Which os type ? MacOS/Windows");
        if(input.hasNextLine()) {
            String typeOfOs = input.nextLine();
            if(typeOfOs.equals("MacOS")) {
                factory = new MacOSFactory();
                app = new Application(factory);
            } else if(typeOfOs.equals("Windows")) {
                factory = new WindowsFactory();
                app = new Application(factory);
            } 
        }
        return app;
    }

    public static void main(String[] args) {
        Application app = configure();
        if(app!=null) {
            app.actions();
        } else {
            System.out.println("Invalid OS");
        }
    }
}
