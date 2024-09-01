
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Oder;
import entities.OrderItem;
import entities.Product;
import entities.enums.OderStatus;

public class Program {

	public static void main(String[] args) {
	/*Ler os dados de um pedido com N itens (N fornecido pelo usuário). Depois, mostrar um 
	sumário do pedido conforme exemplo (próxima página). Nota: o instante do pedido deve ser 
	o instante do sistema: new Date()*/
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateBirth ;
		LocalDateTime moment;
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name=sc.nextLine();
		System.out.print("Email: ");
		String email=sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String date=sc.next();
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status=sc.next();
		System.out.print("How many items to this order? ");
		int n=sc.nextInt();
		
		Client client1= new Client(name, email, dateBirth= LocalDate.parse(date, fmt1));
		Oder oder = new Oder( moment =LocalDateTime.now(), OderStatus.valueOf(status), client1);
		
		for (int i = 0; i < n; i++) {
			System.out.printf("Enter #%d item data: %n",i+1);
			System.out.print("Product name: ");
			String nameProduct=sc.next();
			System.out.print("Product price:  ");
			Double price2=sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quant=sc.nextInt();
			OrderItem oderItem= new OrderItem(quant, price2, new Product(nameProduct, price2));
			oder.addItem(oderItem);
		}
		System.out.println("");
		System.out.print(oder);
		
		sc.close();
		
		
	}

}
