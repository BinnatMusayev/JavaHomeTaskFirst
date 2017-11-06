import java.util.Scanner;
import java.util.ArrayList;
public class BabyRegister{

	// CHANGE THE NAME OF THE CLASS TO BABYREGISTER
	

	public static void main(String[] args){

		ArrayList<Baby> babies = new ArrayList<Baby>();
		ArrayList<Gift> gifts = new ArrayList<Gift>();
		Scanner scanner = new Scanner(System.in);

		//---babies
		babies.add(new Baby("14/10/1994 22:00", "Binnat", "M" ));
		babies.add(new Baby("24/12/1996 23:12", "Nuraly", "M" ));
		babies.add(new Baby("24/12/1990 19:03", "Xuan", "M" ));
		babies.add(new Baby("24/12/1986 03:24", "Zlatan", "F" ));
		babies.add(new Baby("24/12/1995 15:20", "Roya", "M" ));
		babies.add(new Baby("24/12/1980 12:00", "Messi", "F" ));

		//---gifts
		gifts.add(new Gift("Bill Gates", "Company Stock", "12/07/2016 04:23"));
		gifts.add(new Gift("Mark Zuckenberg", "Jet", "02/04/2014 09:30"));
		gifts.add(new Gift("Jeff Bales", "Books", "28/02/2017 13:20"));



		System.out.println("\n 'addbaby' - to add babies \n 'listage' - list babies by age \n " +

			 "'listname' - list babies by name \n " +

			 "'addgift' - add gift \n 'listgifts' - list gifts \n 'exit' - to quit ");

		String userInput = scanner.nextLine();

		while(!userInput.equals("exit") ){
			//bunu switch-case e deyishdir

			switch(userInput){
				case "addbaby":
					System.out.println("Enter name of baby:");
					String babyName = scanner.nextLine();
					System.out.println("Enter birth date of baby:");
					String babyBirthday = scanner.nextLine();
					System.out.println("Enter gender of baby:");
					String babyGender = scanner.nextLine();

					babies.add(new Baby(babyBirthday, babyName, babyGender));
					System.out.println("Baby " + babyName + " added successfully");

					break;
				case "listage":
					sortByAge(babies);
					printBabies(babies);
					break;
				case "listname":
					sortByName(babies);
					printBabies(babies);
					break;
				case "addgift":
					System.out.println("Enter name of gift:");
					String giftDesc = scanner.nextLine();
					System.out.println("Enter name of giver of the gift:");
					String giftGiver = scanner.nextLine();
					System.out.println("Enter date of given time:");
					String giftDate = scanner.nextLine();

					gifts.add(new Gift(giftGiver, giftDesc, giftDate));
					System.out.println("Gift " + giftDesc + " added successfully");
					break;
				case "listgifts":
					sortGiftByName(gifts);
					printGifts(gifts);
					break;
				default:
					System.out.println("Incorrect Input");
					break;

			}

			userInput = scanner.nextLine();

		}
		


	}

	public static void sortByName(ArrayList<Baby> bbb){
		//comparable comparator
		for(int i=0; i<bbb.size()-1; i++){
			for(int j=i+1; j<bbb.size(); j++){
				Baby s1 = bbb.get(i);
				Baby s2 = bbb.get(j);
				if(s1.getName().compareToIgnoreCase(s2.getName())>0){
					Baby aux = s1;
					bbb.set(j,aux);
					bbb.set(i, s2);
				}
				
			}
		}
	}

	public static void sortByAge(ArrayList<Baby> bbb){
		for(int i=0; i<bbb.size()-1; i++){
			for(int j=i+1; j<bbb.size(); j++){
				Baby s1 = bbb.get(i);
				Baby s2 = bbb.get(j);
				// if(s1.getAge().compareTo(s2.getAge())>0){
				if(s1.getAge() < s2.getAge() ){
					Baby aux = s1;
					bbb.set(j,aux);
					bbb.set(i, s2);
				}
				
			}
		}
	}

	public static void printBabies(ArrayList<Baby> bbb){
		for(Baby b: bbb){
			System.out.println(b.toString());
		}
	}

	public static void sortGiftByName(ArrayList<Gift> ggg){
		//comparable comparator
		for(int i=0; i<ggg.size()-1; i++){
			for(int j=i+1; j<ggg.size(); j++){
				Gift s1 = ggg.get(i);
				Gift s2 = ggg.get(j);
				if(s1.getDescription().compareToIgnoreCase(s2.getDescription())>0){
					Gift aux = s1;
					ggg.set(j,aux);
					ggg.set(i, s2);
				}
				
			}
		}
	}

	public static void printGifts(ArrayList<Gift> ggg){
		for(Gift g: ggg){
			System.out.println(g.toString());
		}
	}

}