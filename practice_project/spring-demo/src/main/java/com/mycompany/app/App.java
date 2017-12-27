package com.mycompany.app;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
    }
}
