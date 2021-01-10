import java.util.Scanner;

public class Partime extends Staff {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double hours_worked;
	
	Partime() {
		super();
		hours_worked = 0.0;
	}
	
	Partime(String l_name, String f_name, String Id, char gen, int month, int day, int year, double h_rate, double h_work) {
		super(l_name, f_name, Id, gen, month, day, year, h_rate);
		this.setHoursWorked(h_work);
	}
	
	public double getHoursWorked() {
		return hours_worked;
	}
	
	public void setHoursWorked(double h_worked) {
		this.hours_worked = h_worked;
	}
	
	public double monthlyEarning() {
		return super.getHourlyrate()*hours_worked*4;
	}
	
	public String toString() {
		return super.toString() + "\n"  + "  " + "Hours worked per week: " + hours_worked + "\n"; 
	}
	
	public void setEmployee()
	{ //Input last name, first name, id, Gender, birthday, hourly rate and hours work
		System.out.println("Last Name: ");
		setLastName(input.nextLine());
		System.out.println("First Name: ");
		setFirstName(input.nextLine());
		System.out.println("ID: ");
		setID(input.nextLine());
		System.out.println("Gender: ");
		setGender(input.next().charAt(0));
		System.out.println("Birthday (Month/Day/Year): ");
		int m = input.nextInt();
		int d = input.nextInt();
		int y = input.nextInt();
		setBirthday(m,d,y);
		System.out.println("Hourly Rate: ");
		setHourlyRate(input.nextDouble());
		System.out.println("Hours Worked: ");
		setHoursWorked(input.nextDouble());

		
	}

}
