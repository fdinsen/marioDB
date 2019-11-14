package ui;

import model.IndividualStatistics;
import model.Statistics;

public class StatisticsUI {

    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    private InputValidation inputVal = InputValidation.getInstance();
    private Statistics statistics;
    private IndividualStatistics individualStatistics;

    //--------------//
    // CONSTRUCTORS //
    //--------------//
    private StatisticsUI(Statistics statistics, IndividualStatistics individualStatistics) {
        this.statistics = statistics;
        this.individualStatistics = individualStatistics;
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
            for (IndividualStatistics indivStat : statistics.getAllPizzaStatistics()) {
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
        int selection;
        int counter = 0;
        do {
            System.out.println("Mario's Pizzaria - Statistik - Kunde");
            System.out.println("-------------------------");
            System.out.println("Indtast telefon nr. på kunden");
            System.out.println("1 - Gå tilbage");
            selection = inputVal.getUserInput();
            if (selection == 1) {  //Go back
                exit = true;
            } else if(inputVal.isValidPhoneNumber(selection)){
                //true
                if(!statistics.getCustomerOrders().isEmpty()){
                    //not empty
                    for(IndividualStatistics indivStat: statistics.getCustomerOrders()){
                        System.out.println(indivStat.getPizzaName());
                    }
                }else{
                    //empty
                }
            }else{
                System.err.println(selection + "Er ikke et korrekt telefon nr. eller forkert input");
            }
        } while (!exit);
    }
}
