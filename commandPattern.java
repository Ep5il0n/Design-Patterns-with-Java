
interface Command { // Abstract command
    public void execute();
}

class LightOnCommand implements Command { // Concrete Command

    // Reference to the light
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.switchOn(); // Explicit call of selected class's method
    }
}

class LightOffCommand implements Command { // Concrete command

    // Reference to the light
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.switchOff();
    }
}

class Light { // Receiver
    private boolean on;

    public void switchOn() {
        on = true;
        System.out.println("Switch is on");
    }

    public void switchOff() {
        on = false;
        System.out.println("switch is off");
    }
}

class RemoteControl { // Invoker
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class commandPattern {
    public static void main(String[] args) {
        RemoteControl control = new RemoteControl();
        Light light = new Light();
        Command lightsOn = new LightOnCommand(light);
        Command lightsOff = new LightOffCommand(light);

        // Switch on
        control.setCommand(lightsOn);
        control.pressButton();

        // Switch off
        control.setCommand(lightsOff);
        control.pressButton();
    }
}
