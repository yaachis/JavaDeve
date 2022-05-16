package school;

import java.util.* ;

public class School { 
private Course[] courses; 
private Student[] students;

public School(Course[] courses) {
this.courses = courses; 

int numOfStudents = 0; 
for(Course course : courses) 
numOfStudents += course.getStudents().length;

students = new Student[numOfStudents];
}

public void register(Student...students) { 
if(isFull())
throw new IllegalStateException("Cannot register anymore students at this time");

for(Student student : students) {
if(Array.asList(this.students).contains(student))
throw new IllegalArgumentException("You cannot add the same student to a school twice");



for(Course course : courses) { 
if(student.prefersCourse(course) && !course.isFull()) 
student.assignCourse(course);
}
		
verifyStudent(student);
student.setSchool(this);
for(int i = 0; i < this.students.length; i++) { 
if(this.students[i] == null) {
	this.students[i] = student;
	break;
}
}
}
}
 
private void verifyStudent(Student student) {
verifyCourses(student);
}

private void verifyCourses(Student student) {
boolean verified = false;

while(!verified) {
for(Course course : student.getCourses()) { 
if(course == null) {
int index = (int) (Math.random() * courses.length); 
student.assignCourse(courses[index]);
}
}

verified = !Arrays.asList(student.getCourses()).contains(null);
}
}

public Student[] getStudents() { 
return Arrays.copyOf(students, students.length);
}

public Course[] getCourses() { 
return Arrays.copyOf(courses, courses.length);
}
public boolean isFull() {
boolean full = true; 
for(Student student : students) 
	
	if(student == null)
		return full = false;

return full;
}
}