package com.CarService.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utility {
	
	public static String randomStringGenerator() {
		String randomString = "";
		String signs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		Random random = new Random();
		for (int i = 0; i < 32; i++) {
			int number = random.nextInt(signs.length());
			randomString += signs.substring(number, number + 1);	
		}
		return randomString;
	}
	
	public static LocalDate getParsedDate() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		String text = date.format(formatter);
		LocalDate parsedDate = LocalDate.parse(text, formatter);
		return parsedDate;
	}
}
