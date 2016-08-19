//stu:5157101222 
//jdk1.7u80 ����ͨ��
public class Block {
	private String Data;//����
	private int addr1;//��ʼ��ַ
	private int length;//��������
	private boolean change;//���ռ��״̬��
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public int getAddr1() {
		return addr1;
	}
	public void setAddr1(int addr1) {
		this.addr1 = addr1;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Block(){}
	public Block(String data){
		setData(data);
	}
	public Block(String data,int length){
		this(data);
		setLength(length);
	}
	public Block(String data,int length,int addr1){
		this(data,length);
		setAddr1(addr1);
	}
	public Block(String data,int length,int addr1,boolean change){
		this(data,length,addr1);
		setChange(change);
	}
	public boolean isChange() {
		return change;
	}
	public void setChange(boolean change) {
		this.change = change;
	}
}
