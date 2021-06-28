# Singleton Pattern

<h3> একটি ক্লাসের একটি মাত্র instance থাকবে এবং একটি গ্লোভাল পয়েন্ট থাকবে যেখান থেকে সবাই instance টিকে এক্সেস করতে পারবে । 
  The Singleton Pattern ensures a class has only one instance, and provides a global
point of access to it. </h3>

<h2> Singleton Pattern মূলত ২ ধরনের :</h2>
  <ol>
    <li> **Early Instantiation:** একদম শুরুতে ক্লাস লোডিং এর সময় অবজেক্ট creat করে ফেলা । 
      <li> **Lazy Instantiation:** যখন দরকার তকন তৈরি করা । 
  </ol>

# সিঙ্গেল্টন(Singleton) প্যাটার্ন কেন লাগবে ? 
<ol>
  <li> এমন কিছু ক্লাস আছে যাদের instance একটির বেশী হলে প্রোগ্রামর behavior অদ্ভুত হতে পারে ! যেমন ডেটাবেজ কানেকশনের কথাই বলা যাক, আমরা যদি প্রত্যেক বার ডেটাবেজ থেকে কিছু আনতে বা কিছু রাখতে 
    নতুন নতুন কানেকশন create করি তাহলে inconsistency তৈরি হতে পারে । </li>
  </ol>
  
  # চলুন কথা কম বলে ইমপ্লিমেন্টেশনে যাই 
  
  ```java 
  
  public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton(){}

    public static Singleton getInstance(){
        if(uniqueInstance == null)
        {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    // Other methods
}
  ```
 
 <h3> Constructor **private** কেন? </h3>
 Singleton ক্লাসের বাহির থেকে কেও যাতে অবজেক্ট create করতে না পারে । 
 
 <h3> uniqueInstance private কেন? </h3>
 **private** দেওয়ার কারণ হছে এই অবজেক্টিকে কেউ যাতে সরাসরি **getInstance** method ছাড়া access করতে না পারে ।
 <h3> uniqueInstance static কেন? </h3>
 
   Singleton Pattern যেহেতু আমাদের আগেই বলছে একটি গ্লোভাল এক্সেস 
  পয়েন্ট দিতে হবে । তাই আমরা **public** **static** getInstance method টি তৈরি করেছি । Access modifier e **staic** দেওয়ার কারণ হচ্ছে যে কেও যাতে যেকোন
  স্থান থেকে এক্সেস করতে পারে । 
  এখন যেহেতু আমরা একবারই অবজেক্ট create করতে পাড়বো এবং এই একটি অবজেক্টই পরবর্তীতে আমাদের ব্যবহার করতে হবে , তাহলে আমাদের এই অব্জেক্তিতে কোন **variable** এ save করতে হবে ।
  এখন যেহেতু **getInstance** method **staic** type এর তাই এই method এর ভেতর **Non static** কোন ভ্যারিয়েবল ব্যবহার করা যাবে না । এইজন্য **uniqueInstance** এর
  **access modifier** এ **static** ব্যবহার করা হয়েছে ।
  
  <h2> কোড দেখে মনে হচ্ছে সব কিছু ঠিক ঠাক এ আছে । কিন্তু যদি **Multithreading** এর ঝামেলা আসে ! আমাদের কোড হ্যান্ডেল করতে পারবেতো ? না, **Multithreading** যাতে কোন প্রব্লেম
  তৈরি করতে না পারে আমরা এমন কোন ব্যবস্থা গ্রহণ করিনি । তাহলে চলুন **getInstance** method টিকে **syncronize** করে ফেলি </h2>
  
  ```java
  
  public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton(){}

    public static synchronized Singleton getInstance(){
        if(uniqueInstance == null)
        {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    // Other methods
}
  
  ```
  
  # চলুন একটি ড্রাইভার ক্লাস লিখে কোড রান করি 
  
  ```java
  public class Demo {
    public static void main(String[] args) {
        Singleton objOne = Singleton.getInstance();
        Singleton objTwo = Singleton.getInstance();

        if(objOne == objTwo){
            System.out.println("Thre are same object");
        }
    }
}
  
  ```
  
  # আউটপুট 
  
  ```
    Thre are same object
  ```
  
  
