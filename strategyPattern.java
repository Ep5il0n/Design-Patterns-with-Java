import java.net.Socket;

class Animal {
    public Flys flyingType;

    public String tryTofly() {
        return flyingType.fly();
    }

    public void setFlyingAbility(Flys newFlyType) {
        flyingType = newFlyType;
    }
}

interface Flys {
    String fly();
}

class Dog extends Animal {
    public Dog() {
        super();
        flyingType = new CantFly();
    }
}

class Bird extends Animal {
    public Bird() {
        super();
        flyingType = new Itflys();
    }
}

class Itflys implements Flys {
    @Override
    public String fly() {
        return "Flying high";
    }
}

class CantFly implements Flys {
    @Override
    public String fly() {
        return "I cannot fly";
    }
}

class strategyPattern {
     public static void main(String[] args) {
        Animal sparky = new Dog();
        Animal tweety = new Bird();
        System.out.println("Dog: "+sparky.tryTofly());
        System.out.println("Bird: "+tweety.tryTofly());
        sparky.setFlyingAbility(new Itflys());
        System.out.println("Dog: "+sparky.tryTofly());
    }
}
