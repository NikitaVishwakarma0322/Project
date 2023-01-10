
public class Pizza {

	private int price;

	private Boolean veg;
	private int extraCheesePrice = 100;
	private int extraToppingPrice = 150;
	private int backpackPrice = 20;
	private int BasePizzaPrice;

	private Boolean isExtraCheeseAdded = false;
	private Boolean isExtraToppingAdded = false;
	private Boolean isOptedForTakenAway = false;

	public Pizza(Boolean veg) {
		this.veg = veg;
		if (this.veg) {
			this.price = 300;
		} else {
			this.price = 400;
		}
		BasePizzaPrice = this.price;
	}

	public void addExtraCheese() {
		isExtraCheeseAdded = true;
		System.out.println("Extra Cheese ");
		this.price += extraCheesePrice;
	}

	public void addExtraTopping() {
		isExtraToppingAdded = true;
		System.out.println("Extra Topping ");
		this.price += extraToppingPrice;
	}

	public void takeAway() {
		isOptedForTakenAway = true;
		System.out.println("Take Away ");
		this.price += backpackPrice;
	}

	public void getBill() {
		String bill = "";
		System.out.println("Pizza : " + BasePizzaPrice);
		if (isExtraCheeseAdded) {
			bill += "Extra Cheese Added : " + extraCheesePrice + "\n";
		}

		if (isExtraToppingAdded) {
			bill += "Extra Topping Added : " + extraToppingPrice + "\n";
		}

		if (isOptedForTakenAway) {
			bill += "Take Away" + backpackPrice + "\n";
		}

		bill += "Bill: " + this.price + "\n";
		System.out.println(bill);

	}

}
