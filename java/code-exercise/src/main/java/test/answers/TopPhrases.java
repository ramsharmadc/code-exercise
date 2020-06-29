package test.answers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class TopPhrases {

	/**
	 * @param K        number of top phrases
	 * @param filePath path to the file to be read
	 * @return
	 */
	public List<Phrase<String>> findTopPhrases(int K, String filePath) throws FileNotFoundException, IOException {

		// map to keep reference of counts per phrase
		Map<String, Integer> m = new HashMap<>();

		// Max heap to store phrases in their order of occurrence
		Queue<Phrase<String>> phrasesMaxHeap = new PriorityQueue<>(
				(o1, o2) -> (o1.text.equals(o2.text) || o1.countOfOccurence == o2.countOfOccurence) ? 0
						: (o1.countOfOccurence < o2.countOfOccurence ? 1 : -1));

		FileInputStream fis = new FileInputStream(filePath);
		Scanner fileScnr = new Scanner(fis);

		/*
		 * loop through each line ad then splits the delimited phrases runs in O(nm),
		 * where n -> number of lines and m -> number of phrases in one lines
		 */
		while (fileScnr.hasNext()) {

			String nxtLine = fileScnr.nextLine();

			if (nxtLine != null && !nxtLine.isEmpty()) {
				String[] phrasesOfLine = nxtLine.split("\\|");
				Arrays.stream(phrasesOfLine).forEach(x -> {

					if (x != null && !x.isEmpty()) {
						String phrase = x.trim();
						if (m.containsKey(phrase)) {
							m.put(phrase, m.get(phrase) + 1);
						} else {
							m.put(phrase, 1);
						}
					}
				});
			}
		}

		if (fileScnr.ioException() != null) {
			throw fileScnr.ioException();
		}

		// hydrates phrases heap now,
		// runs in complexity O(nlgn), for inserting each entry of map in max heap
		for (Map.Entry<String, Integer> e : m.entrySet()) {
			phrasesMaxHeap.add(new Phrase<String>(e.getKey(), e.getValue()));
		}

		// adding top K phrases from Max Heap
		// runs in O(K)
		int i = 0; // limit 0 -> K
		List<Phrase<String>> topKPhrases = new ArrayList();
		for (Phrase p : phrasesMaxHeap) {
			if (i++ >= K)
				break;

			topKPhrases.add(p);
		}

		// closing I/O resources
		if (fileScnr != null) {
			fileScnr.close();
		}

		if (fis != null) {
			fis.close();
		}

		return topKPhrases;
	}

	/**
	 * data structure to hold Phrase and its count of occurrence
	 * 
	 * @param <T>
	 */
	private static class Phrase<T> {
		private String text;
		private int countOfOccurence;

		public Phrase(String text, int countOfOccurence) {
			this.text = text;
			this.countOfOccurence = countOfOccurence;
		}

		public Phrase(String x) {
			this.text = x;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public int getCountOfOccurence() {
			return countOfOccurence;
		}

		public void setCountOfOccurence(int countOfOccurence) {
			this.countOfOccurence = countOfOccurence;
		}

		@Override
		public String toString() {
			return text;
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(this.text);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;

			if (!(obj instanceof Phrase))
				return false;

			if (obj == this)
				return true;

			Phrase that = (Phrase) obj;

			return this.text.equals(that.text);
		}
	}

	// I wanted to use a fixed length heap
	private static class FixedLengthPriorityQueue<T> extends PriorityQueue<T> {

		private int size;
		private Object[] array;

		public FixedLengthPriorityQueue(int initialCapacity, Comparator<? super T> comparator) {
			super(initialCapacity, comparator);
			this.size = initialCapacity;
			array = new Object[size];
		}

		@Override
		public boolean add(T t) {
			if (size() >= this.size) {
				return false;
			}
			return super.add(t);
		}
	}

	/**
	 * Driver program to test the TopPhrases.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final File directory = new File("./");
		final String testFile = ".\\libs\\TopPhrases.txt";
		final TopPhrases topPhrases = new TopPhrases();
		try {
			List<Phrase<String>> topKPhrases = topPhrases.findTopPhrases(3, testFile);
			System.out.println(topKPhrases);
		} catch (FileNotFoundException e) {
			System.out.println("Input file \'TopPhrasess.txt\' not found at location - " + directory.getAbsolutePath()
					+ "\\test\\");
			System.out.println("Please refer README.txt for TopPhrases");
		} catch (IOException e) {
			System.out.println("Some I/O exception happened while handling the file.");
		}
	}
}
