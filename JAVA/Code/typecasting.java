
// Typecasting
// need to specify typecasting when some value loss exists
// need not to specify when value is expanding
public class typecasting{
	public static void main(String[] args){
		byte var1 = 10;
		int var2 = 984;
		float var3 = 9.99f;
		double var4 = 83.283982744983;
		int to_int = (int)var1;
		System.out.println("Byte to int: "+to_int);
		byte to_byte = (byte)var2;
		System.out.println("int to Byte: "+to_byte);
		int float_to_int = (int)var3;
		System.out.println("float to int: "+float_to_int);
	}
}