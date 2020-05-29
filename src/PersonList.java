import java.util.ArrayList;
import java.util.Iterator;

public class PersonList implements Iterable<PersonList> {
	ArrayList<PersonList> personList = new ArrayList<>();

	public void add(Person person) {
		personList.add(person);
	}

	@Override
	public Iterator<PersonList> iterator() {
		// TODO Auto-generated method stub
		return personList.iterator();
	}
}
