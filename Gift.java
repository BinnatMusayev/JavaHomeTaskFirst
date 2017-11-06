import java.util.Date;
import java.text.*;
public class Gift{

	private String giverName, description, givenDateString;
	private Date givenDate;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public Gift(String giverName, String description, String givenDateString){
		this.giverName = giverName;
		this.description = description;
		this.givenDateString = givenDateString;

		try{
			givenDate = sdf.parse(givenDateString);
		}catch(Exception e){
			System.out.println("Wrong Date");
		}

	}

	public String getDescription(){
		return this.description;
	}

	public String toString(){
		return  description + " given by " +giverName + " at this date: '" + givenDateString + "' ";
	}

}