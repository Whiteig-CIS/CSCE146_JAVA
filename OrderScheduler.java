/*
 * Written by Isaac White
 */
public class OrderScheduler 
{
public MinHeap<Order> orders;
public Order currOrder;
public int currMin;
public int totalOrders;
public int SummWaitTimes;


public OrderScheduler()
{
	init();
}
public void init()
{
	this.orders = new MinHeap<Order>();
	this.currOrder = null;
	this.currMin = 0;
	this.totalOrders = 0;
	this.SummWaitTimes = 0;
	
}
// ADDORDER

public void addOrder(Order a)
{
	if(currOrder == null)
		this.currOrder = a;
	else
		orders.add(a);
	totalOrders++;
}
//ADVANCEONEMIN
public void advanceOneMinute()
{
	currMin++;
	if(currOrder.cookTimeLeft>0)
		currOrder.cookTimeLeft--;
	else if(currOrder.cookTimeLeft==0)
	{
		int wait = currMin - currOrder.getArrivalTime();
		SummWaitTimes+=wait;
		currOrder = orders.remove();
		return;
	}
}
//ISDONE
public boolean isDone()
{
	return this.currOrder == null;
}
//GETAVERAGEWAITTIME
public double getAverageWaitingTime()
{
	return SummWaitTimes/totalOrders;
}
//GETCURRENTORDER
public Order getCurrentOrder()
{
	return this.currOrder;
}

}
