public class EconomySeat extends Seat {

	private String FoodPreferences = "Chicken";
	private String DrinkPreferences = "Cola";
	
	public EconomySeat(char columnNum ,int rowNum , String seatNumber ,
			String FoodPreferences , String DrinkPreferences) {
		super(columnNum,rowNum,seatNumber);
		this.FoodPreferences  = FoodPreferences;
		this.DrinkPreferences = DrinkPreferences;
	}

	public String getFoodPreferences() {
		return FoodPreferences;
	}

	public void setFoodPreferences(String FoodPreferences) {
		if (FoodPreferences.trim().equalsIgnoreCase("Chicken") || FoodPreferences.trim().equalsIgnoreCase("Fish"))
			this.FoodPreferences = FoodPreferences;
		else
			System.out.println("Sorry, There are only Chicken and Fish!");
	}

	public String getDrinkPreferences() {
		return DrinkPreferences;
	}

	public void setDrinkPreferences(String DrinkPreferences) {
		if (DrinkPreferences.trim().equalsIgnoreCase("Cola") || DrinkPreferences.trim().equalsIgnoreCase("Juice"))
			this.DrinkPreferences = DrinkPreferences;
		else
			System.out.println("Sorry, There are only Cola and Juice!");
	}

	@Override
	public String toString() {
		return "FirstClassSeat [FoodPreferences=" + this.FoodPreferences + ", DrinkPreferences=" + this.DrinkPreferences
				+ "]";
	}

} 