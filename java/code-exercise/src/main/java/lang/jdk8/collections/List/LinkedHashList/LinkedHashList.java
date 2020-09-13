package lang.jdk8.collections.List.LinkedHashList;

import java.util.*;

public class LinkedHashList<E> implements Iterable<E> {

	static private int counter;
	private final Map<Integer, E> map;
	private List<E> list;

	public LinkedHashList() {
		counter = 0;
		map = new HashMap<>();
		list = new ArrayList<>();
	}

	public void add(final E value) {
		map.put(counter++, value);
		updateList();
	}

	public E get(final int index) {
		final E value = map.get(index);
		return value;
	}

	@Override
	public Iterator<E> iterator() {

		return new Iterator<E>() {

			// int counter = 0;

			@Override
			public boolean hasNext() {

				if (counter == 0)
					return false;
				else
					return true;
			}

			@Override
			public E next() {

				return list.get(--counter);
			}

			@Override
			public void remove() {

				list.remove(LinkedHashList.counter--);

			}
		};
	}

	@Override
	public String toString() {

		final StringBuilder strBuild = new StringBuilder();
		strBuild.append("[");

		for (final Map.Entry<Integer, E> entry : map.entrySet()) {
			strBuild.append(entry.getKey() + " = " + entry.getValue() + ", ");
		}
		strBuild.append("]");

		return strBuild.toString();
	}

	private void updateList() {

		final Iterator<Map.Entry<Integer, E>> itr = map.entrySet().iterator();
		list = new ArrayList<>();

		while (itr.hasNext()) {
			final Map.Entry<Integer, E> entry = itr.next();
			list.add(entry.getKey(), entry.getValue());
		}
	}
}
