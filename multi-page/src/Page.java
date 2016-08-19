//stu:5157101222
//jdk1.7u80 测试通过
public class Page {
	private String pid;//占用内存作业名
	private int pagenum;//页号
	private int blocknum;//块号
	private int vcount;//占用空间
	private boolean change;//占用状态
	private int size=0;//块的大小
	public Page(){
		setPagenum(-1);
		setBlocknum(-1);
		setVcount(0);
		setChange(false);
	}
	//以下代码对各个属性的封装
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
