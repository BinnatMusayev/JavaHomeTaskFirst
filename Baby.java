import java.util.Date;
import java.text.*;

public class Baby{

	private String birthday, name;
	private char gender;
	private Date birthdayDate;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");


	public Baby(){

	}

	public Baby(String birthday, String name, String gender){
		this.birthday = birthday;
		this.name = name;
		this.gender = gender.charAt(0);

		try{
			birthdayDate = sdf.parse(birthday);
		}catch(Exception e){
			System.out.println("Wrong Date");
		}
	}

	public Baby(Date birthdayDate, String name, char gender){
		this.birthdayDate = birthdayDate;
		this.name = name;
		this.gender = gender;
	}


	//getters and setters
	public String getBirthday(){
		return this.birthday;
	}

	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public char getGender(){
		return this.gender;
	}

	public void setGender(char gender){
		this.gender = gender;
	}

	public Date getBirthdayDate(){
		return this.birthdayDate;
	}

	public void setBirthday(Date birthdayDate){
		this.birthdayDate = birthdayDate;
	}

	//end of getters and setters

	public boolean isOlder(Baby baby){
		return this.birthdayDate.before(baby.getBirthdayDate());
	}

	public long howOld(){
		//in days
		Date currentDate = new Date();
		long difference = currentDate.getTime() - this.birthdayDate.getTime() ;

		return difference / (1000l*60*60*24);
	}

	public long getAge(){
		// by year
		Date currentDate = new Date();
		long difference = currentDate.getTime() - this.birthdayDate.getTime() ;

		return difference / (1000l*60*60*24*365);
	}

	//additional methods
	public String toString(){
		// return "Name: " + this.name + " Birthday: " + this.birthdayDate + " Gender: " +this.gender;
		return "Name: " + this.name +", "+ this.howOld() + " days old, Gender: " +this.gender;
	}

	public boolean equals(Baby b){

		if(name.equals(b.getName()) && gender == b.getGender() && birthday.equals(b.getBirthday()) )
			return true;

		return false;
	}

}