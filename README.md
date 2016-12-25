# Java Blog System

This project is a demo project of Java blog system developed following the tutorial from www.java1234.com own by XiaoFeng, many thanks.

This project includes technologies list below:

*  Structure : Spring4 + SpringMVC + MyBatis
*  Security framework : Shiro 
*  Open-source search software : Apache Lucene
*  Project management tool : Apache Maven.
*  Online text editor : Baidu Ueditor
*  Database connection pool : Alibaba Druid
*  Database : MySQL database
*  Front-end UI framework: JQuery Easyui



#### Why use SSM?
SpringMVC:
Powerful web MVC framework, more flexible then struts, with springMVC, requests are easily dispatched to controllers and handled by calling functions and with ModelAndView object data models and views are easily returned to front end. Aop is also supported by SpringMVC.

Spring:
Power application framework implements inversion of control container and aop for the Java platform. Spring helps store and manage Java beans and transfers the control from programmer to the framework itself. With aop, those application which handles large amount of object are also easily handled by the framework.

MyBatis:
At the same layer with Hibernate, the difference between then is that Mybatis matches customized requirements more than Hibernate. Customized SQL and help increase the efficiency of accessing database.Manage SQL with xml, easy for debug and optimize.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them
1. Eclipse: Most commonly used IDE
2. Tomcat 8.5: Web container
3. JDK1.8


### Installing
Install steps:
1. Download the project from github
2. Import existing maven project into Eclipse : image1
3. Right click on the project and select ->Run as-> Maven install. Maven will help download all the dependencies, check the pom.xml to learn more. If IDE couldn't find the complier, the problem can be fixed by: Clicking->Project->properties->Java Build Path->Libraries -> add library->JRE System library[JavaSE 1.8]->Apply ->OK.
4. Add Tomcat 8.5 server and add your application named BlogSystemSSM to the server.
5. Find the server on the project panel, go to server.xml change the path="/", so that you can use localhost:8080 as your root url.
```
<Context docBase="BlogSystemSSM" path="/" reloadable="true" source="org.eclipse.jst.jee.server:BlogSystemSSM"/>
```
6. Create a new MySQL database name it db_blog, and use useful.sql to create tables and import test data. SQL will be uploaded later.
7. Configure dataSource with Spring applicationContext.xml file


```
<!-- config dataSource -->
<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
    <property name="url" value="jdbc:mysql://localhost:3306/db_blog?useUnicode=true&amp;characterEncoding=UTF-8"/>
    <property name="username" value="[your data base username]"/>
    <property name="password" value="[your data base password]"/>
</bean>
```
