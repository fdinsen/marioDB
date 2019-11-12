/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import datasource.DataSource;
import factory.DataSourceFactory;
import factory.DataSources;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author olvvang
 */
public class MenuTest {
    
    public MenuTest() {
    }

    @Test
    public void menuConstructerNumberOfPizzasTest(){
        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        DataSource dataSource = dataSourceFactory.getDataSource(DataSources.DATABASE);
        Menu menu = new model.Menu(dataSource);
        int expectedLength = 30;
        int actualLength = menu.getNumberOfPizzas();
        assertEquals(expectedLength, actualLength);
    }
    
    @Test
    public void menuSetDefaultToppingsTest(){
        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        DataSource dataSource = dataSourceFactory.getDataSource(DataSources.DATABASE);
        Menu menu = new model.Menu(dataSource);
        String actualName = menu.getPizza(1).getTopping(0).getToppingName();
        java.lang.System.out.println(actualName);
        String ExpectedName = "Mozzarella";
        assertEquals(ExpectedName, actualName);
    }
    
}
