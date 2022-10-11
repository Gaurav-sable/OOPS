import java.util.Scanner;

class Student {
    public String name;
    public int age;
    public String email;
    public int courseCode;

    public void addStudent(int courseCode, String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.courseCode = courseCode;
    }

    public void display() {
        System.out.println("Students in this course =>");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }
}

class Course extends Student {
    public int code;
    public String name;
    public String duration;
    public int assignments;
    public String instructor;
    public int fees;
    public String lastDate;

    public void addCourse(int code, String name, String duration, int assignments, String instructor, int fees,
            String lastDate) {
        this.code = code;
        this.name = name;
        this.duration = duration;
        this.assignments = assignments;
        this.instructor = instructor;
        this.fees = fees;
        this.lastDate = lastDate;
    }

    public void display() {
        System.out.println("Code: " + code);
        System.out.println("Name: " + name);
        System.out.println("Instructor: " + instructor);
        System.out.println("Duration: " + duration);
        System.out.println("Fees: Rs." + fees);
        System.out.println("No. of assignments: " + assignments);
        System.out.println("Last date of enrollment: " + lastDate);
        System.out.println("\n");
    }
}

class EduOrg extends Course {
    public int noOfStudents = 0;
    // private int noOfCourses;
    Course[] c = new Course[3];

    Student[] s = new Student[5];

    public void displayCourses() {
        for (int i = 0; i < 3; i++) {
            c[i].display();
        }
    }
}

public class lab_ques {

    public static void main(String[] args) {
        int count = 0;
        EduOrg PICT = new EduOrg();

        PICT.c[0] = new Course();
        PICT.c[0].addCourse(1, "Web Development", "60 hours", 15, "Mr. AB CD", 455, "30/09/2021");
        PICT.c[1] = new Course();
        PICT.c[1].addCourse(2, "Data Structures and Algorithms", "50 hours", 10, "Mr. EF GH", 490, "25/09/2021");
        PICT.c[2] = new Course();
        PICT.c[2].addCourse(3, "Android Development", "40 hours", 8, "Mr. HI JK", 455, "11/10/2021");

        System.out.println("1. View all courses");
        System.out.println("2. Enroll for course");
        System.out.println("3. View students of a course");
        System.out.println("0. Exit");

        while (true) {
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    PICT.displayCourses();
                    break;

                case 2:
                    System.out.println("Enter your name");
                    String name = sc.next();
                    System.out.println("Enter your age");
                    int age = sc.nextInt();
                    System.out.println("Enter your email");
                    String email = sc.next();
                    System.out.println("Enter course code");
                    int courseCode = sc.nextInt();
                    PICT.s[count] = new Student();
                    PICT.s[count++].addStudent(courseCode, name, age, email);
                    break;

                case 3:
                    System.out.println("Enter the course code:");
                    int code = sc.nextInt();
                    if (code == 1) {
                        for (int i = 0; i < count; i++) {
                            if (PICT.s[i].courseCode == 1) {
                                PICT.s[i].display();
                            }
                        }
                    } else if (code == 2) {
                        for (int i = 0; i < count; i++) {
                            if (PICT.s[i].courseCode == 2) {
                                PICT.s[i].display();
                            }
                        }
                    } else if (code == 3) {
                        for (int i = 0; i < count; i++) {
                            if (PICT.s[i].courseCode == 3) {
                                PICT.s[i].display();
                            }
                        }
                    } else
                        System.out.println("There are no students in this course");
                    break;

                case 0:
                    System.exit(0);

                default:
                    break;
            }
            sc.close();
        }
    }
}
