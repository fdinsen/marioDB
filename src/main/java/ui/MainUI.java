package ui;

import model.Controller;
import model.IndividualStatistics;
import model.Menu;
import model.OrderList;
import model.Statistics;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class MainUI implements UI {
    private Menu menu;
    private NewOrderUI newOrderUI;
    private ActiveOrdersUI activeOrdersUI;
    private StatisticsUI statisticsUI;
    private Statistics statistics;
    
    public void startUI(Controller controller,Menu menu, OrderList orderlist) {
        this.menu = menu;
        this.newOrderUI = new NewOrderUI(menu, orderlist,controller);
        this.activeOrdersUI = new ActiveOrdersUI(orderlist,newOrderUI);
        this.statistics = new Statistics(controller);
        this.statisticsUI = new StatisticsUI(statistics);
        mainMenuDialog();
    }
    //--------------------//
    // INSTANCE VARIABLES //
    //--------------------//
    private InputValidation inputVal = InputValidation.getInstance();

    //---------//
    // METHODS //
    //---------//
    public void mainMenuDialog() {
        boolean exit = false;

        int selection;

        do {
            System.out.println("Mario's Pizzaria");
            System.out.println("-------------------------");
            System.out.println("1 - Vis Menu");
            System.out.println("2 - Aktive Ordre");
            System.out.println("3 - Ny ordre");
            System.out.println("4 - Færdige ordre");
            System.out.println("55 - Afslut program");

            selection = inputVal.getUserInput();
            if (selection != -1) {
                switch (selection) {
                    case 1:
                        //Vis menuen
                        MenuUI menuUI = new MenuUI(menu,newOrderUI);
                        menuUI.showPizzaMenuDialog();

                        break;
                    case 2:
                        //Viser aktive ordre
                        activeOrdersUI.showActiveOrdersDialog();
                        break;
                    case 3:
                        //Lav ny ordre
                        newOrderUI.makeNewOrderDialog();
                        break;
                    case 4:
                        //Viser staistik
                        statisticsUI.statisticsDialog();
                        break;
                    case 55:
                        //Slutter program
                        exit = true;
                        break;
                    default:
                        System.err.println(selection + " Er ikke en mulighed i menuen 'Hoved Menu', prøv igen");
                }
            }
        } while (!exit);

    }
}
