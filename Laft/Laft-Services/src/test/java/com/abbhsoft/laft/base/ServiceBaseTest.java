/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbhsoft.laft.base;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 *
 * @author Intesar.Mohammed
 * 
 *  ServiceBaseTest loads the Spring container with Readonly transactions and extends the 
 *  JUnit test class
 *  
 *  Any Class which extends the ServiceBaseTest will be a JUnit test class
 *  can get hold of any dao defined in the BaseTest
 *  Executes all the finder and able to test them
 *  The Sub Class can override onSetUpInTransaction() to create few records into the database
 *  which are all inside the read-only transaction 
 * 
 *  
 * 
 * 
 */
public class ServiceBaseTest extends AbstractTransactionalDataSourceSpringContextTests {
    /*
     * 
     *  declare a dao instance and write getters spring will
     *  inject the object at runtime which is transactional (read-only)
     */

    @Override
    protected String[] getConfigLocations() {

        return new String[]{
                    "classpath:ApplicationContext-JpaDaoFramework.xml",
                    "classpath:ApplicationContext-Dao.xml",
                    "classpath:Application-Service.xml",
                    "classpath:ApplicationContext-Transactions.xml"
                };
    }

    public ServiceBaseTest(String testName) {
        super(testName);
    }

    public void test() {
        assertTrue(true);
    }
}

