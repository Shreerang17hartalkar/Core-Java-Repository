1)**What is the difference between Iterator and Enumeration ?**

-->The main difference between Iterator and Enumeration is that Iterator has remove() method while Enumeration doesn't.
Hence , using Iterator we can manipulate objects by adding and removing the objects from the collections. Enumeration behaves like a read only interface as it can only traverse the objects and fetch it .

2))**Which methods you need to override to use any object as key in HashMap ?**

-->To use any object as key in HashMap , it needs to implement equals() and hashCode() method .

3)**How to reverse the List in Collections ?**

-->There is a built in reverse method in Collections class . reverse(List list) accepts list as parameter.Collections.reverse(listobject);


4)**How to convert the array of strings into the list ?**

-->Arrays class of java.util package contains the method asList() which accepts the array as parameter.
So,

String[]  wordArray =  {"Love Yourself"  , "Alive is Awesome" , "Be in present"};

5)**What is the difference between HashMap and Hashtable ?**

-->Main differences between HashMap and Hashtable are :

a. HashMap allows one null key and any number of null values while Hashtable does not allow null keys and null values.
b. HashMap is not synchronized or thread-safe while Hashtable is synchronized or thread-safe .

List wordList =  Arrays.asList(wordArray);

6)**What is the difference between peek(),poll() and remove() method of the Queue interface ?**

-->Both poll() and remove() method is used to remove head object of the Queue. The main difference lies when the Queue is empty().
If Queue is empty then poll() method will return null . While in similar case , remove() method will throw NoSuchElementException .
peek() method retrieves but does not remove the head of the Queue. If queue is empty then peek() method also returns null.

7)**What is the difference between Iterator and ListIterator.**

-->Using Iterator we can traverse the list of objects in forward direction . But ListIterator can traverse the collection in both directions that is forward as well as backward.

8)**What is the difference between HashMap and ConcurrentHashMap ?**

-->a. HashMap is not synchronized while ConcurrentHashMap is synchronized.

b. HashMap can have one null key and any number of null values while ConcurrentHashMap does not allow null keys and null values .

9)**Why Map interface does not extend the Collection interface in Java Collections Framework ?**

-->Explanation : Since Map requires key as well as value , for example , if we want to add key-value pair then we will use put(Object key , Object value) . So there are two parameters required to add element to the HashMap object  . In Collection interface add(Object o) has only one parameter. 
The other reasons are Map supports valueSet , keySet as well as other appropriate methods which have just different views from the Collection interface.

10)**When to use ArrayList and when to use LinkedList in application?**

-->ArrayList has constant time search operation O(1) .Hence, ArrayList is preferred when there are more get() or search operation .

Insertion , Deletion operations take constant time O(1) for LinkedList. Hence, LinkedList is preferred when there are more insertions or deletions involved in the application.

11)**How HashSet works internally in java ?**

-->public class HashSet<<E>> 

extends AbstractSet<<E>>

implements Set<<E>>, Cloneable, java.io.Serializable

{

    private transient HashMap<E,Object> map;
    
    // Dummy value to associate with an Object in the backing Map
    
    private static final Object PRESENT = new Object();
    
    
    
    public HashSet() {
        map = new HashMap<>();
    }
    
    // SOME CODE ,i.e Other methods in Hash Set
    
    
    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }
    
    
    
    // SOME CODE ,i.e Other methods in Hash Set
}

So , we are achieving uniqueness in Set,internally in java  through HashMap . Whenever you create an object of HashSet it will create an object of HashMap as you can see in the lines public HashSet(){ 

map= new HashMap<>}.

As we know in HashMap each key is unique . So what we do in the set is that we pass the argument in the add(Elemene E) that is E as a key in the HashMap . Now we need to associate some value to the key , so what Java apis developer did is to pass the Dummy  value that is ( new Object () ) which is referred by Object reference PRESENT .

So , actually when you are adding a line in HashSet like  hashset.add(3)   what java does internally is that it will put that element E here 3 as a key in the HashMap(created during HashSet object creation) and some dummy value that is Object's object is passed as a value to the key .

Now if you see the code of the HashMap put(Key k,Value V) method , you will find something like this

 public V put(K key, V value) {
//Some code
}

The main point to notice in above code is that put (key,value) will return

1.  null , if key is unique and added to the map
2.  Old Value of the key , if key is duplicate

So , in HashSet add() method ,  we check the return value of map.put(key,value) method with null value 
i.e.

   public boolean add(E e) {
            return map.put(e, PRESENT)==null;
       }

So , if map.put(key,value) returns null ,then
map.put(e, PRESENT)==null      will return true and element is added to the HashSet.



So , if map.put(key,value) returns old value of the key ,then
map.put(e, PRESENT)==null      will return false and element is  not added to the HashSet .

12)**What is CopyOnWriteArrayList ?  How it is different from  ArrayList in Java?**

-->CopyOnWriteArrayList is a thread safe variant of ArrayList   in which all mutative operations like ( add , set,etc..) are implemented by creating a fresh copy of the underlying array.

It guaranteed not to throw ConcurrentModificationException.

It permits all elements including null. It is introduced in jdk 1.5 .

13)**How HashMap works in Java ?**

-->HashMap works on the principle of Hashing .  To understand Hashing , we should understand the three terms first   i.e  Hash Function , Hash Value and Bucket .

What is Hash Function , Hash Value  and Bucket ?

hashCode() function  which returns an integer value is the Hash function. The important point to note that ,  this method is present in Object class .

This is the code for the hash function(also known as hashCode method) in Object Class :

    public native int hashCode();

The most important point to note from the above line :  hashCode method return  int value .
So the Hash value is the int value returned by the hash function .

What is bucket ? 

A bucket is used to store key value pairs . A bucket can have multiple key-value pairs . In hash map, bucket used simple linked list to store objects .

After understanding the terms we are ready to move next step , How hash map works in java or How get() works internally in java .

*Code inside Java Api (HashMap class internal implementation) for HashMap get(Obejct key) method* 

Public  V get(Object key)

   {
   
     if (key ==null)
     
    //Some code
    
     int hash = hash(key.hashCode());
    
     // if key found in hash table then  return value
     //    else return null
   }
   
   *Hash map works on the principle of hashing*
   
   HashMap get(Key k) method calls hashCode method on the key object and applies returned hashValue to its own static hash function to find a bucket location(backing array) where keys and values are stored in form of a nested class called Entry (Map.Entry) . So you have concluded that from the previous line that **Both key and value is stored in the bucket as a form of  Entry object** .
   
   * Whenever we call get( Key k )  method on the HashMap object . First it checks that whether key is null or not .  Note that there can only be one null key in HashMap .  

If key is null , then Null keys always map to hash 0, thus index 0.

If key is not null then , it will call hashfunction on the key object , see line 4 in above method i.e. key.hashCode()  ,so after key.hashCode() returns hashValue , line 4 looks like

4.                int hash = hash(hashValue)

 , and now ,it applies returned hashValue into its own hashing function .

We might wonder why we are calculating the hashvalue again using hash(hashValue). Answer is ,It defends against poor quality hash functions.

Now step 4 final  hashvalue is used to find the bucket location at which the Entry object is stored . Entry object stores in the bucket like this (hash,key,value,bucketindex) .  

What if  when two different keys have the same hashcode ?

-->Solution, equals() method comes to rescue.

The bucket is the linked list effectively . Its not a LinkedList as in a java.util.LinkedList - It's a separate (simpler) implementation just for the map .

So we traverse through linked list , comparing keys in each entries using keys.equals() until it return true.  Then the corresponding entry object Value is returned .

14)**What is BlockingQueue in Java Collections Framework?**

-->BlockingQueue implements the java.util.Queue interface . BlockingQueue supports  operations that wait for the queue to become non-empty when retrieving an element , and wait  for space to become available in the queue when storing an element .
It does not accept null elements.
Blocking queues are primarily designed for the producer-consumer problems.
BlockingQueue implementations are thread-safe and can also be used in inter-thread communications.
This concurrent Collection class was added in jdk 1.5

15)**What is the difference between Fail- fast iterator and Fail-safe iterator ?**

-->Main differences between Fail-fast and Fail-safe iterators are :
a. Fail-fast throw ConcurrentModificationException while Fail-safe does not.
b. Fail-fast does not clone the original collection list of objects while Fail-safe creates a copy of the original collection list of objects.

What is Concurrent Modification ?

When one or more thread is iterating over the collection, in between, one thread changes the structure of the collection (either adding the element to the collection or by deleting the element in the collection or by updating the value at particular position in the collection) is known as Concurrent Modification

Difference between Fail Fast iterator and Fail Safe iterator

Fail fast Iterator

Fail fast iterator while iterating through the collection , instantly throws Concurrent Modification Exception if there is structural modification  of the collection . Thus, in the face of concurrent modification, the iterator fails quickly and cleanly, rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future. 

Fail-fast iterator can throw ConcurrentModificationException in two scenarios :
Single Threaded Environment
  
After the creation of the iterator , structure is modified at any time by any method other than iterator's own remove method. 
  
Multiple Threaded Environment 

 If one thread is modifying the structure of the collection while other thread is iterating over it .

*How  Fail  Fast Iterator  come to know that the internal structure is modified ?*

Fail Safe Iterator makes copy of the internal data structure (object array) and iterates over the copied data structure.Any structural modification done to the iterator affects the copied data structure.  So , original data structure remains  structurally unchanged .Hence , no ConcurrentModificationException throws by the fail safe iterator.

Two  issues associated with Fail Safe Iterator are :

1. Overhead of maintaining the copied data structure i.e memory.

2.  Fail safe iterator does not guarantee that the data being read is the data currently in the original data structure. 


16)**How do you use a custom object as key in Collection  classes like HashMap ?**

-->If one is using the custom object as key then one needs to override equals() and hashCode() method
and one also need to fulfill the contract.
If you want to store the custom object in the SortedCollections like SortedMap then one needs to make sure that equals() method is consistent to the compareTo() method. If inconsistent , then collection will not follow their contracts ,that is , Sets may allow duplicate elements.

17)**What is hash-collision in Hashtable ? How it was handled in Java?**

-->In Hashtable , if two different keys have the same hash value then it lead to hash -collision. A bucket of type linkedlist used to hold the different keys of same hash value.

18)**Explain the importance of hashCode() and equals() method ? Explain the contract also ?**

-->HashMap object uses Key object hashCode() method and equals() method to find out the index to put the key-value pair. If we want to get value from the HashMap same both methods are used . Somehow, if both methods are not implemented correctly , it will result in two keys producing the same hashCode() and equals() output. The problem will arise that HashMap will treat both output same instead of different and overwrite the most recent key-value pair with the previous key-value pair.
Similarly all the collection classes that does not allow the duplicate values use hashCode() and equals() method to find the duplicate elements.So it is very important to implement them correctly.

Contract of hashCode() and equals() method

a.  If  object1.equals(object2) , then  object1.hashCode() == object2.hashCode() should always be true.

b. If object1.hashCode() == object2.hashCode() is true does not guarantee object1.equals(object2)

19)**What is EnumSet in Java ?**

-->EnumSet  is a specialized Set implementation for use with enum types. All of the elements in an enum set must come from a single enum type that is specified explicitly  or implicitly , when the set is created.

The iterator never throws ConcurrentModificationException and is weakly consistent.

Advantage over HashSet:

All basic operations of EnumSet execute in constant time . It is most likely to be much faster than HashSet counterparts.

20)**What are concurrentCollectionClasses? **

-->In jdk1.5 , Java Api developers had introduced new package called java.util.concurrent that have thread-safe collection classes as they allow collections to be modified while iterating . The iterator is fail-safe that is it will not throw ConcurrentModificationException.
Some examples of concurrentCollectionClasses are :
a. CopyOnWriteArrayList
b. ConcurrentHashMap

21)**What is IdentityHashMap?**

--> It is a class present in java.util package. It implements the Map interface with a hash table , using reference equality instead of object equality when comparing keys and values.In other words , in IdentityHashMap two keys k1 and k2 are considered equal if only if (k1==k2).
IdentityHashMap is not synchronized.
Iterators returned by the iterator() method are fail-fast , hence , will throw ConcurrentModificationException. 


22)**What is  WeakHashMap ?**

-->WeakHashMap is a class present in java.util package similar to IdentityHashMap. It is a Hashtable based implementation of Map interface with weak keys. An entry in WeakHashMap will automatically be removed when its key is no longer in ordinary use. More precisely the presence of a mapping for a given key will not prevent the key from being discarded by the garbage collector.
It permits null keys and null values.
Like most collection classes this class is not synchronized.A synchronized WeakHashMap may be constructed using the Collections.synchronizedMap() method.
Iterators returned by the iterator() method are fail-fast , hence , will throw ConcurrentModificationException. 

23)**How will you make Collections readOnly ?**

-->We can make the Collection readOnly by using the following lines code:

General : Collections.unmodifiableCollection(Collection c)

Collections.unmodifiableMap(Map m)
Collections.unmodifiableList(List l)
Collections.unmodifiableSet(Set s)

24)**What is UnsupportedOperationException?**

-->This exception is thrown to indicate that the requested operation is not supported.

Example of UnsupportedOperationException:

In other words, if you call add() or remove() method on the readOnly collection . We know readOnly collection can not be modified . Hence , UnsupportedOperationException will be thrown.

25)**Suppose there is an Employee class. We add Employee class objects to the ArrayList. Mention the steps need to be taken , if I want to sort the objects in ArrayList using the employeeId attribute present  in Employee class.**

-->a. Implement the Comparable interface for the Employee class and now to compare the objects by employeeId we will override the emp1.compareTo(emp2)

b. We will now call Collections class sort method and pass the list as argument , that is ,

     Collections.sort(empList)  
     

26)**What are Collection related features in Java 8?**

--> Java Stream API for collection classes for supporting sequential as well as parallel processing
Iterable interface is extended with forEach() default method that we can use to iterate over a collection. It is very helpful when used with lambda expressions because it’s argument Consumer is a function interface.
Miscellaneous Collection API improvements such as forEachRemaining(Consumer action) method in Iterator interface, Map replaceAll(), compute(), merge() methods.

27)**What are different ways to iterate over a list?**

-->We can iterate over a list in two different ways – using iterator and using for-each loop.

List<String> strList = new ArrayList<>();

//using for-each loop

for(String obj : strList){

    System.out.println(obj);
}

//using iterator

Iterator<String> it = strList.iterator();

while(it.hasNext()){

    String obj = it.next();
    
    System.out.println(obj);
}

28)**How to avoid ConcurrentModificationException while iterating a collection?**

-->We can use concurrent collection classes to avoid ConcurrentModificationException while iterating over a collection, for example CopyOnWriteArrayList instead of ArrayList.

29)**What is the importance of hashCode() and equals() methods?**

-->HashMap uses Key object hashCode() and equals() method to determine the index to put the key-value pair. These methods are also used when we try to get value from HashMap. If these methods are not implemented correctly, two different Key’s might produce same hashCode() and equals() output and in that case rather than storing it at different location, HashMap will consider them same and overwrite them.

Similarly all the collection classes that doesn’t store duplicate data use hashCode() and equals() to find duplicates, so it’s very important to implement them correctly. The implementation of equals() and hashCode() should follow these rules.

If o1.equals(o2), then o1.hashCode() == o2.hashCode()should always be true.
If o1.hashCode() == o2.hashCode is true, it doesn’t mean that o1.equals(o2) will be true.

30)**Which collection classes are thread-safe?**

-->Vector, Hashtable, Properties and Stack are synchronized classes, so they are thread-safe and can be used in multi-threaded environment. Java 1.5 Concurrent API included some collection classes that allows modification of collection while iteration because they work on the clone of the collection, so they are safe to use in multi-threaded environment.


31)**What are differences between Collection and Collections in java?**

-->java.util.Collection ​ is the root interface in the ​hierarchy of Java Collection framework​. 
 
The JDK does not provide any classes which directly implements java.util.Collection interface, but it  provides classes such as ArrayList, LinkedList, vector, HashSet, EnumSet, LinkedHashSet, TreeSet, CopyOnWriteArrayList, CopyOnWriteArraySet, ConcurrentSkipListSet  which implements more specific subinterfaces like ​Set and List​ in java.

java.util.Collections is a utility class which consists of static methods that operate on or return Collection in java.

java.util.Collections provides method like >

reverse method for reversing List in java.

shuffle method for shuffling elements of List in java.

unmodifiableCollection, unmodifiableSet, unmodifiableList, unmodifiableMap methods for making List, Set and Map unmodifiable in java.

min method to return smallest element in Collection in java.

max method to return smallest element in Collection.

sort method for sorting List.

synchronizedCollection,  synchronizedSet, synchronizedList, synchronizedMap methods for synchronizing List, Set and Map respectively in java.

32)**What are different ways of iterating over elements in List?**

-->
Creating ArrayList and add element.

 List<String> arrayList=new ArrayList<String>();
 
 arrayList.add("javaMadeSoEasy");  


Iterate over elements in ArrayList using iterator()

iterator() method returns iterator to iterate over elements in ArrayList.
 
     Iterator<String> iterator=arrayList.iterator();
     
    while(iterator.hasNext()){
    
           System.out.println(iterator.next());
    }
iterator returned by ArrayList is fail-fast.

 Iterate over elements in ArrayList using listIterator()
 
ListIterator<String> listIterator=arrayList.listIterator();

ListIterator returned by ArrayList is also fail fast. 

 Iterate over elements in list using enumeration 
 
   Enumeration<String> listEnum=Collections.enumeration(arrayList);
   
    while(listEnum.hasMoreElements()){
    
       System.out.println(listEnum.nextElement()); 
    }
enumeration is also fail-fast.

 Iterate over elements in list using enhanced for loop
 
           for (String string : arrayList) {
           
               System.out.println(string);
        }


33)**Let’s say you have to build dictionary and multiple users can add data in that dictionary? And you can use 2 Collection classes? Which Collection classes you will prefer and WHY?**

-->Store words in ConcurrentSkipListMap as key>

keys are sorted in natural order (words will be sorted in natural order), 

doesn’t allow null keys (words can’t be null)

doesn’t allow duplicate keys (words can’t be duplicate) and 

synchronized, so 2 threads won’t create synchronization problems (will take care of different uses adding words concurrently)

for storing meaning of word in dictionary we must use TreeSet as value in ConcurrentSkipListMap because one word can have many meanings >

elements are sorted in natural order (meaning of word are sorted in natural order), 

doesn’t allow null elements (meaning of word can’t be null),

doesn’t allow duplicate elements (meaning of word can’t be duplicate)

public class MyDictionary {

    public static void main(String[] args) {
    
           ConcurrentSkipListMap<String, TreeSet<String>> myDictionary =
                        new ConcurrentSkipListMap<String, TreeSet<String>>();
 
           TreeSet<String> innocentMeaning = new TreeSet<String>();
           
           innocentMeaning.add("not responsible for an event yet suffering its consequences");
           innocentMeaning.add("not guilty of a crime");
 
           myDictionary.put("innocent", innocentMeaning);
 
           TreeSet<String> appealingMeaning = new TreeSet<String>();
           appealingMeaning.add("attractive");
           appealingMeaning.add("expressing a desire for help");
 
           myDictionary.put("appealing", appealingMeaning);
 
           System.out.println(myDictionary);
 
    }
}

34)**Why we need to override the hashCode() and equals(Object obj) method? Is it better to override only equals() method? if not why?**

-->No, We don't need to override the hashCode() and equals(Object) method unless and until we are planing to use the class inside the hash based collections.

Why we need to override the hashCode() and equals(Object obj) method: This is only required if we are going to use our class inside the hash based collections such as  HashMap, HashSet,Hashtable.

We must need to override hashCode() method in every class that override the equals(Object obj) method. If we are not doing so mean we are breaking the contracts of object, will cause the unexpected result while playing with hash based collections.

If two objects are equal according to the equals(Object) method, then calling
the hashCode method on each of the two objects must produce the same
integer result

35)**Differrence between HashMap & ConcurrentHashMap**

-->1.  Thread -Safe : 

     ConcurrentHashMap is thread-safe that is the code can be accessed by single thread at a time .    
     while HashMap is not thread-safe 
     
     2.  Synchronization Method :

    HashMap can be synchronized by using    
    synchronizedMap(HashMap)  method .  By using this  
    method we get a HashMap object which is equivalent 
    to the HashTable object . So every modification  is performed    
    on  Map is locked on Map object.
    
    3. ConcurrentHashMap is more scalable and performs better than Synchronized HashMap in the multi-threaded environment while in Single threaded environment both HashMap and ConcurrentHashMap gives comparable performance, where HashMap only slightly better.
    
36)**Why we need ConcurrentHashMap when we already had Hashtable ?**

-->Hashtable provides concurrent access to the Map.Entries objects by locking the entire map to perform any sort of operation (update,delete,read,create). Suppose we have a web application , the overhead created by Hashtable  (locking the entire map) can be ignored under normal load. But under heavy load , the overhead of locking the entire map may prove fatal and may lead to delay response time and   overtaxing of the server.This  is where ConcurrentHashMap comes to rescue.

ConcurrentHashMap class is fully interoperable with Hashtable in programs that rely on its thread safety but not on its synchronization details. So the main purpose of this class is to provide the same functionality as of Hashtable but with a performance comparable to HashMap. 

The constructor of ConcurrentHashMap looks like this :

public ConcurrentHashMap (int initialCapacity, float loadFactor, int concurrencyLevel)

So the above line  creates a new, empty map with the specified initial capacity, load factor and concurrency level.
where,

Important Parameters to consider from ConcurrentHashMap Constructor:

initialCapacity - the initial capacity. The implementation performs
internal sizing to accommodate this many elements.

concurrencyLevel - the estimated number of concurrently updating threads. The implementation performs internal sizing to try to accommodate this many threads.

In the ConcurrentHashMap Api , you will find the following constants.

static final int DEFAULT_INITIAL_CAPACITY = 16;

static final int DEFAULT_CONCURRENCY_LEVEL = 16;

initial capacity parameter and concurrency level parameters of ConcurrentHashMap constructor (or Object) are  set to 16 by default.

Thus, instead of a map wide lock, ConcurrentHashMap maintains  a list of 16 locks by default ( number of locks equal to the initial capacity , which is by default  16) each of which is used to lock on a single bucket of the Map.This indicates that 16 threads (number of threads equal to the concurrency level , which is by  default 16) can modify the collection at the same time , given ,each thread works on different bucket. So unlike hashtable, we perform any sort of operation ( update ,delete ,read ,create) without locking on entire map in ConcurrentHashMap.

Retrieval operations (including get) generally do not block, so may overlap with update operations (including put and remove). Retrievals reflect the results of the most recently completed update operations holding upon their onset. 

The allowed concurrency among update operations is guided by the optional concurrencyLevel constructor argument (default 16), which is used as a hint for internal sizing. The table is internally partitioned to try to permit the indicated number of concurrent updates without contention. Because placement in hash tables is essentially random, the actual concurrency will vary. Ideally, you should choose a value to accommodate as many threads as will ever concurrently modify the table. Using a significantly higher value than you need can waste space and time, and a significantly lower value can lead to thread contention

ConcurrentHashMap: It allows concurrent access to the map. Part of the map called Segment (internal data structure) is only getting locked while adding or updating the map. So ConcurrentHashMap allows concurrent threads to read the value without locking at all. This data structure was introduced to improve performance.


 






































