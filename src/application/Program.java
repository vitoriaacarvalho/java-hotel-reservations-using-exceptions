package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("room number: ");
			int number=sc.nextInt();
			
			System.out.print("check-in date (dd/MM/yyyy): ");
			Date checkIn=sdf.parse(sc.next());
			
			System.out.print("check-out date (dd/MM/yyyy): ");
			Date checkOut=sdf.parse(sc.next());
		
			Reservation reservation= new Reservation(number, checkIn, checkOut);
			System.out.println("reservaton: "+ reservation);
			
			System.out.println();
			System.out.println("enter data to update the reservation: ");
			System.out.println("check-in date (dd/MM/yyyy): ");
			checkIn=sdf.parse(sc.next());
			System.out.println("check-out date (dd/MM/yyyy): ");
			checkOut=sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("updated reservation: "+reservation);	
		}
		catch (ParseException e){
			System.out.println("invalid date format.");
		}
		catch (DomainException e) {
			System.out.println("error in reservation: "+ e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("unexpected error");
		}
		
		sc.close();
		
	}

}
