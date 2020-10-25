package Person;

public class Student {
	private String stuName;
    private int stuId;
    private String major;
    private Course[] courses;
    //构造函数
    public Student() {//不要忘
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



}
    