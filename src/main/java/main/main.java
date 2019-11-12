
package main;

import model.System;
import datasource.DataSource;
import factory.DataSources;
import factory.DataSourceFactory;
/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class main {
    public static void main(String[] args) {
        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        DataSource dataSource = dataSourceFactory.getDataSource(DataSources.DATABASE);
        
        System system = new System(dataSource);
    }
}
