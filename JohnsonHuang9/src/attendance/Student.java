package attendance;

public class Student implements Attendee {
	private String f;
	private String l;
	private boolean inClass = false;
	public Student(String firstName,String lastName) {
		this.f = firstName;
		this.l = lastName; 
	}
}