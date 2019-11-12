
package main;

import model.System;
import datasource.DataSource;
import factory.DataSources;
import factory.DataSourceFactory;
import ui.UI;
import ui.MainUI;
/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class main {
    public static void main(String[] args) {
        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        DataSource dataSource = dataSourceFactory.getDataSource(DataSources.DATABASE);
        UI ui = new MainUI();
        System system = new System(dataSource, ui);
    }
}
