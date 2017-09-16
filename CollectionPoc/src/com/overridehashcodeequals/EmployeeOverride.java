package com.overridehashcodeequals;
/**
 * Java Program to showing overriding of hashCode() & equals()methods
 */
import java.util.HashMap;

/**
 * Let’s say in an organisation there exists a employee with id=1 and name=’sam’  
 *    and some data is stored corresponding to him, but if modifications have to be made
 *     in data, previous data must be overridden.
 *     If we note output > 
    Earlier, value corresponding to Employee with id=1 and name=’sam’ was employee1 data   
    Later, value corresponding to Employee with id=1 and name=’sam’ was employee1 data  
    OVERRIDDEN 
    
    


 */

public class EmployeeOverride {
    public static void main(String...a){
           
           HashMap<Employee, String> hm=new HashMap<Employee, String>();
           hm.put(new Employee(1,"sam"), "employee1 data");
           hm.put(new Employee(2,"amy"), "employee2 data");
           
           System.out.println("HashMap's data> "+hm);
           System.out.println(hm.get(new Employee(1,"sam")));
           
           hm.put(new Employee(1,"sam"), "employee1 data OVERRIDDEN");
           System.out.println("\nAgain display HashMap after overriding data "+
                        "of Employee with id=1 and name=’sam’\n");
           
           System.out.println("HashMap's data> "+hm);
           System.out.println(hm.get(new Employee(1,"sam")));
           
    }
}
