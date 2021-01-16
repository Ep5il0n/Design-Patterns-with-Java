import java.util.Scanner;

import org.graalvm.compiler.nodes.ReturnNode;

abstract class FitWatch { // Abstract product
    private String name;
    private String color;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setColor(String newColor) {
        color = newColor;
    }

    public void printDetails() {
        System.out.println("Name is " + name + " And color is " + color);
    }
}

class GalaxyFitWatch extends FitWatch { // Concrete product 1
    public GalaxyFitWatch() {
        setName("Moden watch");
        setColor("Prism black");
    }
}

class GalaxyFit2Watch extends FitWatch { // Concrete product 2
    public GalaxyFit2Watch() {
        setName("Neat watch");
        setColor("yellow");
    }
}


class GalaxyFitEWatch extends FitWatch { // Concrete product 3
    public GalaxyFitEWatch() {
        setName("Moden lite watch");
        setColor("Black");
    }
}


class WatchFactory { // Concrete factory class
    public FitWatch makeWatch(String watchType) {
        FitWatch newWatch = null;
        if(watchType.equals("Fit")) {
            return new GalaxyFitEWatch();
        } else if(watchType.equals("Fit2")) {
            return new GalaxyFit2Watch();
        } else if(watchType.equals("FitE")) {
            return new GalaxyFitEWatch();
        } else {
            return null;
        }
    }
}

public class factoryPattern { // Runtime decision class
     public static void main(String[] args) {
         WatchFactory wFactory = new WatchFactory();
         FitWatch wFitWatch = null;
         Scanner input = new Scanner(System.in);
         System.out.print("Which watch type ? Fit/Fit2/FitE");
         if(input.hasNextLine()) {
             String typeOfWatch = input.nextLine();
             wFitWatch = wFactory.makeWatch(typeOfWatch);
             if(wFitWatch!=null) {
                 doStuff(wFitWatch);
             } else {
                 System.out.println("Invalid watch type");
             }
         }
     }

     public static void doStuff(FitWatch wFitWatch) {
         wFitWatch.printDetails();
     }
}
