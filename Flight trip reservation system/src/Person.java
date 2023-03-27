public abstract class Person  {

	protected String FirstName;
	protected String LastName;
	protected char Gender;
	protected String DOB = "2000,2,5";

	public Person(String FirstName, String LastName, char Gender, String DOB) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Gender = Gender;
		this.DOB = DOB;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public char getGender() {
		return Gender;
	}

	public void setGender(char Gender) {
		this.Gender = Gender;
	}

	public String getDateOfBirth() {
		return DOB;
	}

	public void setDateOfBirth(String DOB) {
		this.DOB = DOB;
	}
	
	public abstract String toString();

}