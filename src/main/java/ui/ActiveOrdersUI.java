package ui;

import model.Order;
import model.OrderList;
import model.Pizza;
import model.Topping;


public class ActiveOrdersUI {

    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    private InputValidation inputVal = InputValidation.getInstance();
    private OrderList orderlist;
    private NewOrderUI newOrderUI;

    //--------------//
    // CONSTRUCTERS //
    //--------------//
    private ActiveOrdersUI(OrderList orderlist,NewOrderUI newOrderUI) {
        this.orderlist = orderlist;
        this.newOrderUI = newOrderUI;
    }

    //---------//
    // GETTERS //
    //---------//
    private int getOrderNumber() {
        int orderNumber;
        boolean correctNumber;
        do {
            orderNumber = inputVal.getUserInput();
            if (orderNumber > 0 && orderNumber < orderlist.getOrdersListSize() + 1) {
                //is a valid number
                correctNumber = true;
            } else {
                //Is not a valid order number
                correctNumber = false;
                System.out.println(orderNumber + " er ikke mellem 1 og antallet af ordre (" + orderlist.getOrdersListSize() + ")");
            }

            //Keeps going until correct answer
        } while (!correctNumber);
        return orderNumber;
    }

    //----------------//
    // METHODS - SHOW //
    //----------------//
    void showActiveOrdersDialog() {
        boolean exit = false;
        int selection;

        do {
            System.out.println("Mario's Pizzaria - Aktive Ordre");
            System.out.println("-------------------------");
            showAllCurrentOrders();
            System.out.println("-------------------------");
            System.out.println("1. - Tilbage til hovedmenu");
            System.out.println("2. - Lav ny order");
            if (orderlist.getOrdersListSize() > 0) {
                System.out.println("3. - Fjern en ordre");
            }
            if (orderlist.getOrdersListSize() > 0) {
                System.out.println("4. - Se en ordre");
            }
            if (orderlist.getOrdersListSize() > 0) {
                System.out.println("5. - Færdiggør en ordre");
            }
            selection = inputVal.getUserInput();

            if (selection != -1) {
                switch (selection) {
                    case 1:
                        //Back to main
                        exit = true;
                        break;
                    case 2:
                        //Make new order
                        newOrderUI.makeNewOrderDialog();
                        break;
                    case 3:
                        //Remove rder
                        if (orderlist.getOrdersListSize() > 0) {
                            deleteOrderDialog();
                        } else {
                            System.err.println(selection + " Er ikke en mulighed i menuen 'Aktive Ordre', prøv igen");
                        }
                        break;
                    case 4:
                        //See order
                        if (orderlist.getOrdersListSize() > 0) {
                            showOrderDialog();
                        } else {
                            System.err.println(selection + " Er ikke en mulighed i menuen 'Aktive Ordre', prøv igen");
                        }
                        break;
                    case 5:
                        //Complete Order
                        if (orderlist.getOrdersListSize() > 0) {
                            completeOrderDialog();
                        } else {
                            System.err.println(selection + " Er ikke en mulighed i menuen 'Aktive Ordre', prøv igen");
                        }
                        break;

                    default:
                        //Error in input
                        System.err.println(selection + " fejl i dit input til menuen 'Aktive Ordre', prøv igen");
                }
            }
        } while (!exit);
    }

    private void showOrderDialog() {
        boolean exit = false;
        int orderNumber;
        int selection;
        do {
            System.out.println("Mario's Pizzaria - Order");
            System.out.println("-------------------------");
            showAllCurrentOrders();
            System.out.println("-------------------------");
            System.out.println("Indtast ordre nummeret på ordren du vil se");

            orderNumber = getOrderNumber();

            //Prints the order
            System.out.println("Mario's Pizzaria - Order " + orderNumber);
            System.out.println("-------------------------");
            showOrder(orderNumber);
            System.out.println("-------------------------");
            System.out.println("1 - For at gå tilbage");
            System.out.println("2 - Se anden ordre");
            System.out.println("3 - Tilføj pizza til ordre");
            System.out.println("4 - Færdigør ordre");
            System.out.println("5 - Marker ordre som gået tabt");
            if (orderlist.getOrder(orderNumber).getAmountOfPizzasOnOrder() > 1) {
                System.out.println("6 - Fjern pizza fra ordre");
            }

            selection = inputVal.getUserInput();

            switch (selection) {
                case 1:
                    //Go back
                    exit = true;
                    break;
                case 2:
                    //See other order
                    break;
                case 3:
                    //Add pizza to order
                    newOrderUI.addPizzaDialog(orderNumber);
                    exit = true;
                    break;
                case 4:
                    //Complete Order
                    completeOrder(orderNumber);
                    exit = true;
                    break;
                case 5:
                    //Mark order as lost
                    completeOrder(orderNumber, true);
                    exit = true;
                    break;
                case 6:
                    //Remove pizza from order
                    if (orderlist.getOrder(orderNumber).getAmountOfPizzasOnOrder() > 1) {
                        deletePizzaFromOrderDialog(orderNumber);
                        exit = true;
                    } else {
                        System.err.println(selection + " Er ikke en mulighed, prøv igen");
                    }
                    break;

                default:
                    System.err.println(selection + " Er ikke en mulighed, prøv igen");
            }

        } while (!exit);
    }
    
    
    private void showAllCurrentOrders() {
        int counter = 1;
        StringBuilder ordersInString = new StringBuilder();
        
        //Builds a string with each order, if there are 1 or more orders
        if (orderlist.getOrdersListSize() > 0) {
            for (Order order : orderlist.getActiveOrders()) {
                ordersInString.append("Order Nr. ").append(counter).append(". ");
                ordersInString.append("Antal pizzaer: ").append(order.getAmountOfPizzasOnOrder()).append("\n");
                ordersInString.append("Afhentnings tidspunkt: ").append(order.getPickupTimeHour()).append(":").append(order.getPickupTimeMinute());
                ordersInString.append(", Total Pris: ").append(order.getTotalPrice());
                if (orderlist.getOrdersListSize() != counter) {
                    ordersInString.append("\n-----\n");
                }
                counter++;
            }
        } else {
            ordersInString = new StringBuilder("Der er ikke oprettet en ordre endnu");
        }
        System.out.println(ordersInString);
    }

    private void showAllPizzasInOrder(int index) {
        StringBuilder stringOrder = new StringBuilder();
        int counter = 1;
        //Builds a string with each pizza in order
        for (Pizza pizza : orderlist.getAllPizzasInOrder(index)) {
            stringOrder.append(counter).append(". ").append(pizza.getPizzaName()).append(" -- ");

            counter++;

            //Adds price
            stringOrder.append("\t").append(pizza.getTotalPizzaPrice()).append(" kr.");

            //Checks if any toppings are added
            if (!pizza.getAllToppingsOnPizza().isEmpty()) {
                //Adds the toppings
                stringOrder.append("\nEkstra Toppings: ");
                for (Topping extraTopping : pizza.getAllToppingsOnPizza()) {
                    //For each topping name
                    stringOrder.append(" ").append(extraTopping.getToppingName());

                    //If there is more than 1 topping add ,
                    if (pizza.getAllToppingsOnPizza().size() > 1) {
                        stringOrder.append(", ");
                    }
                }

            }
            //Adds unless its the lastline
            if (orderlist.getOrder(index).getAmountOfPizzasOnOrder() >= counter) {
                stringOrder.append("\n-----\n");
            }
        }
        //Prints it all
        System.out.println(stringOrder);
    }

    private void showOrder(int index) {
        if (orderlist.getOrdersListSize() > 0) {
            printOrder(index);
        } else {
            System.out.println("Der er ikke oprettet en ordre endnu");
        }
    }

    //-------------------//
    // METHODS - Dialogs //
    //-------------------//
    private void deleteOrderDialog() {
        boolean correctNumber;
        int orderNumber;
        do {
            System.out.println("Mario's Pizzaria - Fjern Ordre");
            System.out.println("-------------------------");
            showAllCurrentOrders();
            System.out.println("-------------------------");
            System.out.println("Indtast ordre nummeret på ordren du vil fjerne");

            orderNumber = inputVal.getUserInput();
            if (orderNumber > 0 && orderNumber < orderlist.getOrdersListSize() + 1) {
                //correct order number
                correctNumber = true;
            } else {
                //wrong number
                correctNumber = false;
                System.out.println(orderNumber + " er ikke mellem 1 og antallet af ordre (" + orderlist.getOrdersListSize() + ")");
            }

            //Keeps going until correct
        } while (!correctNumber);

        //Removes the order
        orderlist.deleteOrder(orderNumber);
    }

    private void deletePizzaFromOrderDialog(int orderNumber) {
        boolean correctNumber;
        int pizzaNumber;

        do {
            System.out.println("Mario's Pizzaria - Fjern Pizza fra Ordre");
            System.out.println("-------------------------");
            showAllPizzasInOrder(orderNumber);
            System.out.println("-------------------------");
            System.out.println("Indtast nummeret ud for pizzaen du vil fjerne fra orderen");

            pizzaNumber = inputVal.getUserInput();
            if (pizzaNumber > 0 && pizzaNumber < orderlist.getPizzaCountOnOrder(orderNumber) + 1) {
                //correct pizza number
                correctNumber = true;
            } else {
                //wrong pizza number
                correctNumber = false;
                System.out.println(pizzaNumber + " er ikke mellem 1 og antallet af ordre (" + orderlist.getOrdersListSize() + ")");
            }

            //Keeps going until correct
        } while (!correctNumber);

        //Removes the pizza from the order
        orderlist.deletePizzaFromOrder(orderNumber, pizzaNumber);
    }

    private void completeOrderDialog() {
        System.out.println("Mario's Pizzaria - Færdiggør en ordre");
        System.out.println("-------------------------");
        showAllCurrentOrders();
        System.out.println("-------------------------");
        System.out.println("Indtast ordre nummeret på ordren du vil færdiggøre");

        //Completes the order
        orderlist.completeOrder(getOrderNumber());
    }

    private void printOrder(int index) {
        int counter = 1;
        StringBuilder stringOrder = new StringBuilder();
        //If name exits add to string
        if (orderlist.getCustomerName(index) != null) {
            stringOrder.append("Kunde Navn: ").append(orderlist.getCustomerName(index)).append("\n");
        }
        //If phone number exits add to string
        if (orderlist.isOrderedByPhone(index)) {
            stringOrder.append("Kunde Tlf: ").append(orderlist.getCustomerPhone(index)).append("\n");
        }
        stringOrder.append("-----\n");
        //Adds all the information from pizza to string
        for (Pizza pizza : orderlist.getAllPizzasInOrder(index)) {
            stringOrder.append(counter).append(". ").append(pizza.getPizzaName()).append(" -- ").append(pizza.getPizzaSizeString());

            counter++;

            //Adds the price
            stringOrder.append("\t").append(pizza.getTotalPizzaPrice()).append(" kr.");

            //Check if toppings exit
            if (!pizza.getAllToppingsOnPizza().isEmpty()) {
                //Adds the extra toppings
                stringOrder.append("\nToppings: ");
                for (Topping Topping : pizza.getAllToppingsOnPizza()) {
                    //For each topping add count and name
                    stringOrder.append(" ").append(Topping.getToppingName());

                    //If more than one topping add ,
                    if (pizza.getAllToppingsOnPizza().size() > 1) {
                        stringOrder.append(", ");
                    }
                }

            }
            stringOrder.append("\n-----\n");
        }
        stringOrder.append("Afhentnings tidspunkt: ").append(orderlist.getPickUpTimeHour(index)).append(":").append(orderlist.getPickUpTimeMinute(index)).append(" ").append("\nTotal Pris: ").append(orderlist.getTotalPrice(index));
        System.out.println(stringOrder);
    }

    //---------//
    // METHODS //
    //---------//
    private void completeOrder(int orderNumber) {
        orderlist.completeOrder(orderNumber);
    }

    private void completeOrder(int orderNumber, boolean lostOrder) {
        orderlist.completeOrder(orderNumber - 1, lostOrder);
    }
}
