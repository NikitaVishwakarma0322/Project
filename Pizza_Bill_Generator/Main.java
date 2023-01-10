
public class Main {

	public static void main(String[] args) {
		Pizza basePizza = new Pizza(true);
		basePizza.addExtraCheese();
		basePizza.addExtraTopping();
		basePizza.takeAway();
		basePizza.getBill();
		
		
		DeluxPizza dp = new DeluxPizza(false);
		dp.addExtraCheese();
		
		dp.getBill();
		
		
		
	}
}
