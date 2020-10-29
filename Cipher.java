/**
 * @author Ba Anh Triet Mai
 * ID:     A16614709
 * Email:  bmai@ucsd.edu
 */

/**
 * This class is used When we want to convert our plain English messages 
 * to cipher text messages and vice versa
 * by encoding and decoding them with our key. 
 */
public class Cipher {
	// we use letter 'a' as our base character
	private static final int BASE_CHAR = 'a';
	
	//method to check whether the input char is a lower case or not
	public static boolean isLowerCase(char letter) {
		int characterInput = letter;
		// a lower char is valid if it has an ASCII value in the range [97, 122])
		if ((characterInput < 97) || (characterInput > 122))
			return false;
		else 
		return true;
	}
	
	/* this method is to encode input plain char and convert it to cipher char 
	 * @param plaintext, key - input plain chars
	 */
	public static char caesarShiftEncode(char plaintext, char key) {
	// check if input plaintext and key are valid
	boolean checkText = isLowerCase(plaintext);
	boolean checkKey = isLowerCase(key);
	
	char charText = plaintext;
	char cipherText;
	int charKey = key;
	//how much we shift between the 2 parallel lists
	int shift = charKey - BASE_CHAR;
	
	// if valid, convert input to ciphertext by adding plaintext with (key-'a')
	if((checkText == true) && (checkKey == true)){
	cipherText = (char) (charText + shift);
	}
	else{
	// if the input char in invalid, return null character
	cipherText = plaintext;
	}
	return cipherText;
	}
	
	/* this method is to decode input cipher char and convert it back to plain char 
	 * @param ciphertext, key - input cipher char
	 */
	public static char caesarShiftDecode(char ciphertext, char key) {
		// check if input ciphertext and key are valid
	boolean checkCipherText = isLowerCase(ciphertext);
	boolean checkKey = isLowerCase(key);
	
	char charCipherText = ciphertext;
	char plainText;
	int charKey = key;
	//how much we shift between the 2 parallel lists
	int shift = BASE_CHAR - charKey;
	
	// if valid, convert input to plain text by subtracting cipher text with (key-'a')
	if((checkCipherText == true) && (checkKey == true)){
	plainText = (char) (charCipherText + shift);
	}
	else{
	// if the input char in invalid, return null character
	plainText = ciphertext;
	}
	return plainText;
	}	
	
	
	
	//method to check whether every char in the string is lower case or not
	//loop through the string and check every char in it
	//if any char in the string is not a leter from a->z and lower case
	//the string will be invalid
	public static boolean isLowerCase(String str){
		int stringLength = str.length();
		for(int i = 0; i < stringLength; i++) {
			int characterOfString = str.charAt(i);
			if((characterOfString< 97) || (characterOfString > 122))
				return false;
		}
		return true;
	}
	/* this method is to encode input plain string and convert it to cipher string 
	 * @param plaintext, key - input plain string
	 */
	public static String vigenereEncode(String plaintext, String key) {
		// check if input plaintext and key are valid
		boolean checkPlaintext = isLowerCase(plaintext);
		boolean checkKeyStr = isLowerCase(key);
		
		String cipherStrText = "";
		// encode the string
		if((checkPlaintext == true) && (checkKeyStr == true)) {
			int plaintextLength = plaintext.length();
			int keyStrLength = key.length();
			
			for (int i = 0; i < plaintextLength; i++) {
				int characterOfString = plaintext.charAt(i);
				int keyPosition = 0;
				int characterOfKey = key.charAt(keyPosition);
				int characterOfStringCode = characterOfString - BASE_CHAR;
				int characterOfKeyCode = characterOfKey - BASE_CHAR;
				char keyEncode =  (char) ((characterOfStringCode + characterOfKeyCode) % 26);
				cipherStrText += (char)(keyEncode + BASE_CHAR);
				keyPosition = (keyPosition + 1) % keyStrLength;
				
			}
		}
		return cipherStrText;
	}

	public static String vigenereDecode(String ciphertext, String key) {
				// check if input ciphertext and key are valid
		boolean checkCiphertext = isLowerCase(ciphertext);
		boolean checkKeyStr = isLowerCase(key);
		
		String plainStrText = "";
		// encode the string
		if((checkCiphertext == true) && (checkKeyStr == true)) {
			int ciphertextLength = ciphertext.length();
			int keyStrLength = key.length();
			
			for (int i = 0; i < ciphertextLength; i++) {
				int characterOfString = ciphertext.charAt(i);
				int keyPosition = 0;
				int characterOfKey = key.charAt(keyPosition);
				int characterOfStringCode = characterOfString - BASE_CHAR;
				int characterOfKeyCode = characterOfKey - BASE_CHAR;
				char keyDecode =  (char) ((characterOfStringCode - characterOfKeyCode) % 26);
				plainStrText += (char)(keyDecode + BASE_CHAR);
				keyPosition = (keyPosition + 1) % keyStrLength;
			}
		}
		return plainStrText;
	}
