import java.util.Scanner;

public class coffee_maker {
    private  Scanner scanner;

    private int water , milk , coffee , cups , money ;

    coffee_maker() {
        this.scanner = new Scanner(System.in);
        this.water = 400;
        this.milk = 540;
        this.coffee = 120;
        this.cups = 9;
        this.money = 550;
    }



    public  void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$"+money + " of money\n");

    }
    enum Coffee_type {
        ESPRESSO( 1, 250, 0, 16, 4),
        LATTE( 2, 350, 75, 20, 7),
        CAPPUCCINO( 3, 200, 100, 12, 6);
        int typNum;
        int useWater;
        int useMilk;
        int useCoffee;
        int price;

        Coffee_type ( int typNum, int useWater, int useMilk, int useCoffee, int price) {
            this.typNum = typNum;
            this.useWater = useWater;
            this.useMilk = useMilk;
            this.useCoffee = useCoffee;
            this.price = price;
        }
        public static Coffee_type findByTypeNum(int numOftype) {
            Coffee_type[] coffee = Coffee_type.values();
            Coffee_type coffeeSelected = coffee[numOftype - 1];
            return coffeeSelected;
        }
    }
    public  void buy(int type_of_coffee) {
        Coffee_type coffees = Coffee_type.findByTypeNum(type_of_coffee);
        boolean statusOfWater = water >= coffees.useWater;
        boolean statusOfMilk = milk >= coffees.useMilk;
        boolean statusOfBeans = coffee >= coffees.useCoffee;
        boolean statusOfEmptyCups = cups > 0;
        if (statusOfWater && statusOfMilk && statusOfBeans && statusOfEmptyCups) {
            System.out.println("\nI have enough resources, making you a coffee!\n");
            water -= coffees.useWater;
            milk -= coffees.useMilk;
            coffee -= coffees.useCoffee;
            cups--;
            money += coffees.price;
        } else if (!statusOfWater) {
            System.out.println("Sorry, not enough water!\n");
        } else if (!statusOfMilk) {
            System.out.println("Sorry, not enough milk!\n");
        } else if (!statusOfBeans) {
            System.out.println("Sorry, not enough coffee beans!\n");
        } else if (!statusOfEmptyCups) {
            System.out.println("Sorry, not enough disposable cups!\n");
        }

    }

    public  void fill() {

        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();

    }
    public  void take() {
        System.out.println("I gave you $"+money);
        money = 0;

    }
    public  void main_cycle(){

        while(true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):\n");
            String action = scanner.next();

            if(action.equals(Actions.buy.toString())) {
                System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte , 3 - cappuccino, back - to main menu");
                String typeOfCoffee = scanner.next();
                if (typeOfCoffee.equals("back")) {
                    continue;
                } else {
                    buy(Integer.parseInt(typeOfCoffee));
                }
            }
            else if(action.equals(Actions.fill.toString())) {
                fill();
            }
            else if (action.equals(Actions.take.toString())) {
                take();
            }
            else if (action.equals(Actions.remaining.toString())) {
                remaining( );
            }
            else if (action.equals(Actions.exit.toString())) {
                System.exit(0);
            }
            else {
                System.out.println("Invalid Action");
            }

        }
    }
    enum Actions {
        buy,fill,take,remaining,exit
    }

}

