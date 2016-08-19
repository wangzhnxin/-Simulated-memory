//stu:5157101222
//jdk1.7u80 测试通过
public class Shell {
	Page shell[];
	private int length;//长度
	public Shell(){}
	public Shell(int length,int size){//模拟初始化分页内存空间
		this.length=length;
		shell=new Page[length];
		for(int i=0;i<length;i++){
			this.shell[i]=new Page();
			shell[i].setSize(size);
			shell[i].setBlocknum(i);
		}
	}
	
	public void showArea(){	//显示所有分区状态
		int k=0;//分配作业计数
		System.out.println();
		for(int i=0;i<length;i++){
			if(shell[i].isChange()==false){//显示空闲块号
				System.out.println("空闲块号"+shell[i].getBlocknum());
			}else{//显示被占用的块，并计算占用的个数
				k++;
				System.out.print("作业号:"+shell[i].getPid());
				if(shell[i].getSize()!=shell[i].getVcount()){
					System.out.println(",页号:"+shell[i].getPagenum()+"块号:"+shell[i].getBlocknum()+",占用空间:"+shell[i].getVcount());
				}else{
					System.out.println(",页号:"+shell[i].getPagenum()+"块号:"+shell[i].getBlocknum());
				}
			}
		}
		System.out.println("\n总块号："+length+",已分配:"+k+",剩余分配："+(length-k)+" 每块大小:"+shell[0].getSize());
	}
	public void FreeArea(String pid){//释放分区
		int flag=0;//判断作业名是否存在
		for(int i=0;i<length;i++){
			if(pid.equals(shell[i].getPid())){
			  flag=1;
			  shell[i].setPid("-1");
			  shell[i].setChange(false);
			  shell[i].setPagenum(-1);
			  shell[i].setVcount(0);
			}
		}
		if(flag==1){
		System.out.println("已释放 :"+pid+" 所占用内存");
		}else{
			System.out.println("作业不存在");
		}
	}
	public void MallocArea(String pid,int vcount){//申请内存
		int count=0;//总内存大小
		int b=0,s=0;//所占块数，和最后块的大小
		for(int i=0;i<length;i++){
			if(shell[i].isChange()==false){
				count+=shell[i].getSize();//计算空闲内存大小
			}
		}
		if(vcount>count){//内存不足情况
			System.out.println("内存不足！");
			System.out.println("申请内存大小为:"+vcount+",但是没有空间可分配,请重新输入");
		}else{//内存足够的情况
			b=vcount/shell[0].getSize()+1;//计算作业所占用的块数
			s=vcount%shell[0].getSize();//计算作业所占用最后那个块数的大小
			int k=0;
			for(int i=0;i<length;i++){//开始申请内存
				if(shell[i].isChange()==false){
					k++;
				  shell[i].setVcount(shell[i].getSize());
				 shell[i].setChange(true);
				 shell[i].setPagenum(k);
				 shell[i].setPid(pid);
				 b--;
				 if(b==0){//设置最后一个块的大小
					 shell[i].setVcount(s);break;
				 }
				}
			}
		}
	}
	
}
