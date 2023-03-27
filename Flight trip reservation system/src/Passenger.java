public class Passenger extends Person implements Comparable<Passenger> {

	private String Nationality;
	private boolean HasVISA;
	private String HasFlightSeat = "Window";
	private int PassportNum;

	String seatNum;

	public Passenger(String FirstName, String LastName, char Gender, String DOB, int PassportNum, String Nationality,
			boolean HasVISA, String HasFlightSeat) {
		super(FirstName, LastName, Gender, DOB);
		Gender = Character.toUpperCase(Gender);
		if (Character.isLetter(Gender)) {
			if (Gender == 'M' || Gender == 'F')
				this.Gender = Gender;
			else
				System.out.println("Please enter M or F !!");
		} else
			System.out.println("Please enter an alphapet");
		this.PassportNum = PassportNum;
		this.Nationality = Nationality;
		this.HasVISA = HasVISA;
		this.HasFlightSeat = HasFlightSeat;
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
		if (Gender == 'M' || Gender < 'F')
			this.Gender = Gender;
		else
			System.out.println("Error: Please enter (M or F)");
	}

	public int getPassportNum() {
		return PassportNum;
	}

	public void setPassportNum(int PassportNum) {
		this.PassportNum = PassportNum;
	}

	// JAP123:C12:Mahmoud AbdelKareem: M: 2/9/1980: 4567: Palestinian: Aisle
	public String toFile() {

		String s = this.seatNum;

		s += this.FirstName + " " + this.LastName + ":" + this.Gender + ":" + this.DOB + ":" + this.PassportNum + ":"
				+ this.Nationality + ":" + this.HasFlightSeat;
		return s;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String Nationality) {
		this.Nationality = Nationality;
	}

	public boolean isHasVISA() {
		return HasVISA;
	}

	public void setHasVISA(boolean HasVISA) {
		this.HasVISA = HasVISA;
	}

	public String getHasFlightSeat() {
		return HasFlightSeat;
	}

	public void setHasFlightSeat(String HasFlightSeat) {
		this.HasFlightSeat = HasFlightSeat;
	}

	@Override
	public String toString() {
		return "Passenger [FirstName : " + super.FirstName + " , LastName : " + super.LastName + " , Gender : "
				+ super.Gender + " , DOB : " + super.DOB + " , PassportNum : " + PassportNum + " , Nationality : "
				+ Nationality + " , HasVISA : " + HasVISA + " , HasFlightSeat : " + HasFlightSeat + "";
	}

	@Override
	public int compareTo(Passenger p1) {
		return Integer.compare(this.PassportNum, p1.PassportNum);
	}
}