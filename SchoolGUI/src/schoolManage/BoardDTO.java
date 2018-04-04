package schoolManage;

public class BoardDTO {	//게시판
	private String title;	//글 제목
	private String write;	//글 내용
	private String ID;//작성자 id
	
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
