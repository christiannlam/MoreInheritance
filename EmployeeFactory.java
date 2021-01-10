
public class EmployeeFactory
{
	public Employee getEmployee(String employeeType) {
		if (employeeType == null)
		{
			return null;
		}
		else if (employeeType.equalsIgnoreCase("FACULTY"))
		{
			return new Faculty();
		}
		//Create other cases (Staff and Parttime)
		else if (employeeType.equalsIgnoreCase("STAFF"))
		{
			return new Staff();
		}
		else if(employeeType.equalsIgnoreCase("PARTIME") )
		{
			return new Partime();
		}
		else
		{
			return null;
		}
	}
}
