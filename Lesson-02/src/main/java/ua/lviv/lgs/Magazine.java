package ua.lviv.lgs;

public class Magazine {
	private int id;
	private String name;
	private int cost;
	private int amount;
	public Magazine(int id, String name, int cost, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.amount = amount;
	}
	public Magazine(String name, int cost, int amount) {
		super();
		this.name = name;
		this.cost = cost;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Magazine [id=" + id + ", name=" + name + ", cost=" + cost + ", amount=" + amount + "]";
	}
	
	
}
