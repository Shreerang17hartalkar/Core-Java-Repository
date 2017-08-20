### 1)What is **method overloading** in Java?

Ans: *Method Overloading* is a Java Programming concept when programmer
declares two methods of the same name but with different *method
signature*. e.g,change in the argument list or change in the type of
argument. Method overloadingis a powerful Java programming technique to
declare a method which does a similar performance but with a different
kind of output. One of the most popular ex. is **system.out.println()**
method which is oveloaded to accept all kinds of data types in Java.
*println* method takes **String,int,double,float** or even char in
input.All of those methods are collectively referredas an overloaded
method in Java.

     **Method overloading example in Java**

     *Original Method*:
     public void show(String msg){
     System.out.println(msg);
     }
     

      *Overloaded Method*
      public void show(String msg,boolean show){
     System.out.println(msg);
     }

### 2)What is **Method Overriding** in Java?

Ans: *Method overriding* in Java is a concept based on Polymorphism OOPS
concept which allows programmer to create two methods with same name &
method signature on interface & its various implementation. In
overriding *Method Resolution* always takes care by JVM based on runtime
Object,hence it is also considered as *Runtime Polymorphism* or *Dynamic
Polymorphism* or *Dynamic Method Dispatch*.In Overriding return types
must also be same upto 1.4V only but from 1.5 Version onwards we can
also use **Co-variant** return types also.

### 3)What is the difference between Composition & Inheritence?

Ans:Though both *Inheritence* & *Composition* provides code reusability,
main difference between them is **Composition** allows reuse of code
without extending but for **Inheritence** you must extend the class for
any reuse of code or functionality.Another difference which comes from
this fact by using Composition you can reuse code for even final class
which is not *Extensible* but Inheritence can't reuse code in such
cases.Also by using Composition we can reuse code as they are declared
as just a member variable,but in case of Inheritence we can use code
from just one class,bcz multiple inheritence is not allowed.Let us
discuss this in more detail..

    ###1)**Static vs Dynamic**
                             First difference between them comes from the
    flexibility point of view.When we use Inheritence,we have to define
    which class we are extending in a code,it can't be changed at *runtime*.
    But with *Composition* we just define a Type whichwe want to use,which
    can hold its different implementation.In this case,Composition is much
    more flexible than Inheritence.

     ###2)**Limited code reuse with Inheritence**

                             with Inheritance you can only extend one 
     class, which means you code can only reuse just one class, not more
     than one. If you want to leverage functionalities from multiple class,
     you must use Composition. For example, if your code needs authentication 
     you can use an functionality,you can use an *Authenticater* for 
     Authorization you can use an Authorizer etc,but with Inheritence we
     just stuck with only one class bcz Java does not support multiple
    Inheritence.

     ###3)**Unit Testing**
                        Probably this is the most important difference
     between the two and its the deciding factor in whether to use 
     Inheritence or composition,When we design classes using composition 
     they are easier to test bcz we can supply *Mock* impl. of the classes
     we are using but when we design classes using Inheritence we need
     parent class in order to test child.There is no way we can provide
    mock implementation of parent class.

    ###3)**Polymorphism** in Java

     Ans:Single name but multiple forms is the concept of Polymorphism.
      for e.g,We can use same List reference to hold ArrayList,LinkedList,
     Vector or Stack object.
                new ArrayList();
      List l=   new LinkedList();
                new Vector();
                new Stack();
       Method overloading is the exmaple if static Polymorphism whereas
       Method Overriding is the ex of Dynamic Polymorphism.

    ###4)**Static Control Flow in Java**

    Ans:Whenever we are executing a java class the following sequence
    of events will be performed.
    -**Identification** of static members from top to bottom.

    -**Execution** of static variable assignments & static blocks from top 
      to bottom.

    -**Execution** of main method.

    ###5)**Instance Control Flow in Java**

    Ans: -**Identification** of instance members.
         -**Execution** of instance variable assignments & Instance 
             Blocks from top to Bottom.
         -**Execution** of constructor.
