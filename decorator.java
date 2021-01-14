import com.apple.eawt.event.GestureAdapter;

interface Coffee { // Item type to be ordered
    String getDesc();

    double getCost();
}

class Cappuccino implements Coffee { // Item name 1
    @Override
    public double getCost() {
        return 15.0;
    }

    @Override
    public String getDesc() {
        return "Cappuccino coffee,";
    }
}

class Latte implements Coffee { // Item name 2
    @Override
    public double getCost() {
        return 10.0;
    }

    @Override
    public String getDesc() {
        return "Latte coffee";
    }

}

abstract class MixerDecorator implements Coffee { // The decorator abstract class which other decorators at same level will implement
    protected Coffee coffee;

    MixerDecorator(Coffee newCoffee) {
        coffee = newCoffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String getDesc() {
        return coffee.getDesc();
    }
}

class Sugar extends MixerDecorator { // Same level decorator 1
    Sugar(Coffee newCoffee) {
        super(newCoffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 1;
    }

    @Override
    public String getDesc() {
        return coffee.getDesc() + " Adding sugar";
    }
}

class NonSugar extends MixerDecorator { // Same level decorator 2
    NonSugar(Coffee newCoffee) {
        super(newCoffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() - 1;
    }

    @Override
    public String getDesc() {
        return coffee.getDesc() + " Non sugar";
    }
}

class Chocolate extends MixerDecorator { // Same level decorator 3
    Chocolate(Coffee newCoffee) {
        super(newCoffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 3;
    }

    @Override
    public String getDesc() {
        return coffee.getDesc() + " Mixing chocolate";
    }
}

public class decorator { // The main order/receipt class
    public static void main(String[] args) {
        Coffee orderedCoffee = new Chocolate(new Sugar(new Cappuccino()));
        System.out.println("Tota cost is " + orderedCoffee.getCost());
        System.out.println(orderedCoffee.getDesc());

        Coffee cheapCoffee = new NonSugar(new Latte());
        System.out.println("Price is "+ cheapCoffee.getCost());
    }
}
