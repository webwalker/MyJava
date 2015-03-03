import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Others {
	public void test() {

		List<String> l1 = new ArrayList<String>();
		l1.add("1");
		l1.add("2");
		l1.add("3");

		MyContext m = new MyContext();
		m.Add("a", l1);
		
		ArrayList<String> a = (ArrayList<String>) m.get("a");
		System.out.println("1");
		
		List<String> l2 = new ArrayList<String>();
		l2.add("4");
		l2.add("5");
		l2.add("6");

		m.Add("a", l2);

		a = (ArrayList<String>) m.get("a");
		a.add("1111");
		a = (ArrayList<String>) m.get("a");
		
		System.out.println("1");
	}

	public class MyContext {
		public Hashtable<String, Object> contextInfo = new Hashtable<String, Object>();

		public Object get(String key) {
			if (key != null) {
				return contextInfo.get(key);
			} else {
				new IllegalArgumentException(
						"null pointer value for key via get(String key)");
			}
			return null;
		}

		public synchronized void Add(String key, Object value) {
			if (key != null && value != null) {
				contextInfo.put(key, value);
			} else {
				new IllegalArgumentException(
						"null pointer value for key or value via Add(String key, Object value)");
			}
		}

		public synchronized Object Remove(String key) {
			return contextInfo.remove(key);
		}

	}
}
