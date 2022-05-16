import java.io.*;
import java.util.Scanner;

public class task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float centerX=0,centerY=0,radius=0;
		float pointX=0,pointY=0;
		//уравнение окружности (x-h)^2+(y-k)^2=r^2; сначала считываем h=centerX и k=centerY затем радиус
		//После открываем второй файл считываем две точки и из уравнения окружности делаем вывод где лежит точка
		try{
           Scanner sc= new Scanner(new File(args[0]));
           while(sc.hasNext())
           {
        	   centerX=sc.nextFloat();//
        	   centerY=sc.nextFloat();
        	   radius=sc.nextFloat();
           }   
           Scanner sc2= new Scanner(new File(args[1]));
           int counterPoint=0;
           float point=0;
           radius*=radius;//возводим в квадрат по формуле
           while(sc2.hasNext())
           {
        	   pointX=sc2.nextFloat();
        	   pointY=sc2.nextFloat();
        	   point=(pointX-centerX)*(pointX-centerX)+(pointY-centerY)*(pointY-centerY);
        	   if(point<radius) {
        		   System.out.println(counterPoint+" - "+"точка внутри");
        	   }else if(point>radius) {
        		   System.out.println(counterPoint+" - "+"точка снаружи");
        	   }else {
        		   System.out.println(counterPoint+" - "+"точка лежит на окружности");
        	   }
        	   counterPoint++;
           }
           sc.close();
           sc2.close();
           
        }
        catch(FileNotFoundException ex){
             
            System.out.println(ex.getMessage());
        }   

	}

}
