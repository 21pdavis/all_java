package structures;

/*
 * Paul Davis
 * 2/26/2021
 * Queue Encryption Program
 * This program takes in a sentence and encryption key, encrypting and/or decrypting the message based on user choice. It used a modified Caesar Cipher that cycles through multiple keys
 */

public class Server {
	public static String encryptMessage(String message, String keyString) {
		String encryptedMessage = "";
		ListQueue<Integer> keyQueue = getKey(keyString);

		for (int i = 0; i < message.length(); i++) {
			int ascii = (int) message.charAt(i);
			int encryptedAscii = (ascii + keyQueue.first()) % 127;
			System.out.println(encryptedAscii);
			encryptedMessage += (char) encryptedAscii;
			keyQueue.firstToLast();
		}
		return encryptedMessage;
	}

	public static String decryptMessage(String message, String keyString) {
		String decryptedMessage = "";
		ListQueue<Integer> keyQueue = getKey(keyString);

		for (int i = 0; i < message.length(); i++) {
			int ascii = (int) message.charAt(i);
			int decryptedAscii = (ascii - keyQueue.first()) % 127;
			System.out.println(decryptedAscii);
			decryptedMessage += (char) decryptedAscii;
			keyQueue.firstToLast();
		}

		return decryptedMessage;
	}

	private static ListQueue<Integer> getKey(String keyString) {
		ListQueue<Integer> keyQueue = new ListQueue<Integer>();
		String[] numArray = keyString.split(" ");

		for (int i = 0; i < numArray.length; i++) {
			keyQueue.enqueue(Integer.parseInt(numArray[i]));
		}

		return keyQueue;
	}
}