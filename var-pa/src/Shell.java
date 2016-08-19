//stu:5157101222
//jdk1.7u80 测试通过
import java.util.ArrayList;
import java.util.Iterator;
public class Shell {
	private ArrayList<Block> list;
	Iterator<Block> it;
	Shell(int length){ //初始化内存开
		list=new ArrayList<Block>();
		list.add(new Block("free",length,0,false));//生成一个空闲块
		list.get(0);
	}
    public void showArea(){//显示空间
    	int k=0,z=0;//空闲空间个数
    	int fsize=0;//空闲大小
    	int usize=0;//已分配大小
		it= list.iterator();
		System.out.println("**********************");
		while(it.hasNext()){
				Block b=it.next();				
				if(b.isChange()==false){
					fsize+=b.getLength();
					System.out.println("空闲 "+
				            (k++)+
							"起始地址 "+b.getAddr1()+
							"长度    "+b.getLength());
					z++;
				}else{
					usize+=b.getLength();
					System.out.println("分配"+z+"作业"+b.getData()+"长度"+b.getLength()+"起始地址"+b.getAddr1());
				}
			}
		System.out.println("**********************");
		System.out.println("*****总的"+(fsize+usize)+", 空闲大小:"+fsize+", 已分配区域大小:"+usize+"*********");
		
    }
    public void MallocArea1(String Data,int length){//最坏适应算法
    	if(list.get(list.size()-1).isChange()==false&&length<=list.get(list.size()-1).getLength()){//单最后的空闲块可分割时
    		int lastlength=list.get(list.size()-1).getLength();//获取最后一个元素的长度
    		int lastaddr=list.get(list.size()-1).getAddr1();//获取最后一个元素的起始地址
    		if(length==list.get(list.size()-1).getLength()){//将最后一个块使用
        		list.remove(list.get(list.size()-1));
    			list.add(new Block(Data,length,lastaddr,true));
    		}else{//使用最后一个块，并分出剩下的空间
        		list.remove(list.get(list.size()-1));
    			list.add(new Block(Data,length,lastaddr,true));
        		list.add(new Block("free",(lastlength-length),(lastaddr+length),false));
    		}
    	}else{
    	//if(list.get(list.size()-1).isChange()==false&&length>list.get(list.size()-1).getLength()){
       	for(int i=0;i<list.size();i++){//当最后块容不下的时候
    		if(list.get(i).isChange()==false){//找新的空闲块
    			if(length>list.get(i).getLength()){//找不到新的空闲块
        			if((list.size()-1)==i){//开始输出提示
        				System.out.println("没有可用空闲区域!!!");
        				System.out.println("申请内存大小为"+length+",但没有空间可分配,请重新输入");
        			}else{
        				continue;
        			}
    			}else{//找到新的空闲块
    				if(length==list.get(i).getLength()){//新的空闲块正好等于插入块的大小
    					list.get(i).setChange(false);
    					list.get(i).setData(Data);
    				}else{//新的空闲块比插入的空闲块要大
    					//
    					int temp=list.get(i).getLength()-length;//计算剩余空间的长度
    					//将空闲块变成已使用块
    					list.get(i).setChange(true);
    					list.get(i).setData(Data);
    					list.get(i).setLength(length);
    					//新建剩余空间
    					list.add((i+1), new Block("free",temp,(list.get(i).getAddr1()+list.get(i).getLength()),false));
    					break;
    				}
    			}
    		}
    	}
    	}
		
    }
    public void FreeArea(String data){//释放分区
 		it = list.iterator();
 		boolean flag=false;//标记是否释放了内存
 		while(it.hasNext()){
 			Block b=it.next();
 			if(b.getData().equals(data)){
 				b.setChange(false);
 				flag=true;
 			}
 		}
 		merge();
 		if(flag){
				System.out.println("已释放"+data+"的内存");
 		}else{
			System.out.println("没有找到该作业名!");
 		}
    }
    public void  merge(){//合并空闲分区
        for(int i=1;i<list.size();i++){
        	if(list.get(i).isChange()==list.get(i-1).isChange()){
        		list.get(i-1).setLength(list.get(i).getLength()+list.get(i-1).getLength());
        		list.remove(i);
        	}
        }
    }
    
	
}
