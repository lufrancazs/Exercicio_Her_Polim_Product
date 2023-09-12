package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product	{
	
	private LocalDate manufactureDate;
	
	DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public DateTimeFormatter getFmt1() {
		return fmt1;
	}

	public void setFmt1(DateTimeFormatter fmt1) {
		this.fmt1 = fmt1;
	}
	
	@Override
	public String priceTag() {
		return super.getName() + " (used) $" + String.format("%.2f", super.getPrice()) + " (Manufacture date: " + manufactureDate.format(fmt1) + ")";
	}

}
