package attendance;

public class Student implements Attendee {
	private String f;
	private String l;
	public Student(String firstName,String lastName) {
		this.f = firstName;
		this.l = lastName; 
	}
}