public abstract class Seat {

	private int rowNum;
	private char columnNum;
	private String seatNum;
	private boolean seatReserved;
	private String typeOfSeat;
	private Passenger Passenger1;

	public Seat(char columnNum, int rowNum, String seatNum) {
		this.rowNum = rowNum;
		this.columnNum = columnNum;
		this.seatNum = seatNum;
		this.seatReserved = false;
	}

	public Seat(Passenger Passenger1) {
		this.Passenger1 = Passenger1;
	}

	public Passenger getPassenger() {
		return Passenger1;
	}

	public void setPassenger(Passenger Passenger1) {
		this.Passenger1 = Passenger1;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getColumnNum() {
		return columnNum;
	}

	public void setColumnNum(char columnNum) {
		this.columnNum = columnNum;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	public boolean getSeatReserved() {
		return seatReserved;
	}

	public void setSeatReserved(boolean seatReserved) {
		this.seatReserved = seatReserved;
	}

	public String getTypeOfSeat() {
		return typeOfSeat;
	}

	public void setTypeOfSeat(String typeOfSeat) {
		this.typeOfSeat = typeOfSeat;
	}

	public abstract String toString();

}
