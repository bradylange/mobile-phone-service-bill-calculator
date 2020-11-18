/*
 * Developer: Brady Lange
 * Course: CSIS 161 - Programming I
 * Institution: University of Wisconsin-River Falls
 * Class: MobilePhoneBillCalculator
 * Development Language: Java
 * Copyright Notice: MIT License, Copyright (c) 2019 Brady Lange
 */

package com.github.bradylange.mobilephonebillcalculator.calculators;

// Import util library - console scanner
import java.util.Scanner;

/**
 * <p>
 * 		Calculates the phone bill's of two types of services from a telephone 
 * 		company. Contains the {@link #main} method which instantiates and 
 * 		sets up the program.
 * </p>
 * 
 * @author  Brady Lange - <a href = "https://www.linkedin.com/in/brady-lange/" 
 *                           target = "_blank">LinkedIn</a>
 * @version  1.0.1, 01/08/2019
 * @since  1.0, 10/26/2016
 */
public class MobilePhoneBillCalculator 
{ 
	// ========================================================================
	// Main Method
	// ========================================================================
	/**
	 * Instantiates and sets up the program.
	 * 
	 * @param args  the array of command line arguments to be passed
	 * 
	 * @version  1.0.1, 01/08/2019
	 * @since  1.0, 10/26/2016
	 */
	public static void main(String[] args) 
	{ 
		// --------------------------------------------------------------------
		// General Variables 
		// --------------------------------------------------------------------
		// Console scanner
		Scanner console = new Scanner(System.in);								
		
		// --------------------------------------------------------------------
		// General Customer Variables 
		// --------------------------------------------------------------------
		// Identification name
		String name;		
		// Account number 
		final int ACCOUNT_NUMBER;	
		// Type of phone service
		String service;															
		
		// --------------------------------------------------------------------
		// Regular Service Variables 
		// --------------------------------------------------------------------
		// Regular service String
		String reg = "REGULAR";		
		// Free regular service minutes 
		final int FREE_REG_MINS = 50;		
		// Regular service monthly fee
		final double REG_FEE = 10.00;	
		// Regular service total charge
		double regCharge;			
		// Regular service total charge formatted 
		String regChrgFrm;														
		
		// --------------------------------------------------------------------
		// Premium Service Variables
		// --------------------------------------------------------------------
		// Premium service String
		String prem = "PREMIUM";	
		// Premium or regular service day minutes used
		int dayMins; 						
		// Premium service night minutes used
		int nightMins;				
		// Premium service free day minutes
		final int FREE_PREM_DAY_MINS = 75;	
		// Premium service free night minutes
		final int FREE_PREM_NIGHT_MINS = 100;
		// Premium service monthly fee
		final double PREM_FEE = 25.00;	
		// Premium service total charge
		double premCharge;	
		// Premium service total charge formatted
		String premChrgFrm;														
		
		System.out.println("************************************************");
		System.out.println("Mobile Phone Bill Calculator:");
		System.out.println("************************************************");
		// Ask for first name
		System.out.print("What is your first name? ");	
		// Retrieve first name
		name = console.next();					
		// Ask for account number 
		System.out.print("What is your account number? ");	
		// Retrieve account number
		ACCOUNT_NUMBER = console.nextInt();			
		// Ask for type of service 
		System.out.print("What is your service type (Regular or Premium)? ");	
		// Retrieve service type 
		service = console.next();		
		// Capitalize service type input
		String capService = service.toUpperCase();								
			
		// --------------------------------------------------------------------
		// Premium Service Conditions
		// --------------------------------------------------------------------
		// Premium service 
		if (service.equalsIgnoreCase(prem)) 									
		{ 
			// Ask for amount of night minutes
			System.out.print("How many night minutes did you use? "
			                 + "(No decimals) ");	
			// Retrieve amount of night minutes
			nightMins = console.nextInt();		
			// Ask for amount of day minutes 
			System.out.print("How many day minutes did you use? "
			                 + "(No decimals) ");	
			// Retrieve amount of day minutes 
			dayMins = console.nextInt();										
			// Doesn't go over the day and night minutes
			if (dayMins < FREE_PREM_DAY_MINS 
					&& nightMins < FREE_PREM_NIGHT_MINS) 	
			{
				// Calculate charge of no excessive use of minutes 
				premCharge = PREM_FEE;		
				// Format charge amount to two decimal places
				premChrgFrm = String.format("%.2f", premCharge); 
				// Print mobile phone bill information
				System.out.println("****************************************");
				System.out.println("Service type: " + capService);
				System.out.println("****************************************");
				System.out.println("Name: " + name);
				System.out.println("Account number: " + ACCOUNT_NUMBER);
				System.out.println("Service minutes used (Night): " + nightMins);
				System.out.println("Service minutes used (Day): " + dayMins);
				System.out.println("Amount charged: $" + premChrgFrm);
			}
			// Exceeds free day and night minutes
			else if (dayMins > FREE_PREM_DAY_MINS 
						&& nightMins > FREE_PREM_NIGHT_MINS) 
			{
				// Calculate charge of excessive night and day minutes
				premCharge = PREM_FEE + (nightMins - FREE_PREM_NIGHT_MINS) 
				             * 0.05 + (dayMins - FREE_PREM_DAY_MINS) * 0.10; 
				// Format charge amount to two decimal places
				premChrgFrm = String.format("%.2f", premCharge); 
				// Print mobile phone bill information
				System.out.println("****************************************");
				System.out.println("Service type: " + capService);						
				System.out.println("****************************************");
				System.out.println("Name: " + name);									
				System.out.println("Account number: " + ACCOUNT_NUMBER);					
				System.out.println("Service minutes used (Night): " + nightMins);
				System.out.println("Service minutes used (Day): " + dayMins);
				System.out.println("Amount charged: $" + premChrgFrm);
			}	
			// Exceeds day minutes and not night minutes
			else if (dayMins > FREE_PREM_DAY_MINS 
					 	&& nightMins < FREE_PREM_NIGHT_MINS) 
			{
				// Calculate charge of excessive day minutes
				premCharge = PREM_FEE + (dayMins - FREE_PREM_DAY_MINS) * 0.10;	
				// Format charge amount to two decimal places
				premChrgFrm = String.format("%.2f", premCharge); 	
				// Print mobile phone bill information
				System.out.println("****************************************");
				System.out.println("Service type: " + capService);
				System.out.println("****************************************");
				System.out.println("Name: " + name);
				System.out.println("Account number: " + ACCOUNT_NUMBER);
				System.out.println("Service minutes used (Night): " + nightMins);
				System.out.println("Service minutes used (Day): " + dayMins);
				System.out.println("Amount charged: $" + premChrgFrm);
			}
			// Exceeds night minutes and not day minutes
			else if (dayMins < FREE_PREM_DAY_MINS 
					 	&& nightMins > FREE_PREM_NIGHT_MINS) 	
			{
				// Calculate charge of excessive night minutes
				premCharge = PREM_FEE + (nightMins - FREE_PREM_NIGHT_MINS) 
				             * 0.05;
				// Format charge amount to two decimal places
				premChrgFrm = String.format("%.2f", premCharge); 
				// Print mobile phone bill information
				System.out.println("****************************************");
				System.out.println("Service type: " + capService);
				System.out.println("****************************************");
				System.out.println("Name: " + name);
				System.out.println("Account number: " + ACCOUNT_NUMBER);
				System.out.println("Service minutes used (Night): " + nightMins);
				System.out.println("Service minutes used (Day): " + dayMins);
				System.out.println("Amount charged: $" + premChrgFrm);
			}
		} 
		// --------------------------------------------------------------------
		// Regular Service Conditions
		// --------------------------------------------------------------------
		// Regular service 
		else if (service.equalsIgnoreCase(reg)) 								
		{ 
			// Ask for amount of day minutes used
			System.out.print("How many day minutes did you use? "
			                 + "(No decimals) ");	
			// Retrieve amount of day minutes used
			dayMins = console.nextInt();										
			// Exceeds day minutes
			if (dayMins > FREE_REG_MINS) 											
			{
				// Calculate charge of excessive day minutes
				regCharge = REG_FEE + (dayMins - FREE_REG_MINS) * 0.20;		
				// Format charge amount to two decimal places
				regChrgFrm = String.format("%.2f", regCharge); 	
				// Print mobile phone bill information
				System.out.println("****************************************");
				System.out.println("Service type: " + capService);
				System.out.println("****************************************");
				System.out.println("Name: " + name);
				System.out.println("Account number: " + ACCOUNT_NUMBER);
				System.out.println("Service minutes used: " + dayMins);
				System.out.println("Amount charged: $" + regChrgFrm);
			}
			// Doesn't exceed day minutes 
			else if (dayMins < FREE_REG_MINS) 									
			{
				// Calculate charge of no excessive day minutes 
				regCharge = REG_FEE;	
				// Format charge amount to two decimal places
				regChrgFrm = String.format("%.2f", regCharge); 				
				// Print mobile phone bill information
				System.out.println("****************************************");
				System.out.println("Service type: " + capService);
				System.out.println("****************************************");
				System.out.println("Name: " + name);
				System.out.println("Account number: " + ACCOUNT_NUMBER);
				System.out.println("Service minutes used: " + dayMins);
				System.out.println("Amount charged: $" + regChrgFrm);
			}
		} 
		// --------------------------------------------------------------------
		// Not Regular Service or Premium Service Conditions
		// --------------------------------------------------------------------
		// Invalid service type 
		else																	
		{
			System.out.println("****************************************");
			System.out.println("Service type invalid. Please try again.");
		}
		// Close the console
		console.close(); 														
	} 
} 