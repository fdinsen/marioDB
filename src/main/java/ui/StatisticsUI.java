package ui;

import model.IndividualStatistics;
import model.Statistics;

public class StatisticsUI {

    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    private InputValidation inputVal = InputValidation.getInstance();
    private Statistics statistics;

    //--------------//
    // CONSTRUCTORS //
    //--------------//
    StatisticsUI(Statistics statistics) {
        this.statistics = statistics;
    }

    //------------------//
    // METHODS - DIALOGS//
    //------------------//
    void statisticsDialog() {
        boolean exit = false;
        int selection;
        do {
            System.out.println("Mario's Pizzaria - Statistik");
            System.out.println("-------------------------");
            System.err.println("Antal ordre: " + statistics.getAmountOfOrders().getSalesNumber());
            System.err.println("Total Omsætning: " + statistics.getTotalTurnover().getPrice() + " kr.");
            System.err.println("Gennemsnitlig ordre: " + statistics.getAverageOrderPrice().getPrice() + " kr.");
            System.err.println("Top solgte pizza: " + statistics.getTopSellingPizza().getPizzaName());
            System.err.println("Mindst solgte pizza: " + statistics.getBottomSellingPizza().getPizzaName());
            System.out.println("-------------------------");
            System.out.println("1 - Se statestik på pizzaer");
            System.out.println("2 - Søg på en kunde");
            System.out.println("3 - Gå tilbage");

            selection = inputVal.getUserInput();
            if (selection == 1) {
                printAllPizzasStatistics();
            } else if (selection == 2) {
                searchCustomer();
            } else if (selection == 3) {
                exit = true;
            } else {
                System.err.println(selection + " Er ikke en mulighed prøv igen");
            }
        } while (!exit);
    }

    void printAllPizzasStatistics() {
        boolean exit = false;
        int selection;
        int counter = 0;
        do {
            System.out.println("Mario's Pizzaria - Statistik - Pizzaer");
            System.out.println("-------------------------");
            for (IndividualStatistics indivStat : statistics.getAllPizzaSales()) {
                counter++;
                System.out.println(counter + ". " + indivStat.getPizzaName() + " x" + indivStat.getSalesNumber());
            }
            System.out.println("-------------------------");
            System.out.println("1 - Tilbage");

            selection = inputVal.getUserInput();
            if (selection == 1) {  //Go back
                exit = true;
            } else {
                System.err.println(selection + " Er ikke en mulighed prøv igen");
            }
        } while (!exit);
    }

    private void searchCustomer() {
        boolean exit = false;
        boolean exit1 = false;
        int selection;
        int counter = 0;
        int userInput = 0;
        System.out.println("Mario's Pizzaria - Statistik - Kunde");
        System.out.println("-------------------------");
        do {
            System.out.println("Indtast telefon nr. på kunden");
            System.out.println("1 - Gå tilbage");
            selection = inputVal.getUserInput();
            if (selection == 1) {  //Go back
                exit = true;
            } else if (inputVal.isValidPhoneNumber(selection)) {
                //true
                if (!statistics.getCustomerOrders(selection).isEmpty()) {
                    //not empty
                    do {
                        for (IndividualStatistics indivStat : statistics.getCustomerOrders(selection)) {
                            counter++;
                            System.out.println(counter + indivStat.getPizzaName() + "\n\t" + indivStat.getOrderTime() + " - " + indivStat.getPrice() + " kr.");
                            System.out.println("\t Toppings: " + indivStat.getToppingsString());

                        }

                        System.out.println("1 - gå tilbage");
                        userInput = inputVal.getUserInput();

                        if (userInput == 1) {
                            //Exit
                            exit1 = true;
                            exit = true;
                        }
                        //Wrong user info
                    } while (!exit1);
                } else {
                    //empty
                    System.out.println(selection + " kunne ikke findes");
                }
            } else {
                System.err.println(selection + " Er ikke et korrekt telefon nr. eller forkert input\n");
            }
        } while (!exit);
    }
}
