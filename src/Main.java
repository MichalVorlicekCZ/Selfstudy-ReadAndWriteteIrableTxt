import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			PersonList personList = new PersonList();

			Scanner sc = new Scanner(System.in);

			System.out.println(
					"Chcete do souboru zapsat nebo precist jeo obsah? Vyberte jednu moznost 'precist' nebo 'zapsat'.");
			String volba = sc.next();

			switch (volba) {
			case "precist":
				FileReader fileReader = new FileReader("iterable_txt.txt");
				BufferedReader buferReader = new BufferedReader(fileReader);

				while (buferReader.ready()) {
					String personRead = buferReader.readLine();

					String[] personArray = personRead.split(" ");
					String forename = personArray[0];
					String surname = personArray[1];
					String ageStr = personArray[2];
					int age = Integer.parseInt(ageStr);

					personList.add(new Person(forename, surname, age));
				}

				buferReader.close();

				System.out.println("Polozky v souboru:");
				for (PersonList person : personList) {
					System.out.println(person);
				}
				
				break;

			case "zapsat":
				FileWriter fileWriter = new FileWriter("iterable_txt.txt", true);
				BufferedWriter buferWriter = new BufferedWriter(fileWriter);

				System.out.println("Zapis ukoncite prikazem 'konec'.");

				sc.nextLine();
				String personIn = sc.nextLine();

				while (personIn.equalsIgnoreCase("konec") == false) {
					String[] personArray = personIn.split(" ");
					String forename = personArray[0];
					String surname = personArray[1];
					String ageStr = personArray[2];
					int age = Integer.parseInt(ageStr);

					personList.add(new Person(forename, surname, age));
					buferWriter.append("\r\n" + personIn);

					System.out.println("\r\nZadejte dalsi polozku:");
					personIn = sc.nextLine();
				}

				System.out.println("Pridane polozky do souboru:");
				for (PersonList person : personList) {
					System.out.println(person);
				}

				buferWriter.close();

				break;
			}

			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("Soubor nenalezen.");
		} catch (IOException e) {
			System.out.println("IO chyba.");
			e.printStackTrace();
		}
	}
}
