import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=Integer.parseInt(args[0]);//берем n из консоли
		int m=Integer.parseInt(args[1]);//берем m из консоли
		ArrayList<String> listN = new ArrayList<String>();//список сдвинутых массивов
		int[] arrayN=new int[n];//массив чисел от 1 до n
		int[] arrayM=new int[m];//сдвинутые массивы
		//заполняем массивs числами от 1 до n и от 1 до m
		for (int i=0;i<n;i++) {
			arrayN[i]=(i%n)+1;
		}
		
		for (int i=0;i<m;i++) {
			arrayM[i]=(i%m)+1;
		}
		listN.add(Arrays.toString(arrayM));//сразу кладем первый массив в список
		while(true) {//будем выполнять пока не составим список массивов 
		for(int i=0;i<arrayM.length;i++) {//формируем сдвинутый массив
			arrayM[i]=arrayN[(i+m-1)%n];//заполняем массив М, числами из массива Н путем пересчета m-1 потому что индексация с 0
		}

			char a=listN.get(0).charAt(1);//берем первый элемент из первого массива
			char b=listN.get(listN.size()-1).charAt(listN.get(listN.size()-1).length()-2);//берем последний элемент из последнего массива
			if(a==b) {//если они равны значит условие выхода выполнено
				break;
			}
			listN.add(Arrays.toString(arrayM));//кладем массив в список
			
			m+=arrayM.length-1;//пересчитываем индекс для правильного сдвига
		}
		for(String i:listN) {
			System.out.print(i.charAt(1));
		}
	}

}
