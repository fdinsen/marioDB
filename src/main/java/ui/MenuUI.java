package ui;


import model.Menu;
import model.Topping;

public class MenuUI {
    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    private InputValidation inputVal = InputValidation.getInstance();
    private Menu menu;

    //--------------//
    // CONSTRUCTERS //
    //--------------//
    MenuUI(Menu menu) {
        this.menu = menu;
    }

    //----------------//
    // METHODS - SHOW //
    //----------------//
    void showPizzaMenuDialog() {
        boolean exit = false;
        StringBuilder pizzaer = new StringBuilder();
        int selection;

        do {
            System.out.println("Mario's Pizzaria - Pizza Menu");
            System.out.println("-------------------------");

            //Prints all pizzas with name and price
            for (int i = 1; i <= menu.getNumberOfPizzas(); i++) {
                pizzaer.append(i).append(". ").append(this.menu.getPizza(i).getName()).append("\t ").append(menu.getPizza(i).getTotalPizzaPrice()).append(" Kr.\n");
                pizzaer.append("\tToppings:\t");
                int j = 1;
                //Prints all toppings
                for (Topping topping : menu.getPizza(i).getAllToppingsOnPizza()) {
                    pizzaer.append(topping.getToppingName());
                    //Adds comma if not the last
                    if (j < menu.getPizza(i).getAllToppingsOnPizza().size()) {
                        pizzaer.append(", ");
                    }
                    j++;
                }

                pizzaer.append("\n");
            }
            System.out.println(pizzaer);
            System.out.println("-------------------------");
            System.out.println("1. - Tilbage til hovedmenu");
            System.out.println("2. - Lav ny order");

            selection = inputVal.getUserInput();

            if (selection != -1) {
                switch (selection) {
                    case 1:
                        //Gå tilbage til hoved menuen
                        exit = true;
                        break;
                    case 2:
                        //lav ny ordre
                        //newOrderUI.makeNewOrderDialog();
                        break;
                    default:
                        System.err.println(selection + " Er ikke en mulighed i menuen 'PizzaMenu', prøv igen");
                }
            }
        } while (!exit);

    }
}
