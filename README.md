# Students-course-selection  
## 实验目的
初步了解分析系统需求，从学生选课角度了解系统中的实体及其关系，学会定义类中的属性以及方法；  
掌握面向对象的类设计方法（属性、方法）；  
掌握类的继承用法，通过构造方法实例化对象；  
学会使用super()，用于实例化子类；  
掌握使用Object根类的toString（）方法,应用在相关对象的信息输出中。  
## 业务要求
说明：学校有“人员”，分为“教师”和“学生”，教师教授“课程”，学生选择“课程”。  
     从简化系统考虑，每名教师仅教授一门课程，每门课程的授课教师也仅有一位，每名学生选仅选一门课程。
对象：	人员（编号、姓名、性别）  
      教师（编号、姓名、性别、所授课程）  
			学生（编号、姓名、性别、所选课程）  
			课程（编号、课程名称、上课地点、时间、授课教师）  
## 实验要求
1.编写上述实体类以及测试主类（注意类之间继承关系的适用）  
2.在测试主类中，实例化多个类实体，模拟学生选课操作、打印课程信息（信息包括：编号、课程名称、上课地点、时间、授课教师）；模拟学生退课操作，再打印课程信息。  
3.编写实验报告。  
## 实验过程 
1、先写出teacher的变量  
```
public class Teacher {
	private int teacherid;
	private String teacherName;
	private Course[] courses;
```  
构造函数Teacher  
```
public Teacher(){
		super();
		courses = new Course[1];
	}
```  
对Teacher函数的运用  
```
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
```  
2、对于学生类  
```
public class Student {
	private String stuName;
    private int stuId;
    private String major;
    private Course[] courses;
 ```  
 构造学生函数  
 ```
  //构造函数
    public Student() {
        super();
        courses = new Course[3];
    }
    public Student(int stuId,String stuName) {
        super();
        this.stuId=stuId;
        this.stuName=stuName;
        courses = new Course[3];
    }
    public Student(int stuId,String stuName,String major) {
        super();
        this.stuId=stuId;
        this.stuName=stuName;
        this.major = major;
        courses = new Course[3];
    }
 ```  
 修改获取属性  
 ```
  //修改获取属性name,id,major
    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public int getStuId() {
        return stuId;
    }
    public void setStuId(int stuId) {
        this.stuId = stuId;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
```  
学生选课  
```
//学生选课；
    public boolean addCourse(Course course){
        boolean flag=false;
        if(!isSelectedCourse(course)&&isNullCourse(course)){
            for(int i=0;i<this.courses.length;i++){
                if(courses[i]==null){
                    courses[i]=course;
                    course.addStudent(this);//课程也要添加学生
                    flag=true;
                    break;
                }
            }
        }
        return flag;
    }
```  
学生移除课程  
```
//学生移除课程
    public boolean removeCourse(Course course){
        boolean flag=false;
        if(isSelectedCourse(course)){
            for(int i=0;i<this.courses.length;i++){
                if(courses[i]==course){
                    courses[i]=null;
                    course.removeStudent(this);//在课程中移除学生
                    flag=true;
                    break;
                }
            }

        }
        return flag;
    }

```
显示学生所选课程  
```
//显示学生所选的课程
    public void displayCourse(){
        System.out.println("学生"+this.stuName+"所选课程有：");
        for(Course c:courses){
            if(c!=null){
                System.out.print(c.getName()+" ");
            }
        }
        System.out.println();
    }
```
判断课是否已经选过  
```
//子方法1：课是否被选过
    public boolean isSelectedCourse(Course course){
        boolean flag=false;
        for(Course c:courses){
            if(c==course){
                flag=true;
                break;
            }
        }
        return flag;
    }
```
判断学生是否还有选课位置  
```
//子方法2：学生是否还有选修课位置
    public boolean isNullCourse(Course course){
        boolean flag=false;
        for(Course c:courses){
            if(c==null){
                flag=true;
                break;
            }
        }
        return flag;
    }
```
3、接下来是对course的变量定义  
```
public class Course{
	private int courseId;
	private String courseName;
	private Teacher teacher;
	private float credit;
	private Student[] students;
```
课移除学生  
```
//课移除学生
public boolean removeStudent(Student stu){
    boolean flag=false;
    if(isSelectedStudent(stu)){//选过这门课
        for(int i=0;i<students.length;i++){
            if(students[i]==stu){
                students[i]=null;
                flag=true;
                break;
            }
        }
    }
    return flag;
}
```  
显示选择课程的学生  
```
//显示选择课程的学生：
public void displayStudent(){
    System.out.println("选择的课程："+this.courseName+"的学生有:");
    for(Student s:students){
        if(s!=null){
            System.out.print(s.getStuName()+" ");
        }
    }
    System.out.println();
}
```  
判断学生是否选过这门课  
```
//子方法1：学生是否选过这门课
public boolean isSelectedStudent(Student stu){
    boolean flag=false;
    for(Student s:students){//只能用于检查，不能修改
        if(s==stu){
            flag=true;
            break;
        }
    }
    return flag;
}
```  
判断学科学生课容量是否已达上限
//子方法2：学科学生课容量是否达到限定人数
```
public boolean isNullStudent(Student stu){
    boolean flag=false;
    for(Student s:students){
        if(s==null){//还有空位
            flag=true;
            break;
        }
    }
    return flag;
}
```  
4、设计Test类  
```
public class Test {
	public static void main(String[] args) {
        Student stu0 = new Student(1001,"Lily");
        Student stu1 = new Student(1002,"Eilly");
        Student stu2 = new Student(1003,"Floris");
        Student stu3 = new Student(1004,"HaHa");
        Course cour0 = new Course(001,"高数");
        Course cour1 = new Course(002,"线代");
        Course cour2 = new Course(003,"概率论");
        stu0.addCourse(cour0);
        stu0.addCourse(cour2);
        stu0.addCourse(cour1);
        stu1.addCourse(cour2);
        stu1.addCourse(cour0);
        stu2.addCourse(cour1);
        stu3.addCourse(cour0);
        stu3.addCourse(cour1);
        stu1.removeCourse(cour2);
        stu0.displayCourse();
        cour0.removeStudent(stu1);
        cour1.displayStudent();
    }

```  
## 实验感想  
这次实验做的是学生选课系统，是我们接触过的已经完成的案例之一。虽然知道应该有什么部分组成，但实际操练起来还是有点费劲，对于Java知识点的学习和理解还不透彻。这次实验用到很多判断的语法，if的使用，都是基本语法点。以我现在所学还没办法把这个选课系统做得很好，后续的继续学习，我会继续改进我的程序，力争完美！
