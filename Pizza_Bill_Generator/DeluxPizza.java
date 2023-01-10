
public class DeluxPizza extends Pizza{

	public DeluxPizza(Boolean veg) {
		super(veg);
		super.addExtraCheese();
		super.addExtraTopping();

	}

	@Override
	public void addExtraCheese() {}

	@Override
	public void addExtraTopping() {}
	
	

}
