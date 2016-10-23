package org.ace;
import java.util.*;
class Weather extends Observable { //被观察的对象
  private List<String> list;
	public Weather(){
		this.list=new ArrayList<String>();
        this.list.add("1");
	    this.list.add("2");
		this.list.add("3");
		}
	public void weatherValueUpdate(
	List list	){
		super.setChanged();
		super.notifyObservers(list);//list是要被改变的对象
		     this.list=list;
            
		
			
	}
	
	public String toString(){	
	  return this.list.toString();
	}
};
class Sup implements Observer  //观察者
{
      String name; //订阅者名字
	  public Sup(String name){
		  this.name=name;
	  }
    public void update(Observable ob,Object o){
          System.out.print(this.name+"listbianwei");
		  System.out.println(((List)o).toString());
	}
        
};

public class OpservDemo
{
  public static void main(String args[]){
          Weather o =new Weather();
		    Sup sup1=new Sup("订阅者A");
			Sup sup2=new Sup("订阅者B");
			Sup sup3=new Sup("订阅者C");
			System.out.println(o);
			o.addObserver(sup1);
            o.addObserver(sup2);
            o.addObserver(sup3);
			List<String> list =new ArrayList<String>();
			  list.add("123");
			  list.add("dkjf");
			o.weatherValueUpdate(list);
              ListIterator li = list.listIterator();
                for(;li.hasNext();){
					System.out.println(li.next());
				}

			
  
  }
 

}
