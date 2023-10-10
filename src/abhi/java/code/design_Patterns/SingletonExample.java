package abhi.java.code.design_Patterns;


import java.io.*;

public class SingletonExample {
	 
	// Creation design pattern
	// Only one instance of class should exist
	// Other classes should be able to get instance of singleton
	// Used in logging, cache, driver, session
	
	//private and static filed
	//private constructor 
	//public static method

  public static void main(String[] args) {
    SingletonSynchronized instance = SingletonSynchronized.getInstance();
    
    System.out.println(instance);
    
    SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
    
    System.out.println(instance1);
  }

}


// Singleton eager loading implementation 
class SingletonEagar {
	  private static SingletonEagar instance = new SingletonEagar(); 
	  
	  private SingletonEagar(){}
	  
	  public static SingletonEagar getInstance() {
	    return instance;
	  }
	}


//Singleton lazy loading implementation

	class Singletonlazy {
		
	  private static Singletonlazy instance; 
	  
	  private Singletonlazy(){}
	  
	  public static Singletonlazy getInstance() {
	    if(instance == null) {
	      instance = new Singletonlazy();
	    }
	    
	    return instance;
	  }
	}

	
// Singleton synchronized using method
	
	class SingletonSynchronizedMethod {
		
	  private static SingletonSynchronizedMethod instance; 
	  
	  private SingletonSynchronizedMethod(){}
	  
	  public static synchronized SingletonSynchronizedMethod getInstance() {
	    if(instance == null) {
	      instance = new SingletonSynchronizedMethod();
	    }
	    return instance;
	  }
	}



	// Singleton synchronized using block with double-checking

	class SingletonSynchronized {
		
	  private static SingletonSynchronized instance; 
	  
	  private SingletonSynchronized(){}
	  
	  public static SingletonSynchronized getInstance() {
	    if(instance == null) {
	      synchronized (SingletonSynchronized.class) {
	        if(instance == null) {
	          instance = new SingletonSynchronized();
	        }
	      }
	    }
	    return instance;
	  }
	}



// preventing to break from serlisation issue

class SingletonSerialization implements Serializable {

	// public instance initialized when loading the class
	public static SingletonSerialization instance = new SingletonSerialization();

	private SingletonSerialization()
	{
		// private constructor
	}

	// implement readResolve method
	protected Object readResolve() { return instance; }
}


