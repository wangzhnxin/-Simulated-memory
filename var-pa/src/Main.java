//stu:5157101222
//jdk1.7u80 ����ͨ��
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		 Scanner sc=new Scanner(System.in);
		 Shell sl=new Shell(670);
		 String p;
		 int k=1;
		 while(true){
			 sl.showArea();
		 System.out.println("\t���̶������ڴ����");
		 System.out.println("\t x�˳� \t 1�����ڴ�\t 2�ͷ��ڴ�");
		 p=sc.next();
		 if(p.equals("x")||p.equals("X"))break;//�˳�
		 if(p.equals("1")){//�����ڴ�
			 while(true){
			 System.out.println("�����������ڴ�Ĵ�С (��x�˳�����0������һ��):");
			 p=sc.next();
			 if(p.equals("x")||p.equals("X")) System.exit(0);//�˳�
			 if(p.equals("0"))break;
			 if(isNumeric(p)){
				 sl.MallocArea1(String.format("%03d",k),Integer.valueOf(p));
				 sl.showArea();
				 k++;
			 }else{
				 System.out.print("�������"); continue;
			 }
			 }
		 }
		 if(p.equals("2")){
			 while(true){
				 System.out.print("�������ͷ���ҵ����(��x�˳�����0������һ��):");
				 p=sc.next();
				 if(p.equals("x")||p.equals("X")) System.exit(0);//�˳�
				 if(p.equals("0"))break;
				 if(isNumeric(p)){
				 sl.FreeArea(p);
				 sl.showArea();
				 }else{
					 System.out.print("�������"); continue;
				 }
				 continue;
			 }
		 }
		 
		 }
	}
	public static boolean isNumeric(String str){//�ж��ַ����Ƿ�Ϊ����
		  for (int i = 0; i < str.length(); i++){
		   System.out.println(str.charAt(i));
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
		 }

}
