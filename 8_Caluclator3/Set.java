import java.util.ArrayList;
import java.util.Iterator;

//@author Chantal Reißner and Larissa Wagnerberger
public class Set {
	private ArrayList<Integer> list;

	public Set() {
		list = new ArrayList<Integer>();
	}

	public void add(int x) {
		if (!isMember(x))
			list.add((Integer) x);
	}

	public boolean isMember(int x) {
		return list.contains(x);
	}

	public void delete(int x) {
		list.remove((Integer) x);
	}

	public void clear() {
		list.clear();
	}

	public Iterator<Integer> iterator() {
		return list.iterator();
	}

	public String toString() {
		String result = "{";
		for (Integer y : list) {

			result += y + ", ";
		}
		result = result.substring(0, result.length() - 2);
		result += "}";
		return result;
	}

	public int getLength() {
		return list.size();
	}

}
