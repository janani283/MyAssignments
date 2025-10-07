package week2.day2;


public class RemoveDuplicateWords {

	public static void main(String[] args) {

		int count = 0;
		String text = "We learn Java basics as part of java sessions in java week1";

		String[] words = text.split(" ");

		for (int i = 0; i < words.length; i++) {

			for (int j = i + 1; j < words.length; j++) {

				if (words[i].equalsIgnoreCase(words[j])) {

					words[j] = "";

					count++;
				}
			}
		}

		System.out.println("Input String: " + text);

		if (count > 0) {
			System.out.println("Number of Duplicates Found: " + count);
			System.out.print("Modified Text: ");

			for (int i = 0; i < words.length; i++) {
				String word = words[i];

				if (!word.isEmpty()) {
					System.out.print(word + " ");
				}
			}

		} else {
			System.out.println("No duplicate words found.");
		} } }