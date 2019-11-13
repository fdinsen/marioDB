package ui;

import model.*;

public class NewOrderUI {

    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    private InputValidation inputVal = InputValidation.getInstance();
    private OrderList orderlist;
    private Menu menu;
    private Controller controller;

    //--------------//
    // CONSTRUCTORS //
    //--------------//
    NewOrderUI(Menu menu, OrderList orderlist, Controller controller) {
        this.menu = menu;
        this.orderlist = orderlist;
        this.controller = controller;
    }

    //------------------//
    // METHODS - DIALOGS//
    //------------------//
    void makeNewOrderDialog() {
        int phoneNumber;
        boolean exit = false;
        int selection;
        int orderArrayPosition;
        Customer customer;
        do {
            System.out.println("Mario's Pizzaria - Ny Ordre");
            System.out.println("-------------------------");
            System.out.println("Er denne ordre bestilt over telefonen?");
            System.out.println("1. - Ja");
            System.out.println("2. - Nej");
            System.out.println("3. - Annuller oprettelse af ordre");

            selection = inputVal.getUserInput();

            if (selection != -1) {
                switch (selection) {
                    case 1:
                        //Ordered bu phone
                        phoneNumber = makeNewOrderByTelehoneDialog();
                        if(controller.checkIfCustomerExists()){
                            customer = controller.getCustomer(phoneNumber);
                        }else{
                            customer = controller.createCustomer(phoneNumber);
                        }
                        orderArrayPosition = orderlist.createOrder(customer);
                        
                        addNameDialog(orderArrayPosition);
                        addPizzaDialog(orderArrayPosition);
                        exit = true;
                        break;
                    case 2:
                        //Not ordered by phone
                        phoneNumber = 00000000;
                        customer = controller.getCustomer(phoneNumber);
                        orderArrayPosition = orderlist.createOrder(customer);
                        
                        addNameDialog(orderArrayPosition);
                        addPizzaDialog(orderArrayPosition);
                        exit = true;
                        break;
                    case 3:
                        //Cancel order making
                        exit = true;
                        break;
                    default:
                        System.err.println(selection + " Er ikke en mulighed for valg af telefon eller ej, prøv igen");
                }
            }
        } while (!exit);
    }

    private int makeNewOrderByTelehoneDialog() {
        int input;

        System.out.println("Mario's Pizzaria - Ny Ordre");
        System.out.println("-------------------------");
        System.out.println("Indtast telefon nr.");

        //Keeps going until correct phone number
        do {
            input = inputVal.getUserInput();
        } while (!inputVal.isValidPhoneNumber(input));

        //Returns the phone number
        return input;

    }

    private void addNameDialog(int orderArrayPosition) {
        boolean exit = false;
        int selection;
        do {
            System.out.println("Vil du tilføje navn til ordren?");
            System.out.println("1. - Ja");
            System.out.println("2. - Nej");

            selection = inputVal.getUserInput();

            switch (selection) {
                case 1:
                    //Add name
                    orderlist.getOrder(orderArrayPosition).setCustomerName(inputVal.getValidName());
                    exit = true;
                    break;
                case 2:
                    //No name
                    exit = true;
                    break;
                default:
                    System.err.println(selection + " Er ikke en mulighed for at valg af navn eller ej, prøv igen");
            }
        } while (!exit);
    }

    void addPizzaDialog(int orderArrayPosition) {
        boolean addNewSize = true;
        boolean addNewPizza = true;
        boolean addExtras = true;
        boolean addExtraPizzaDialog;
        int pizzaNumber;
        PizzaSize pizzaSize;
        int selection;

        //Outer loop, which is the pizza loop
        do {
            System.out.println("Indtast nummeret på pizzaen der skal tilføjes");
            pizzaNumber = inputVal.getUserInput();

            //Checks the entered pizza number are greater than 0 as well as at no higher than the number of pizzas
            if (pizzaNumber > 0 && pizzaNumber < menu.getAmountOfPizzas() + 1) {

                //Loop for picking pizza size
                do {
                    System.out.println("Vil du vælge størrelse?");
                    System.out.println("1. - Ja");
                    System.out.println("2. - Nej");

                    selection = inputVal.getUserInput();

                    switch (selection) {
                        case 1:
                            //Choose size
                            pizzaSize = chooseSizeDialog();
                            orderlist.getOrder(orderArrayPosition).addPizza(menu.getPizza(selection), pizzaSize);
                            addNewSize = false;
                            break;
                        case 2:
                            //Add pizza to order
                            pizzaSize = PizzaSize.NORMAL;
                            orderlist.getOrder(orderArrayPosition).addPizza(menu.getPizza(selection), pizzaSize);
                            addNewSize = false;
                            break;
                        default:
                            System.err.println(selection + " Er ikke en mulighed for størrelsen");
                            System.out.println("Prøv igen");
                    }

                } while (addNewSize);

                //Loop for toppings
                do {
                    System.out.println("Skal der tilføjes ekstra tilbehør?");
                    System.out.println("1. - Ja");
                    System.out.println("2. - Nej");

                    selection = inputVal.getUserInput();

                    switch (selection) {
                        case 1:
                            //Add topping
                            chooseExtrasDialog(orderArrayPosition);
                            addExtras = false;
                            break;
                        case 2:
                            //No topping
                            addExtras = false;
                            break;
                        default:
                            System.err.println(selection + " Er ikke en mulighed for tilbehør");
                            System.out.println("Prøv igen");
                    }

                } while (addExtras);

                //Loop for adding a new pizza
                do {
                    System.out.println("Tilføj en ekstra Pizza til orderen?");
                    System.out.println("1. - Ja");
                    System.out.println("2. - Nej");

                    selection = inputVal.getUserInput();

                    switch (selection) {
                        case 1:
                            //Add extra pizza
                            addExtraPizzaDialog = false;
                            break;
                        case 2:
                            //No extra pizza, Finish the loops
                            addExtraPizzaDialog = false;
                            addNewPizza = false;

                            break;
                        default:
                            System.err.println(selection + " Er ikke en mulighed for om det skal tilføjes en ny pizza");
                            System.out.println("Prøv igen");
                            addExtraPizzaDialog = true;
                            break;
                    }
                    //Keeps going until user chooses to make new pizza or not
                } while (addExtraPizzaDialog);

            } else {
                //The user has entered a number that is not between 1 and the number of pizzas in the menu
                System.err.println(pizzaNumber + " Er ikke mellem 1 og antallet af pizzaer i menuen (" + menu.getAmountOfPizzas() + ")");
                System.out.println("Prøv igen");
            }

            //If true, add new pizza (TRUE)
            //Otherwise, exit and return to menu (FALSE)
        } while (addNewPizza);
        
        //When all done, insert the order in the database
        controller.createActiveOrder(orderlist.getOrder(orderArrayPosition));
    }

    // Return the size so it can be saved with the order
    private PizzaSize chooseSizeDialog() {
        boolean exit = false;
        int selection;
        PizzaSize Size = PizzaSize.NORMAL;
        do {
            System.out.println("Indtast den ønsket størrelse?");
            System.out.println("1. - Almindelig");
            System.out.println("2. - Familie");
            System.out.println("3. - Deep pan");

            selection = inputVal.getUserInput();

            switch (selection) {
                case 1:
                    //Alm
                    Size = PizzaSize.NORMAL;
                    exit = true;
                    break;
                case 2:
                    //Fam
                    Size = PizzaSize.FAMILY;
                    exit = true;
                    break;
                case 3:
                    //Deep
                    Size = PizzaSize.DEPPAN;
                    exit = true;
                    break;
                default:
                    System.err.println(selection + " Er ikke en mulighed prøv igen");
            }
        } while (!exit);
        return Size;
    }

    private void chooseExtrasDialog(int orderArrayPosition) {
        boolean exit = false;
        boolean extraQuantityCorrect;
        int extraSelection;
        int moreExtraQuantitySelection;
        int counter;
        int pizzaPos;
        //Exit loop
        do {
            //Extraselection loop
            do {
                counter = 1;
                System.out.println("Tilængeligt tilbehør: ");
                for (Topping topping : menu.getAllToppings()) {
                    System.out.println(counter + ". " + topping.getToppingName() + "\t" + topping.getToppingPrice() + " kr.");
                    counter++;
                }
                System.out.println("Indtast nummeret på hvilket tilbehør der skal tilføjes");

                extraSelection = inputVal.getUserInput();

                //Keeps going until user enter a number between 1 and the amount of toppings available
            } while (!(extraSelection > 0 && extraSelection <= menu.getAmountOfToppings()));

            // Grab the pizza position in the order array
            // The pizza has just been added, so we know it's the last place
            pizzaPos = orderlist.getOrder(orderArrayPosition).getAmountOfPizzasOnOrder() - 1;
            orderlist.addExtraTopping(orderArrayPosition,pizzaPos, menu.getTopping(extraSelection));
            
            //More moreExtraQuantitySelection loop
            do {
                System.out.println("Tilføj mere tilbehør?");
                System.out.println("1. - Ja");
                System.out.println("2. - Nej");
                moreExtraQuantitySelection = inputVal.getUserInput();

                switch (moreExtraQuantitySelection) {
                    case 1:
                        //Yes
                        //// Jumps out of switch but not the entire loop
                        exit = false;
                        extraQuantityCorrect = true;
                        break;
                    case 2:
                        //No
                        //// Jumps out of switch and the loop
                        exit = true;
                        extraQuantityCorrect = true;
                        break;
                    default:
                        System.err.println(moreExtraQuantitySelection + " Er ikke en mulighed prøv igen");
                        extraQuantityCorrect = false;

                }

                // Continues until user input is correct
            } while (!extraQuantityCorrect);
        } while (!exit);

    }

}
