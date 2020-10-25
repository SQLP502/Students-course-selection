package Person;

public class Teacher {
	private int teacherid;
	private String teacherName;
	private Course[] courses;

	public Teacher(){
		super();
		courses = new Course[1];
	}

	public Teacher(int teacherid,String teacherName){
		this.teacherid = teacherid;
		this.teacherName = teacherName;
		courses = new Course[1];
	}
	
	public int getTeacherid(){
		return teacherid;
	}
	public void setTeacherid(int teacherid){
		this.teacherid = teacherid;
	}
	public String getTeacherName(){
		return teacherName;
	}
	public void setTeacherName(String teacherName){
		this.teacherName =teacherName;
	}
	
}