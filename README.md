How to setup first mvc project:

1. create maven project in eclipes:

File-->New --> other --> Maven Project
2. Go to Next --> Next--> New pop up window will appear with name "New Maven Project" --> Select an Archtype

it should be "maven-archtype-webapp"

then click on Next

Put the Group Id: com.test.mvc
		artifact Id : my-mvc-project
		version: 0.0.1-SNAPSHOT
		package: com.test.mvc
		
Here the group id, artifact id, version and package name could be anything based on your choice


3. open pom.xml

put the dependency of following required jars:
<artifactId>spring-webmvc</artifactId>
<artifactId>spring-orm</artifactId>
<artifactId>hibernate-core</artifactId>
<artifactId>hibernate-validator</artifactId>
<artifactId>javax.servlet-api</artifactId>
<artifactId>jstl-api</artifactId>

tag
taglibs
			<artifactId>standard</artifactId>	
<artifactId>javax.servlet.jsp-api</artifactId>
<artifactId>mysql-connector-java</artifactId>	

how to find dependency of maven project:

open the following url:

https://mvnrepository.com/

and search for the above dependency
and put it into the pom.xml

4. Create 3 config classes:


1st class like below:

package com.test.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[] { HibernateConfig.class };
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] { WebMvcConfig.class };
   }

   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }
}
 
2nd class like below:

package com.test.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.test.mvc")})
public class HibernateConfig {

	@Autowired
	private ApplicationContext context;

}


package com.test.mvc.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.test.mvc"})
public class WebMvcConfig implements WebMvcConfigurer {

   @Bean
   public InternalResourceViewResolver resolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setViewClass(JstlView.class);
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }

   @Bean
   public MessageSource messageSource() {
      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
      source.setBasename("messages");
      return source;
   }
}


5. Create controller class:

package com.test.mvc.controller;

import org.springframework.stereotype.Controller;

@Controller
public class WelcomeController {

	public String helloWorld() {
		return "hello";
	}
}

6. create views directory under WEB-INF directory
right click on WEB-INF --> New Folder--> put folder name views

7.
create a jsp with name hello.jsp in views directory created in step 6 like below:

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World Example</title>
</head>
<body>Hello World!
</body>
</html>


7. Right click on project you created in step 1 --> Build Path --> Go to libraries tab --> edit the JRE System Library --> change the jdk it should be jdk 1.8

9. build the projcet again
mvn clean install from command prompt or
right click on project --> Run As maven build --> clean install

10. run the project
right click on project --> Run on server --> Manually define new server  --> Select appropriate tomcat (e.g Tomcat v9.0 Server)--> Click on Next --> Provide tomcat installation directory:

like below:

F:\apache-tomcat-7.0.25-windows-x64\apache-tomcat-7.0.25
select appropriate JRE


then click on Next --> Finish

A browser will open in eclipse and the result will be displayed.


		
		
		example of pom.xml is:
		
		<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.test.spring.mvc</groupId>
	<artifactId>my-mvc-proj</artifactId>
	<packaging>war</packaging>
	<version>0.0.1-SNAPSHOT</version>
	<name>my-mvc-proj Maven Webapp</name>
	<url>http://maven.apache.org</url>
	<dependencies>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>5.0.2.RELEASE</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-orm -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-orm</artifactId>
			<version>5.0.2.RELEASE</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-core -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.2.12.Final</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator -->
		<dependency>
			<groupId>org.hibernate.validator</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>6.0.7.Final</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>4.0.0</version>
			<scope>provided</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/javax.servlet.jsp.jstl/jstl-api -->
		<dependency>
			<groupId>javax.servlet.jsp.jstl</groupId>
			<artifactId>jstl-api</artifactId>
			<version>1.2</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/taglibs/standard -->
		<dependency>
			<groupId>taglibs</groupId>
			<artifactId>standard</artifactId>
			<version>1.1.2</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/javax.servlet.jsp/javax.servlet.jsp-api -->
		<dependency>
			<groupId>javax.servlet.jsp</groupId>
			<artifactId>javax.servlet.jsp-api</artifactId>
			<version>2.3.1</version>
			<scope>provided</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>6.0.6</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/commons-dbcp/commons-dbcp -->
		<dependency>
			<groupId>commons-dbcp</groupId>
			<artifactId>commons-dbcp</artifactId>
			<version>1.4</version>
		</dependency>

	</dependencies>
	<build>
		<finalName>my-mvc-proj</finalName>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.5.1</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>
