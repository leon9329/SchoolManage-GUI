package schoolManage;
import java.util.ArrayList;
import java.util.List;

//Student DTO
public class StudentDTO implements PersonDTO {
	private String classOf; // 학번
	private String name; // 이름
	private String sex; // 성별
	private String age; // 나이
	private String id;

	private String password = "a";
	
	List<String> subject = new ArrayList<String>();
	
	StudentDTO(){};
	
	StudentDTO(String classOf, String name, String sex, String age) {
		this.classOf = classOf;
		this.name = name;
		this.sex = sex;
		this.age = age;

	}
	
	StudentDTO(String id, String classOf, String name, String sex, String age) {
		this.id = id;
		this.classOf = classOf;
		this.name = name;
		this.sex = sex;
		this.age = age;
		

	}
	
	public void setID(String id) {
		this.id = id;
	}

	public void setClassOf(String classOf) {
		this.classOf = classOf;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setAge(String age) {
		this.age = age;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getID() {
		return id;
	}
	
	public String getClassOf() {
		return classOf;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public String getAge() {
		return age;
	}

	
	
	public String getPassword() {
		return password;
	}
	
	
}
