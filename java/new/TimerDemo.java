package  org.ace;
import java.util.*;
import java.text.SimpleDateFormat;

class TimersTask extends TimerTask // ����������
{
    public void run(){ //���񷽷�
	
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss.SSS");
	     System.out.println("��ǰʱ�䣺"+sdf.format(new Date()));
	
	}

}


public class TimerDemo 
{
	public static void main(String args[]){
	      Timer t = new Timer(); //����������
		  TimersTask tt =new TimersTask(); //����������
		  t.schedule(tt,1000,1111); //��ʱִ������ ��ʱ1000���� ÿ1111������ִ��
	    
	
	}
}