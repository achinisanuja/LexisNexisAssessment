package com.real.LNTestProgram;

import com.real.LNTestProgram.factory.Decoder;
import com.real.LNTestProgram.factory.DecoderFactory;
import com.real.LNTestProgram.service.BytesArrayGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@SpringBootApplication
@ComponentScan
public class LnTestProgramApplication implements CommandLineRunner{

	@Autowired
	BytesArrayGeneratorService bytesArrayGeneratorService;

	public static void main(String[] args) {
		SpringApplication.run(LnTestProgramApplication.class, args);
		System.out.println("ENDDDD");
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner input = new Scanner(System.in); //31646541
		System.out.print("Enter The Octal Number: ");
		String encodedNumber = input.nextLine();
		Scanner inputEncodedType = new Scanner(System.in);
		System.out.print("Enter The Encoded Type as in Number (Ex: Octal = 8, HexaDecimal = 16) : ");
		int encodedType = inputEncodedType.nextInt();
		bytesArrayGeneratorService.generateBytesArray(encodedNumber,encodedType);
	}
}
