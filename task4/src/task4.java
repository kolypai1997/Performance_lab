import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class task4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> listA= new ArrayList<Integer>();
		try{
			//��������� �� ����� �����
	           Scanner sc= new Scanner(new File(args[0]));
	           while(sc.hasNext())
	           {
	        	  listA.add(sc.nextInt());
	           }   
	           //���������
	           Collections.sort(listA);
	           //������� �������
	           int mid = listA.size()/2;
	           int res=0;
	           //��������� ������ �������� ������� �������� ������ � �������� ��� ���������� ����������
	           for(int i:listA) {
	        	   res+=Math.abs(i-listA.get(mid));
	           }
	           System.out.print(res);
		}catch(FileNotFoundException ex){
            
           System.out.println(ex.getMessage());
       }   
	}

}
