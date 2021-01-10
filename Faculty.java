import java.text.DecimalFormat;
import java.util.Scanner;


public class Faculty extends Employee implements Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	enum Level {
		ASSISTANT_PROFESSOR,
		ASSOCIATE_PROFESSOR,
		FULL; 
	}
	private Level prof;
	private Education edu;
    private static DecimalFormat df2 = new DecimalFormat("#.00");
	
    
    public void setEdu(Education e){
    	edu = e;
    }
    
	Faculty() {
		super();
		edu = new Education();
	}
	
	Faculty(String l_name, String f_name, String Id, char gen, int month, int day, int year, String d, String m, int r, Level pro) {
		super(l_name, f_name, Id, gen, month, day, year);
		this.setRank(pro); 
		edu = new Education(d,m,r);
		
	}
	
	public Level getRank() {
		return prof;
	}
	
	public void setRank(Level pro) {
		this.prof = pro;
	}
	
	public double monthlyEarning() {
		if(prof == Level.ASSISTANT_PROFESSOR) {
			return 5000.00;
		}
		else if(prof == Level.ASSOCIATE_PROFESSOR) {
			return 7500.00;
		}
		else {
			return 10000.00;
		}
		
	}		
	
	public String toString() {
		return super.toString() + "\n" +  "  " + "Level: " + prof + "\n" + "  " + "Degree: " + edu.getDegree() +
		"\n" + "  " + "Major: " + edu.getMajor() + "\n" + "  " + "Research: " + edu.getResearch() + "\n" + "  " + 
		"Monthly Salary: " + "$" + df2.format(monthlyEarning()) + "\n";
	}
	  
	public Object clone() throws CloneNotSupportedException
	{
		Faculty e = (Faculty)super.clone();
		edu = (Education) edu.clone();
		e.setEdu(edu);
		return e; 
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
	{  //Input last name, first name, id, gender, birthday, Faculty level (Assistant professor<
           //Associate professor, or Full Professor), degree, major and research.
           //YOUR CODE
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
		System.out.println("Faculty Level ( Assistant , Associate, Full ): ");
		if(input.nextLine().equalsIgnoreCase("Assistant"))
		{
			setRank(Level.ASSISTANT_PROFESSOR);
		}
		else if(input.nextLine().equalsIgnoreCase("Associate"))
		{
			setRank(Level.ASSOCIATE_PROFESSOR);
		}
		else
		{
			setRank(Level.FULL);
		}
		System.out.println("Degree: ");
		String degree = input.nextLine();
		System.out.println("Major: ");
		String major = input.nextLine();
		System.out.println("Research: ");
		int research = input.nextInt();
		setEdu(new Education(degree,major,research));
	}
	
	public void changeEdu()
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Enter degree: ");
		Education e = new Education();
		e.setDegree(in.next());
		System.out.println("Enter major: ");
		e.setMajor(in.next());
		System.out.println("Enter research: ");
		e.setResearch(in.nextInt());
		setEdu(e);
	}
}
