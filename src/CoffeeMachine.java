/*
* A coffee machine that simulate realWorld coffee Machines
* when it open it will popup with a menu action (Write action (buy, fill, take, remaining, exit):)
* buy: to buy a specific type of coffee (What do you want to buy? 1 - espresso, 2 - latte , 3 - cappuccino, back - to main menu)
*   to choose any kind of coffee you just need to enter the corresponding number for it and if you want back to menu just type back
* fill: to fill the machine the amount of supplies you want.
* take: to take the money that the machine collected.
* remaining: simply represent the amount of water, milk, coffee Beans, disposable cups and money that the machine have.
* exit : to quite the machine.
* */

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        coffee_maker cof = new coffee_maker();
        cof.main_cycle();
    }
}
