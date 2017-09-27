package attendance;

public class Student implements Attendee {
	private String f;
	private String l;
	private boolean present = false;
	public Student(String firstName,String lastName) {
		this.f = firstName;
		this.l = lastName; 
	}
	public boolean isPresent() {
		return present;
	}

	//sets whether the student has been marked present
	public void setPresent(boolean present) {
		this.present = present;
	}

	//returns the firstName
	public String getFirstName() {
		return f;
	}

	//returns the lastNameName
	public String getLastName() {
		return l;
	}

	//returns true if 'first' and 'last' match this Attendee's firstName and lastName. This should NOT be case sensitive. 
	public boolean mathces(String first, String last) {
		return (first.toLowerCase().equals(f.toLowerCase())) && last.toLowerCase().equals(l.toLowerCase());
	}

	
	//returns true if 'first' matches this Attendee's firstName. This should NOT be case sensitive.
	public boolean matches(String last) {
		return last.toLowerCase().equals(l.toLowerCase());
	}

	//returns three words separated by 20 spaces: 
	//at index 0, the last name
	//at index 20, the first name
	//at index 40, the word PRESENT or ABSENT
	//ADDED CHALLENGE:
	//if last name or first name is longer than 20 characters, 
	//cut off the last three letters and replace with "..."
	public String getReportString() {
		String report = l;
		report = restrictStringToLength(report, 20);
		report += f;
		report = restrictStringToLength(report, 40);
		if(present) {
			report += "PRESENT\n"
		}
		else
			report += "ABSENT\n";
		
	}
	public String restrictStringToLength(String s, int length){
		if (s.length() > length) {
			s = s.substring(0, length - 3) + "...";
		}
		while (s.length() < length) {
			s += " ";
		}
		return s;
	}
}