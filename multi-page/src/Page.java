//stu:5157101222
//jdk1.7u80 ����ͨ��
public class Page {
	private String pid;//ռ���ڴ���ҵ��
	private int pagenum;//ҳ��
	private int blocknum;//���
	private int vcount;//ռ�ÿռ�
	private boolean change;//ռ��״̬
	private int size=0;//��Ĵ�С
	public Page(){
		setPagenum(-1);
		setBlocknum(-1);
		setVcount(0);
		setChange(false);
	}
	//���´���Ը������Եķ�װ
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getBlocknum() {
		return blocknum;
	}
	public void setBlocknum(int blocknum) {
		this.blocknum = blocknum;
	}
	public int getVcount() {
		return vcount;
	}
	public void setVcount(int vcount) {
		this.vcount = vcount;
	}
	public boolean isChange() {
		return change;
	}
	public void setChange(boolean change) {
		this.change = change;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
