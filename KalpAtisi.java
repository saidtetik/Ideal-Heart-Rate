
package Kalp;

import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

public class KalpAtisi {
	private String name;
	private String surname;
	private int day;
	private int month;
	private int year;
	private int age;
	int maximum_heart_rate;
	private String interval;
	private void ageCalculation(int birthDay, int birthMonth, int birthYear){
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		int todayYear = cal.get(Calendar.YEAR);
		int todayMonth = cal.get(Calendar.MONTH)+1;
		int todayDay = cal.get(Calendar.DAY_OF_MONTH);
		this.age = todayYear-birthYear;
		if(todayMonth<birthMonth) {
			(this.age)--;
		}
		if(todayMonth == birthMonth && todayDay<birthDay) {
			(this.age)--;
		}
	}
	KalpAtisi(String name, String surname, int day, int month, int year){
		
		this.name = name;
		this.surname = surname;
		this.day = day;
		this.month = month;
		this.year = year;
		ageCalculation(day,month,year);
		this.maximum_heart_rate = 220-this.age;
		this.interval = idealHeartRate(maximum_heart_rate);
		
		
	}
	KalpAtisi(String name, String surname){
		this.name = name;
		this.surname = surname;
		this.age = 30;
		this.maximum_heart_rate = 220-this.age;
		this.interval = idealHeartRate(maximum_heart_rate);
	}
	public void setName(String name ) {
		this.name = name;
	}
	public void setSurName(String surname) {
		this.surname = surname;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getName() {
		return this.name;
	}
	public String getSurName() {
		return this.surname;
	}
	public int getDay() {
		return this.day;
	}
	public int getMonth() {
		return this.month;
	}
	public int getYear() {

		return this.year;
	}
	public String getInterval() {
		return this.interval;
	}
	private String idealHeartRate(int max_heart_rate) {
		double aralik1= (double)max_heart_rate/2;
		double aralik2 = (double)max_heart_rate *((double)85/100);
		return "Ideal kalp atis sayisi aralýgý " + aralik1 + " ile " + aralik2 + " arasindadir.";
	}
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		String name="", surname="";
		int day=0, month=0, year=0;
		KalpAtisi[] kisi = new KalpAtisi[10];
		for(int i=0; i<10; i++) {
			
			System.out.println("Kisinin adini giriniz: ");
			input.nextLine();
			 name = input.nextLine();
			System.out.println("Kisinin soyadini giriniz:");
			surname = input.next();
			System.out.println("Kisinin ayin hangi gununde dogdugunu giriniz ya da bos birakmak icin 0 giriniz: ");
			day = input.nextInt();
			System.out.println("Kisinin kacýncý ayda dogdugunu giriniz ya da bos birakmak icin 0 giriniz: ");
			month = input.nextInt();
			System.out.println("Kisinin dogdugu yili giriniz ya da bos birakmak icin 0 giriniz: ");
			year = input.nextInt();
			if(day==0&&month==0&&year==0) {
				kisi[i] =new KalpAtisi(name,surname);
			}
			else {
				kisi[i] = new KalpAtisi(name,surname,day,month,year);
			}
		}
		for(int sirala=0; sirala<10; sirala++) {
			System.out.println(kisi[sirala].getName()+"  "+kisi[sirala].getSurName()+"  "+kisi[sirala].getInterval());
			
		}
	                                        
	}
	
}
