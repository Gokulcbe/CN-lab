package CN;
import java.util.Scanner; 
public class Subnet {

static String blueColorCode = "\u001B[34m"; static String greenColorCode = "\u001B[32m"; static String resetColorCode= "\u001B[0m"; static String cyanColorCode= "\u001B[36m";

public static void main(String[] args) {

System.out.println(cyanColorCode+"NAME : DHARSHINI K\nROLL NO : 727722EUCS505\n"+resetColorCode);
Scanner sc = new Scanner(System.in);
System.out.print("Ip address: "); 
String ip = sc.nextLine();
String split_ip[] = ip.split("\\."); //SPlit the string after every . 
String split_bip[] = new String[4]; //split binary ip
String bip = ""; 
for(int i=0;i<4;i++){
	split_bip[i] =appendZeros(Integer.toBinaryString(Integer.parseInt(split_ip[i]))); 
	bip += split_bip[i];
}
System.out.println("Binary Format "+bip);
System.out.print("Enter the number of addresses in each subnet: "); 
int n = sc.nextInt();

//Calculation of mask
int bits = (int)Math.ceil(Math.log(n)/Math.log(2));
int mask = 32-bits;
System.out.println("Subnet mask = "+mask);

//Calculation of first address and last address 
int fbip[] = new int[32];
for(int i=0; i<32;i++)fbip[i] = (int)bip.charAt(i)-48;
for(int i=31;i>31-bits;i--)//Get first address by ANDing last n bits with 0
fbip[i] &= 0;
String fip[] = {"","","",""}; 
for(int i=0;i<32;i++)
fip[i/8] = new String(fip[i/8]+fbip[i]); 
System.out.print("Network address is = "); 
for(int i=0;i<4;i++){ 
	System.out.print(Integer.parseInt(fip[i],2)); 
if(i!=3) System.out.print(".");
}
System.out.println();

int lbip[] = new int[32];
for(int i=0; i<32;i++) lbip[i] = (int)bip.charAt(i)-48;
 
for(int i=31;i>31-bits;i--)//Get last address by ORing last n bits with 1 
	lbip[i] |= 1;
String lip[] = {"","","",""}; 
for(int i=0;i<32;i++)
lip[i/8] = new String(lip[i/8]+lbip[i]); 
System.out.print("Broadcast address is = "); 
for(int i=0;i<4;i++){ 
	System.out.print(Integer.parseInt(lip[i],2)); 
	if(i!=3) System.out.print(".");
}
System.out.println();
}
static String appendZeros(String s){ 
	String temp = new String("00000000"); 
	return temp.substring(s.length())+ s;
}
}
