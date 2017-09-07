1)What is an **Exception** ?

-->**Exceptions** are the objects representing logical errors that occur at **Run Time** and makes JVM enters into the state of **"Ambiguity"**. 

2)What are Error?

-->An **Error** is a subclass of **Throwable** that indicates serious problems that a resonable appl. should not try to catch.In most of the cases Errors are not caused by our programs & these are due to **Lack of System Resources**. for Ex.OutOfMemoryError,happens when JVM runs out of Memory.

3)**How are the Exceptions Handled in Java?**

-->Exceptions are handled using try,catch & finally Blocks.


**try block**- risky code should be in written in try block or the set of statements which are monitored for exception.

**catch block**-This block catches the exceptions occurred in the try block.

**finally block**- This block is always executed,whether the exception occured in try block or not,whether it is caught in catch block or not.We generally maintain clean up code in finally block.

4)**Can we keep other statements in between try, catch and finally blocks?**

-->No. We shouldn’t write any other statements in between try, catch and finally blocks. They form a one unit.

**try**
{

    // Statements to be monitored for exceptions
}
  
//**You can't keep statements here**
  
catch(Exception ex)
{

    //Cathcing the exceptions here
}
  
//**You can't keep statements here**
  
finally
{

    // This block is always executed
}

5)**Can we write only try block without catch and finally blocks?**

-->No, It shows compilation error. The try block must be followed by either catch or finally block. You can remove either catch block or finally block but not both.

6)**There are three statements in a try block – statement1, statement2 and statement3. After that there is a catch block to catch the exceptions occurred in the try block. Assume that exception has occurred in statement2. Does statement3 get executed or not?**

-->No. Once a try block throws an exception, remaining statements will not be executed. control comes directly to catch block.

7)**What is unreachable catch block error?**

-->When you are keeping multiple catch blocks, the order of catch blocks must be from most specific to most general ones. i.e sub classes of Exception must come first and super classes later. If you keep super classes first and sub classes later, compiler will show unreachable catch block error.


**public class** ExceptionHandling

{


    public static void main(String[] args)
    {
        try
        {
            int i = Integer.parseInt("abc"); 
                        //This statement throws NumberFormatException
        }
  
        catch(Exception ex)
        {
            System.out.println("This block handles all exception types");
        }
  
        catch(NumberFormatException ex)
        {
            //Compile time error
            //This block becomes unreachable as
            //exception is already caught by above catch block
        }
    }
}

8)**what are checked and unchecked exceptions in java?**

-->Checked exceptions are checked at compile-time. It means if a method is throwing a checked exception then it should handle the exception using **try-catch** block or it should declare the exception using **throws** keyword, otherwise the program will give a compilation error.ex:**FileNotFoundException,IOException,ClassNotFoundException, SQLException**.


Unchecked exceptions are those exceptions which are not at all known to compiler. These exceptions occur only at run time. These exceptions are also called as run time exceptions. All sub classes of java.lang.RunTimeException and java.lang.Error are unchecked exceptions. Ex.**NullPointerException, ArrayIndexOutOfBoundsException, NumberFormatException**


9)**Can we keep the statements after finally block If the control is returning from the finally block itself?**

-->No, it gives unreachable code error. Because, control is returning from the finally block itself. Compiler will not see the statements after it. That’s why it shows unreachable code error.

10)**Is it possible to write multiple exceptions in single catch block?**

-->It is not possible prior to java 7,
   new feature added in java 7.
   
   **try**
   {
 
      // your code here
            
     } 
   **catch (IOException | SQLException ex)**
   
   
   {
   
            System.out.println(e);
   }
   

11)**What are chained exceptions in java?**

-->In an application, one exception throws many exceptions. i.e one exception causes another exception and that exception causes another exception thus forming chain of exceptions. It is better to know where the actual cause of the exception lies. This is possible with chained exceptions feature of the Java.To implement chained exceptions in java, two new constructors and two new methods are added in the Throwable class. 

####Constructors Of Throwable class Which support chained exceptions in java :

1) Throwable(Throwable cause)    —-> where cause is the exception that causes the current exception.

2) Throwable(String msg, Throwable cause)   —-> where msg is the exception message and cause is the exception that causes the current exception.

####Methods Of Throwable class Which support chained exceptions in java :

1) getCause() method : This method returns actual cause of an exception.

2) initCause(Throwable cause) method : This method sets the cause for the calling exception.

Let’s see one example for how to set and get the actual cause of an exception.


public class ExceptionHandling

{

    public static void main(String[] args)
    {
        try
        {
            //creating an exception
 
            NumberFormatException ex = new NumberFormatException("Exception");   
 
            //setting a cause of the exception
 
            ex.initCause(new NullPointerException("This is actual cause of the exception"));  
 
            throw ex;
        }
        catch(NumberFormatException ex)
        {
            System.out.println(ex);     //displaying the exception
 
            System.out.println(ex.getCause());    //getting the actual cause of the exception
        }
    }
}

12)**What is try with resource block?**

-->In Java, if you use a resource like input or output streams or any database connection logic you always need to close it after using. 
It also can throw exceptions so it has to be in a try block and catch block. The closing logic  should be in finally block. This is a least the way until Java 7. This has several disadvantages:

    You'd have to check if your ressource is null before closing it
    The closing itself can throw exceptions so your finally had to contain another try -catch
    Programmers tend to forget to close their resources

The solution given by using try with resource statement.


13)**Why it is always recommended that clean up operations like closing the DB resources to keep inside a finally block?**

-->Because finally block is always executed whether exceptions are raised in the try block or not and raised exceptions are caught in the catch block or not. By keeping the clean up operations in finally block, you will ensure that those operations will be always executed irrespective of whether exception is occurred or not.

14)**What is Re-throwing an exception in java?**

-->Exceptions raised in the try block are handled in the catch block. If it is unable to handle that exception, it can re-throw that exception using throw keyword. It is called re-throwing an exception.

*There are the following reasons to "re-throw" exceptions:*

If you have something to do before.

If you catch exception of one type and throw exception of other type.

15)**What is the difference between ClassNotFoundException and NoClassDefFoundError in java?**

-->In Java, both ClassNotFoundException and NoClassDefFoundError occur when a particular class is not found at run time. But, they occur at different scenarios. ClassNotFoundException is an exception which occurs when you try to load a class at run time using **Class.forName() or loadClass()** methods and mentioned classes are not found in the classpath. On the other hand, NoClassDefFoundError is an error which occurs when a particular class is present at compile time but it was missing at run time. 

16)**What are 5 exception handling keywords in java?**

--> **try** - risky code is written in try block,any exception occurring in try block is catched by catch block.

 **catch**-to main Exception bodies code
     
**finally**-to maintain clean up code,finally block can can only exist if try or try-catch block is there, finally block can’t be used alone in java.

*Features of finally*

finally block is always executed irrespective of exception is thrown or not.

finally is keyword in java.

finally block is optional in java, we may use it or not.

*finally block is not executed in following scenarios*

finally is not executed when System.exit is called.

if in case JVM crashes because of some java.util.Error. 

**throw**- to handover our created exception obj. to the JVM manually

**throws**- to delegate the responsibility of the Exception Handling to the caller Method

17)**Discuss which checked and unchecked exception can be thrown/declared by subclass method while overriding superclass method in java?**

-->**If superclass method throws/declare unchecked/RuntimeException in java**

overridden method of subclass can declare/throw any unchecked /RuntimeException (superclass or subclass), or

overridden method of subclass cannot declare/throw any checked exception in java, or


overridden method of subclass can declare/throw same exception in java, or

overridden method of subclass may not declare/throw any exception in java.

**If superclass method throws/declare checked/compileTime exception in java**

overridden method of subclass can declare/throw narrower (subclass of) checked exception, or

overridden method of subclass cannot declare/throw broader (superclass of) checked exception, or

overridden method of subclass can declare/throw any unchecked /RuntimeException, or

overridden method of subclass can declare/throw same exception, or

overridden method of subclass may not declare/throw any exception in java.

**If superclass method does not throw/declare any exception in java**

overridden method of subclass can declare/throw any unchecked /RuntimeException , or

overridden method of subclass cannot declare/throw any checked exception, or

overridden method of subclass may not declare/throw any exception in java.

18)**Why shouldn’t you use Exception for catching all exceptions in java?**

-->Catching Exception rather than handling specific exception can be vulnerable to our application. Multiple catch blocks must be used to catch specific exceptions, because handling specific exception gives developer the liberty of taking appropriate action and develop robust application.

19)**Can a method be overloaded on basis of  exceptions in java ?**

-->Yes a method be overloaded on basis of  exceptions in java.

   public class ExceptionTest
   
   {
    
    void method(Exception e){
           System.out.println(e+" caught in Exception method");
    }
    void method(ArithmeticException ae){
           System.out.println(ae+" caught in ArithmeticException method");
    }
    
    public static void main(String[] args) {
           ExceptionTest obj=new ExceptionTest();
           obj.method(new ArithmeticException());
           obj.method(new IOException());
    }
}

20)**What are the most important frequently occurring Exception and Errors which you faced in java?**

-->*Most common and frequently occurring checked (compile time) and Errors in java* 

FileNotFoundException,ClassNotFoundException,SQLException,InterruptedException

*Most common and frequently occurring unchecked (runtime) in java.*

   - NullPointerException
   
   - NumberFormatException
   - IndexOutOfBoundsException
   - IllegalStateException
   - IllegalMonitorStateException
   - ArrayIndexOutOfBoundsException
   - StringIndexOutOfBoundsException
   - UnsupportedOperationException
    
*Most common and frequently occurring Errors in java* :
   
   - OutOfMemoryError
   - ExceptionInInitializerError
   - NoClassDefFoundError
   - StackOverflowError
    
21)**What is exception propagation in java?**
-->Whenever methods are called, stack is formed and an exception is first thrown from the top of the stack and if it is not caught, it starts coming down the stack to previous methods until it is not caught. 
If exception remains uncaught even after reaching bottom of the stack it is propagated to JVM and program is terminated. 

public class ExceptionTest

{
 
  public static void main(String []args)
  
  {
   
   method1()
   
   {
   
    
   System.out.println("after calling m()");
   
   }
   
   static void method1(){
   
   method2();
   }
   
   static void method2(){
      
   method3();    
      
  }
  
  static void method3(){
  
  throw new NullPointerException();
  
  }

In the above program, stack is formed and an exception is first thrown from the top of the stack [ method3() ] and it remains uncaught there, and starts coming down the stack to previous methods to method2(), then to method1(), than to main() and it remains uncaught throughout.
exception remains uncaught even after reaching bottom of the stack [ main() ] so it is propagated to JVM and ultimately program is terminated by throwing exception    
     
     

   
   




    
















