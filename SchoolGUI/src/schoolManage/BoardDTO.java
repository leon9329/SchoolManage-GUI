package schoolManage;

public class BoardDTO {	//�Խ���
	private String title;	//�� ����
	private String write;	//�� ����
	private String ID;//�ۼ��� id
	
	BoardDTO(String title, String write, String ID){
		this.title = title;
		this.write = write;
		this.ID = ID;
	};

	
	
	void setTitle(String title) {
		this.title = title;
	}
	
	String getTitle() {
		return title;
	}
	void setWrite(String write) {
		this.write = write;
	}
	
	String getWrite() {
		return write;
	}
	void setID(String ID) {
		//this.ID = ID;
	}
	
	String getID() {
		return ID;
	}
	
}
