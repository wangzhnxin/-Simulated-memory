//stu:5157101222
//jdk1.7u80 ����ͨ��
public class Shell {
	Page shell[];
	private int length;//����
	public Shell(){}
	public Shell(int length,int size){//ģ���ʼ����ҳ�ڴ�ռ�
		this.length=length;
		shell=new Page[length];
		for(int i=0;i<length;i++){
			this.shell[i]=new Page();
			shell[i].setSize(size);
			shell[i].setBlocknum(i);
		}
	}
	
	public void showArea(){	//��ʾ���з���״̬
		int k=0;//������ҵ����
		System.out.println();
		for(int i=0;i<length;i++){
			if(shell[i].isChange()==false){//��ʾ���п��
				System.out.println("���п��"+shell[i].getBlocknum());
			}else{//��ʾ��ռ�õĿ飬������ռ�õĸ���
				k++;
				System.out.print("��ҵ��:"+shell[i].getPid());
				if(shell[i].getSize()!=shell[i].getVcount()){
					System.out.println(",ҳ��:"+shell[i].getPagenum()+"���:"+shell[i].getBlocknum()+",ռ�ÿռ�:"+shell[i].getVcount());
				}else{
					System.out.println(",ҳ��:"+shell[i].getPagenum()+"���:"+shell[i].getBlocknum());
				}
			}
		}
		System.out.println("\n�ܿ�ţ�"+length+",�ѷ���:"+k+",ʣ����䣺"+(length-k)+" ÿ���С:"+shell[0].getSize());
	}
	public void FreeArea(String pid){//�ͷŷ���
		int flag=0;//�ж���ҵ���Ƿ����
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
		System.out.println("���ͷ� :"+pid+" ��ռ���ڴ�");
		}else{
			System.out.println("��ҵ������");
		}
	}
	public void MallocArea(String pid,int vcount){//�����ڴ�
		int count=0;//���ڴ��С
		int b=0,s=0;//��ռ������������Ĵ�С
		for(int i=0;i<length;i++){
			if(shell[i].isChange()==false){
				count+=shell[i].getSize();//��������ڴ��С
			}
		}
		if(vcount>count){//�ڴ治�����
			System.out.println("�ڴ治�㣡");
			System.out.println("�����ڴ��СΪ:"+vcount+",����û�пռ�ɷ���,����������");
		}else{//�ڴ��㹻�����
			b=vcount/shell[0].getSize()+1;//������ҵ��ռ�õĿ���
			s=vcount%shell[0].getSize();//������ҵ��ռ������Ǹ������Ĵ�С
			int k=0;
			for(int i=0;i<length;i++){//��ʼ�����ڴ�
				if(shell[i].isChange()==false){
					k++;
				  shell[i].setVcount(shell[i].getSize());
				 shell[i].setChange(true);
				 shell[i].setPagenum(k);
				 shell[i].setPid(pid);
				 b--;
				 if(b==0){//�������һ����Ĵ�С
					 shell[i].setVcount(s);break;
				 }
				}
			}
		}
	}
	
}
