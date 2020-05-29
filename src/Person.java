
public class Person extends PersonList {
	private String forename;
	private String surname;
	private int age;

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String forename, String surname, int age) {
		super();
		this.forename = forename;
		this.surname = surname;
		this.age = age;
	}

	@Override
	public String toString() {
		return forename + " " + surname + " " + age;
	}
}
