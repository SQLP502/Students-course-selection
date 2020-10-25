package Person;

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

}