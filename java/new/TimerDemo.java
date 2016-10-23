package  org.ace;
import java.util.*;
import java.text.SimpleDateFormat;

class TimersTask extends TimerTask // 创建任务类
{
    public void run(){ //任务方法
	
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss.SSS");
	     System.out.println("当前时间："+sdf.format(new Date()));
	
	}

}


public class TimerDemo 
{
	public static void main(String args[]){
	      Timer t = new Timer(); //创建调度类
		  TimersTask tt =new TimersTask(); //创建任务类
		  t.schedule(tt,1000,1111); //定时执行任务 延时1000毫秒 每1111毫秒在执行
	    
	
	}
}