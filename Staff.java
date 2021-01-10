import java.text.DecimalFormat;
import java.util.Scanner;

public class Staff extends Employee {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double hourly_rate;
    private static DecimalFormat df2 = new DecimalFormat("#.00");

	
	Staff() {
		super();
		hourly_rate = 0.0;
	}
	
	Staff(String l_name, String f_name, String Id, char gen, int month, int day, int year, double h_rate) {
		super(l_name, f_name, Id, gen, month, day, year); 
		this.setHourlyRate(h_rate);
	}
	
	public double getHourlyrate() {
		return hourly_rate;
	}
	
	public void setHourlyRate(double h_rate) {
		this.hourly_rate = h_rate;
	}
	 
	public double monthlyEarning() {
		return hourly_rate*160;
	} 
	
	public String toString() {
		return super.toString() + "\n" + "  " + "Hourly rate: " + "$" + df2.format(getHourlyrate()) + "\n" + "  " + 
		"Monthly Salary: " + "$" + df2.format(monthlyEarning());
	}

	@Override
	public int compareTo(Employee other) {
			if (getLastName().compareTo(other.getLastName()) > 0)
			{ 
				return -1;
			}
			if (getLastName().compareTo(other.getLastName()) < 0)
			{ 
				return 1;
			}
			else 
			return 0;
	}

	public void setEmployee() 
	{
		//Input last name, first name, id, Gender, birthday, and hourly rate
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

	}
	
}
