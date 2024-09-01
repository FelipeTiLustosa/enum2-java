package entities;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OderStatus;

public class Oder {
private LocalDateTime moment;
private OderStatus status;

private Client client;

private List<OrderItem> item= new ArrayList<>();
private static DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
 
public Oder() {
	
}
public Oder(LocalDateTime moment, OderStatus status, Client client) {
	this.moment = moment;
	this.status = status;
	this.client = client;
}



public void addItem(OrderItem item ) {
	this.item.add(item);
}

public void removeItem(OrderItem item ) {
	this.item.remove(item);
}

public Double total() {
	Double sum =0.0;
	for (OrderItem orderItem : item) {
		sum+=orderItem.subTotal();
	}
	return sum;
}


@Override
public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("Order moment: ");
	sb.append(fmt2.format(moment) + "\n");
	sb.append("Order status: ");
	sb.append(status + "\n");
	sb.append("Client: ");
	sb.append(client + "\n");
	sb.append("Order items:\n");
	for (OrderItem item : item) {
		sb.append(item + "\n");
	}
	sb.append("Total price: $");
	sb.append(String.format("%.2f", total()));
	return sb.toString();
}

public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}

public LocalDateTime getMoment() {
	return moment;
}


public void setMoment(LocalDateTime moment) {
	this.moment = moment;
}


public OderStatus getStatus() {
	return status;
}


public void setStatus(OderStatus status) {
	this.status = status;
}


}
