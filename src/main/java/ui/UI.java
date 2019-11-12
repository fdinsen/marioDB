
package ui;

import model.Controller;
import model.Menu;
import model.OrderList;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public interface UI {
    public void startUI(Controller controller,Menu menu, OrderList orderlist);
}
