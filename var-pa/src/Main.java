//stu:5157101222
//jdk1.7u80 测试通过
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		 Scanner sc=new Scanner(System.in);
		 Shell sl=new Shell(670);
		 String p;
		 int k=1;
		 while(true){
			 sl.showArea();
		 System.out.println("\t不固定分区内存管理");
		 System.out.println("\t x退出 \t 1申请内存\t 2释放内存");
		 p=sc.next();
		 if(p.equals("x")||p.equals("X"))break;//退出
		 if(p.equals("1")){//申请内存
			 while(true){
			 System.out.println("请输入申请内存的大小 (按x退出，按0返回上一级):");
			 p=sc.next();
			 if(p.equals("x")||p.equals("X")) System.exit(0);//退出
			 if(p.equals("0"))break;
			 if(isNumeric(p)){
				 sl.MallocArea1(String.format("%03d",k),Integer.valueOf(p));
				 sl.showArea();
				 k++;
			 }else{
				 System.out.print("输入错误！"); continue;
			 }
			 }
		 }
		 if(p.equals("2")){
			 while(true){
				 System.out.print("请输入释放作业名：(按x退出，按0返回上一级):");
				 p=sc.next();
				 if(p.equals("x")||p.equals("X")) System.exit(0);//退出
				 if(p.equals("0"))break;
				 if(isNumeric(p)){
				 sl.FreeArea(p);
				 sl.showArea();
				 }else{
					 System.out.print("输入错误！"); continue;
				 }
				 continue;
			 }
		 }
		 
		 }
	}
	public static boolean isNumeric(String str){//判断字符串是否为数字
		  for (int i = 0; i < str.length(); i++){
		   System.out.println(str.charAt(i));
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
		 }

}
