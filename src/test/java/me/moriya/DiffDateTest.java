package me.moriya;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class DiffDateTest {
	
	private Scanner scan;
	
	@BeforeAll
	public void setup() {
		scan = new Scanner(System.in);
	}

	@Test
	public void testDiffDate() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.setLenient(false);
		
		try {
			Date today = new Date();
			String f = format.format(today);
			today = format.parse(f);
			System.out.print("Informe a data: ");
			
			Date end = format.parse(scan.nextLine());
			long diffInMillies = end.getTime() - today.getTime();
			long diff = Math.abs((diffInMillies / (1000 * 60 * 60 * 24)));
			
			System.out.println(diff);
		} catch (ParseException e) {
			System.out.println("Data inválida");
		}
		
	}
	
	@AfterAll
	public void close() {
		scan.close();
	}
}