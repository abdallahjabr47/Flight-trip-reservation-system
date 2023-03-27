public class FirstClassSeat extends Seat {

	private String FoodPreferences = "Steak";
	private String DrinkPreferences = "Carob";
	
	public FirstClassSeat(char columnNum ,int rowNum,  String seatNumber ,
			String FoodPreferences , String DrinkPreferences) {
		super(columnNum ,rowNum, seatNumber);
		this.FoodPreferences  = FoodPreferences;
		this.DrinkPreferences = DrinkPreferences;
	}
	
	public FirstClassSeat(Passenger Passenger1) {
		super(Passenger1);
	}

	public String getFoodPreferences() {
		return FoodPreferences;
	}

	public void setFoodPreferences(String FoodPreferences) {
		if (FoodPreferences.trim().equalsIgnoreCase("Caviar") || FoodPreferences.trim().equalsIgnoreCase("Steak"))
			this.FoodPreferences = FoodPreferences;
		else
			System.out.println("Sorry, There are only Caviar and Steak!");
	}

	public String getDrinkPreferences() {
		return DrinkPreferences;
	}

	public void setDrinkPreferences(String DrinkPreferences) {
		if (DrinkPreferences.trim().equalsIgnoreCase("Liquorice") || DrinkPreferences.trim().equalsIgnoreCase("Carob"))
			this.DrinkPreferences = DrinkPreferences;
		else
			System.out.println("Sorry, There are only Liquorice and Carob!");
	}

	@Override
	public String toString() {
		return "FirstClassSeat [FoodPreferences=" + this.FoodPreferences + ", DrinkPreferences=" + this.DrinkPreferences
				+ "]";
	}
}
