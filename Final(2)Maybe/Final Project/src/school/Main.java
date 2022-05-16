package school;
import school.*;
	
public class Main { 
  public static void main(String[] args) {
	Teacher phil = new Teacher("Phil");
	Teacher bill = new Teacher("Bill");
    Teacher lil = new Teacher("Lil"); 
	Teacher joe = new Teacher("Joe"); 
	  
	Course[] courses= {
	 new NetworkCourse(15, phil),
	 new SwingCourse(30, bill),
	 new APIDesignCourse(50, lil),
	 new PerformanceCourse(5, joe)
	};
	School school = new School(courses); 
	
	Student ludwig = new Student("Ludwig"); 
	Student cam = new Student("Cam"); 
	Student daniel = new Student("Daniel");
	ludwig.setPreferredCourses(NetworkCourse.class, SwingCourse.class); 
	cam.setPreferredCourses(SPIDesignCourse.class, PerformanceCourse.class, NetworkCourse.class);
	
	school.register(ludwig, cam, daniel);
	
	test(school);
  }
  
static void test(School school) { 

	System.out.println("Students and their courses:");
	for(Student student : school.getStudents()) { 
	 if(student != null) { 
	   String message = student.getName() + " is taking";
	   
	for(Course course : student.getCourses()) 
	 message += "-" +course.getName(); 

	System.out.println(message);
	 }
}

System.out.println("\nCourses and their students:");
for(Course course : school.getCourse()) {
   String message = course.getName() + " is taken by";
   
   for(Student student : course.getStudents()) {
	   if(student != null)
		   message += "-" + student.getName();
   }
   System.out.println(message);
}
}
}
   

	
