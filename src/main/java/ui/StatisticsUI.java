
package ui;

public class StatisticsUI {

    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    private InputValidation inputVal = InputValidation.getInstance();
    //--------------//
    // CONSTRUCTORS //
    //--------------//
    private StatisticsUI(){
        
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
            
            
            System.out.println("-------------------------");

            System.out.println(statistic.getStatistics() + "\n");
            System.out.println("1 - Se statestik på pizzaer");
            System.out.println("2 - Søg på en kunde");

            selection = inputVal.getUserInput();
            if (selection == 1) {  //Go back
                exit = true;
            } else {
                System.err.println(selection + " Er ikke en mulighed prøv igen");
            }
        } while (!exit);
    }
}
