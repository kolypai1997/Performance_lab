import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=Integer.parseInt(args[0]);//����� n �� �������
		int m=Integer.parseInt(args[1]);//����� m �� �������
		ArrayList<String> listN = new ArrayList<String>();//������ ��������� ��������
		int[] arrayN=new int[n];//������ ����� �� 1 �� n
		int[] arrayM=new int[m];//��������� �������
		//��������� ������s ������� �� 1 �� n � �� 1 �� m
		for (int i=0;i<n;i++) {
			arrayN[i]=(i%n)+1;
		}
		
		for (int i=0;i<m;i++) {
			arrayM[i]=(i%m)+1;
		}
		listN.add(Arrays.toString(arrayM));//����� ������ ������ ������ � ������
		while(true) {//����� ��������� ���� �� �������� ������ �������� 
		for(int i=0;i<arrayM.length;i++) {//��������� ��������� ������
			arrayM[i]=arrayN[(i+m-1)%n];//��������� ������ �, ������� �� ������� � ����� ��������� m-1 ������ ��� ���������� � 0
		}

			char a=listN.get(0).charAt(1);//����� ������ ������� �� ������� �������
			char b=listN.get(listN.size()-1).charAt(listN.get(listN.size()-1).length()-2);//����� ��������� ������� �� ���������� �������
			if(a==b) {//���� ��� ����� ������ ������� ������ ���������
				break;
			}
			listN.add(Arrays.toString(arrayM));//������ ������ � ������
			
			m+=arrayM.length-1;//������������� ������ ��� ����������� ������
		}
		for(String i:listN) {
			System.out.print(i.charAt(1));
		}
	}

}
