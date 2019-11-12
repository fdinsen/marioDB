package ui;

import model.Controller;
import model.Menu;
import model.OrderList;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class MainUI implements UI {
    private Controller controller;
    private Menu menu;
    private OrderList orderlist;
    
    public void startUI(Controller controller,Menu menu, OrderList orderlist) {
        this.controller = controller;
        this.menu = menu;
        this.orderlist = orderlist;
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
            System.out.println("4 - Statistik");
            System.out.println("55 - Afslut program");

            selection = inputVal.getUserInput();
            if (selection != -1) {
                switch (selection) {
                    case 1:
                        //Vis menuen
                        MenuUI menuUI = new MenuUI(menu);
                        menuUI.showPizzaMenuDialog();

                        break;
                    case 2:
                        //Viser aktive ordre
                       // activeOrdersUI.showActiveOrdersDialog();
                        break;
                    case 3:
                        //Lav ny ordre
                        //newOrderUI_Instance.makeNewOrderDialog();
                        break;
                    case 4:
                        //Viser staistik
                        //statisticsUI.statisticsDialog();
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
