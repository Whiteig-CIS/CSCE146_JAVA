/*
 * Written by Isaac White
 */
public class Order implements Comparable<Order>
{
	public String customer;
	public String foodOrder;
	public int cookingTime;
	public int arrivalTime;
	public int cookTimeLeft;
	
	public Order()
	{
		this.customer = "none";
		this.foodOrder = "none";
		this.cookingTime = 1;
		this.arrivalTime = 0;
		this.cookTimeLeft = this.cookingTime;
	}
	public Order(String aCustomer, String aFoodOrder, int aCookTime, int aArrival)
	{
		this.setCustomer(aCustomer);
		this.setFoodOrder(aFoodOrder);
		this.setCookTime(aCookTime);
		this.setArrivalTime(aArrival);
		this.setCookTimeLeft();
	}
	//ACCESSORS
	public String getCustomer()
	{
		return this.customer;
	}
	public String getFoodOrder()
	{
		return this.foodOrder;
	}
	public int getCookingTime()
	{
		return this.cookingTime;
	}
	public int getArrivalTime()
	{
		return this.arrivalTime;
	}
	public int getCookTimeLeft()
	{	
	return this.cookTimeLeft;
	}
	//MUTATORS
	public void setCustomer(String aC)
	{
		if(aC == null)
			this.customer = "none";
		this.customer = aC;
	}
	public void setFoodOrder(String aF)
	{
		if(aF == null)
			this.foodOrder = "none";
		this.foodOrder = aF;
	}
	public void setCookTime(int aCT)
	{
		if(aCT < 0)
			this.cookingTime = 1;
		this.cookingTime = aCT;
	}
	public void setArrivalTime(int aAT)
	{
		if(aAT < 0)
			this.arrivalTime = 0;
		this.arrivalTime = aAT;
	}
	public void setCookTimeLeft()
	{
		this.cookTimeLeft = this.cookingTime;
	}
	//TO-STRING
	public String toString()
	{
		return "Customer: "+this.customer+", Order: "+this.foodOrder+", Cooking Time Left: "+this.cookTimeLeft;
	}
	//COMPARE-TO
	public int compareTo(Order aOrder)
	{
		if(this.cookingTime < aOrder.getCookingTime()) // shorter times get positive
			return 2;
		else if(this.cookingTime > aOrder.getCookingTime()) // longer time ets negative
			return -2;
		else
			return -1; //if they're equal
	}
	//COOKFORONEMINUTE
	public void cookForOneMinute()
	{
		if(this.cookTimeLeft<1)
		{								// sets it to zero to avoid having negative time
			this.cookTimeLeft = 0;
			return;
		}
		this.cookTimeLeft --;
	}
	//ISDONE
	public boolean isDone()
	{
		return this.cookTimeLeft == 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
