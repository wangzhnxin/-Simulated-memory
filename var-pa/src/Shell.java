//stu:5157101222
//jdk1.7u80 ����ͨ��
import java.util.ArrayList;
import java.util.Iterator;
public class Shell {
	private ArrayList<Block> list;
	Iterator<Block> it;
	Shell(int length){ //��ʼ���ڴ濪
		list=new ArrayList<Block>();
		list.add(new Block("free",length,0,false));//����һ�����п�
		list.get(0);
	}
    public void showArea(){//��ʾ�ռ�
    	int k=0,z=0;//���пռ����
    	int fsize=0;//���д�С
    	int usize=0;//�ѷ����С
		it= list.iterator();
		System.out.println("**********************");
		while(it.hasNext()){
				Block b=it.next();				
				if(b.isChange()==false){
					fsize+=b.getLength();
					System.out.println("���� "+
				            (k++)+
							"��ʼ��ַ "+b.getAddr1()+
							"����    "+b.getLength());
					z++;
				}else{
					usize+=b.getLength();
					System.out.println("����"+z+"��ҵ"+b.getData()+"����"+b.getLength()+"��ʼ��ַ"+b.getAddr1());
				}
			}
		System.out.println("**********************");
		System.out.println("*****�ܵ�"+(fsize+usize)+", ���д�С:"+fsize+", �ѷ��������С:"+usize+"*********");
		
    }
    public void MallocArea1(String Data,int length){//���Ӧ�㷨
    	if(list.get(list.size()-1).isChange()==false&&length<=list.get(list.size()-1).getLength()){//�����Ŀ��п�ɷָ�ʱ
    		int lastlength=list.get(list.size()-1).getLength();//��ȡ���һ��Ԫ�صĳ���
    		int lastaddr=list.get(list.size()-1).getAddr1();//��ȡ���һ��Ԫ�ص���ʼ��ַ
    		if(length==list.get(list.size()-1).getLength()){//�����һ����ʹ��
        		list.remove(list.get(list.size()-1));
    			list.add(new Block(Data,length,lastaddr,true));
    		}else{//ʹ�����һ���飬���ֳ�ʣ�µĿռ�
        		list.remove(list.get(list.size()-1));
    			list.add(new Block(Data,length,lastaddr,true));
        		list.add(new Block("free",(lastlength-length),(lastaddr+length),false));
    		}
    	}else{
    	//if(list.get(list.size()-1).isChange()==false&&length>list.get(list.size()-1).getLength()){
       	for(int i=0;i<list.size();i++){//�������ݲ��µ�ʱ��
    		if(list.get(i).isChange()==false){//���µĿ��п�
    			if(length>list.get(i).getLength()){//�Ҳ����µĿ��п�
        			if((list.size()-1)==i){//��ʼ�����ʾ
        				System.out.println("û�п��ÿ�������!!!");
        				System.out.println("�����ڴ��СΪ"+length+",��û�пռ�ɷ���,����������");
        			}else{
        				continue;
        			}
    			}else{//�ҵ��µĿ��п�
    				if(length==list.get(i).getLength()){//�µĿ��п����õ��ڲ����Ĵ�С
    					list.get(i).setChange(false);
    					list.get(i).setData(Data);
    				}else{//�µĿ��п�Ȳ���Ŀ��п�Ҫ��
    					//
    					int temp=list.get(i).getLength()-length;//����ʣ��ռ�ĳ���
    					//�����п�����ʹ�ÿ�
    					list.get(i).setChange(true);
    					list.get(i).setData(Data);
    					list.get(i).setLength(length);
    					//�½�ʣ��ռ�
    					list.add((i+1), new Block("free",temp,(list.get(i).getAddr1()+list.get(i).getLength()),false));
    					break;
    				}
    			}
    		}
    	}
    	}
		
    }
    public void FreeArea(String data){//�ͷŷ���
 		it = list.iterator();
 		boolean flag=false;//����Ƿ��ͷ����ڴ�
 		while(it.hasNext()){
 			Block b=it.next();
 			if(b.getData().equals(data)){
 				b.setChange(false);
 				flag=true;
 			}
 		}
 		merge();
 		if(flag){
				System.out.println("���ͷ�"+data+"���ڴ�");
 		}else{
			System.out.println("û���ҵ�����ҵ��!");
 		}
    }
    public void  merge(){//�ϲ����з���
        for(int i=1;i<list.size();i++){
        	if(list.get(i).isChange()==list.get(i-1).isChange()){
        		list.get(i-1).setLength(list.get(i).getLength()+list.get(i-1).getLength());
        		list.remove(i);
        	}
        }
    }
    
	
}
