package org.ace;
import java.util.*;
class Weather extends Observable { //���۲�Ķ���
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
		super.notifyObservers(list);//list��Ҫ���ı�Ķ���
		     this.list=list;
            
		
			
	}
	
	public String toString(){	
	  return this.list.toString();
	}
};
class Sup implements Observer  //�۲���
{
      String name; //����������
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
		    Sup sup1=new Sup("������A");
			Sup sup2=new Sup("������B");
			Sup sup3=new Sup("������C");
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
