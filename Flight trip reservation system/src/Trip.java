public class Trip implements Comparable <Trip> {

	 Seat[][] ragArrayOfSeats;
	private String FlightNum;
	private String AirportName;
	private String ToAirportName;
	private String TripDistance;
	private String DepartureTime;
	private String ArrivalTime;

	public Trip(Seat[][] ragArrayOfSeats, String FlightNum, String AirportName, String ToAirportName,
		String TripDistance, String DepartureTime, String ArrivalTime) {
		this.ragArrayOfSeats = ragArrayOfSeats;
		this.FlightNum = FlightNum;
		this.AirportName = AirportName;
		this.ToAirportName = ToAirportName;
		this.TripDistance = TripDistance;
		this.DepartureTime = DepartureTime;
		this.ArrivalTime = ArrivalTime;
	} 
	@Override
	public String toString() {
		return "Trip [FlightNum : " + FlightNum + " , AirportName : " + AirportName + " , ToAirportName : " + ToAirportName
				+ " , T.D : " + TripDistance + " , D.T : " + DepartureTime + " , A.T : " + ArrivalTime
				+ "]";
	}

	public Seat[][] getRagArrayOfSeats() {
		return ragArrayOfSeats;
	}

	public void setRagArrayOfSeats(Seat[][] ragArrayOfSeats) {
		this.ragArrayOfSeats = ragArrayOfSeats;
	}

	public String getFlightNum() {
		return FlightNum;
	}

	public void setFlightNum(String FlightNum) {
		this.FlightNum = FlightNum;
	}

	public String getAirportName() {
		return AirportName;
	}

	public void setAirportName(String AirportName) {
		this.AirportName = AirportName;
	}

	public String getToAirportName() {
		return ToAirportName;
	}

	public void setToAirportName(String ToAirportName) {
		this.ToAirportName = ToAirportName;
	}

	public String getTripDistance() {
		return TripDistance;
	}

	public void setTripDistance(String TripDistance) {
		this.TripDistance = TripDistance;
	}

	public String getDepartureTime() {
		return DepartureTime;
	}

	public void setDepartureTime(String DepartureTime) {
		this.DepartureTime = DepartureTime;
	}

	public String getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(String ArrivalTime) {
		this.ArrivalTime = ArrivalTime;
	}
	
	public String forFile() {
		String s = "";
		//CAN234:Cairo:Vancouver:3456:15/5/2020:16/5/2020
		s+= this .FlightNum+":"+this.AirportName+":"+this.ToAirportName+":"+this.TripDistance+":"+this.DepartureTime+":"+this.ArrivalTime;
		return s ;
	}
	
	@Override
	public int compareTo(Trip o) {
		if (this.FlightNum.compareTo(o.FlightNum) > 0)
		return 1;
		if (this.FlightNum.compareTo(o.FlightNum) == 0)
			return 0;
		else 
			return -1 ;
	}
}