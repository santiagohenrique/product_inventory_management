package entities;

public class Product {

	private String name;
	private Double price;
	private Integer quantity;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, Double price, Integer quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public double totalPrice() {
		return price * quantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("");
		builder.append(this.getName() + ", " + String.format("%.2f", this.getPrice())  + ", " + this.getQuantity());

		return builder.toString();
	}
	
	

}
