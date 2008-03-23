/*
 * 
 *
 * Author: Intesar Shannan Mohammed
 *
 * Copyright 2008 Abbhsoft. All Rights Reserved.
 *
 * This software is the proprietary information of Abbhsoft.
 * Use is subject to license terms.
 *
 */
package com.abbhsoft.jpadaoframework.dao;

import java.io.Serializable;

/**
 * The GenericDao interface with CRUD methods. Finders are added with interface inheritance and AOP
 * introductions for concrete implementations.
 * 
 * Extended interfaces may declare methods starting with find..., list..., iterate... or scroll...
 * They will execute a preconfigured query that is looked up based on the rest of the method name.
 * 
 *  Getting Started!
 *  
 *  this frameworks encapsulates Spring JPA and gives some more features.
 *  it is expected that user of this framework doesn't have to know spring jpa
 *  GenericDao interface is at the heart of this framework. To use this framework
 *  you have to know only these four interfaces and classes
 *  
 *  1. GenericDao (inteface)
 *  2. PagedResult (class)
 *  3. PaginParams (class)
 *  4. BaseModel (abstract class)
 * 
 *  steps configuring and using JpaDaoFramework
 *  1. Add this framework to your project classpath 
 *  2. Name persistence unit as "JpaDaoFrameworkPeristenceUnit"
 *  3. Using this framework, this framework will help in reducing lot of data access
 *     logic in dao layer and it provides many services out of the box like pagination
 *     executing namedQuery, return custom object or list etc
 *  4. suppose we have a User.java as a jpa entity and we are interested in creating
 *    data access object for this to do so.
 *  5. create an UserDao interface which extends GenericDao<User, Integer>
 *    pass entity and its primary key to it
 *  6. by doing this we get the CRUD functionality for UserDao by default
 *    if we like to add new NamedQueries that should be very simple created
 *    a namedQuery in User entity 
 *    for example NamedQuery(name="User.findByLastname" query="")
 *  7. to use this query just write a method in UserDao as
 *     public List<User> findByLastname(String lastname);
 *     or if we know this query will return singe object
 *     public User findByLastname(String lastname);
 *     or if we want to narrow results
 *     public List<User> findByLastname(String lastname, PagingParams... params);
 *     or 
 *     public PagedResult findByLastname(String lastname, PaginParams... params);
 *     or
 *     public PagedResult findByLastname(String lastname, PaginParams... params);
 * 
 *    if we look at all the different ways of executing this query its owesome
 *    framework will handle every thing pagination returning different types of data etc.
 *   no need to anythig just create a bean for this interface and you can inject it 
 *   into any other bean or service bean as if ur injecting its implementation
 *  
 *  <bean id="userDao" parent="abstractDao">
<property name="proxyInterfaces">
<value>com.UserDao</value>
</property>
<property name="target">
<bean parent="abstractDaoTarget">
<constructor-arg>
<value>com.User</value>
</constructor-arg>
</bean>
</property>
</bean>
 * 
 *  if you see the above bean its very simple if you create new dao's just copy and
 *  paste this bean decleration and change three things id, dao and entity names
 *  and ur good to go
 * 
 *  if this documentation doesn't looks good and if you need more help using this
 *  framework please feel free to email me at
 *  mdshananan@gmail.com
 * 
 *  
 * 
 * @param T entity
 * @param PK entity primary key
 * 
 */
public interface GenericDao<T, PK extends Serializable> {

    /**
     * creates a new instance in the database
     * @param newInstance
     * @return
     */
    PK create(T newInstance);

    /**
     * merges the new state to the database
     * @param transientObject
     */
    void update(T transientObject);

    /**
     * removes the instance from the database
     * @param persistentObject
     */
    void delete(T persistentObject);

    /**
     * finds the instance by primary key id
     * @param id
     * @return
     */
    T read(PK id);

    /**
     * finds all records 
     * @param pagingParams defines the limit
     * @return
     */
    PagedResult<T> findAll(PagingParams... pagingParams);
}
