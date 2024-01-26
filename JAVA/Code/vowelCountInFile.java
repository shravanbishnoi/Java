import java.io.FileReader;
import java.io.IOException;


// The below program counts the number of Vowels and consonants after reading a text file
public class vowelCountInFile{
	public static void main(String[] args) throws IOException {
		try{
			FileReader file = new FileReader("output.txt");
			int i;
			int vcount = 0;
			int ccount = 0;
			while ((i=file.read())!=-1){
				char c = Character.toLowerCase((char)i);
				if ((c=='a') || (c=='e') || (c=='i') || (c=='o') || (c=='u')) {
					vcount++;
				}
				else if (Character.isLetter(c)){
					ccount++;
				}
			}
			file.close();
			int tcount = vcount + ccount;
			System.out.println("Total number of Vowels in the file: "+ vcount);
			System.out.println("Total number of Consonants in the file: "+ ccount);
			System.out.println("Total number of Alphabets in the file: "+ tcount);
		}
		catch(ArithmeticException e){
			System.out.println(e.toString());
		}
	}
}