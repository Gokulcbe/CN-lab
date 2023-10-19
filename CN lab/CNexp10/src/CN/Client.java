package CN; 
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
static String blueColorCode = "\u001B[34m";
static String greenColorCode = "\u001B[32m";
static String resetColorCode = "\u001B[0m";
static String cyanColorCode = "\u001B[36m";
public static void main(String[] args) throws IOException {
	System.out.println(cyanColorCode + "NAME : DHARSHINI K\nROLL NO : 727722EUCS505\n" + resetColorCode);
	try {
Scanner scn = new Scanner(System.in);
InetAddress ip = InetAddress.getByName("localhost");
Socket s = new Socket(ip, 5057);
DataInputStream dis = new DataInputStream(s.getInputStream());
DataOutputStream dos = new DataOutputStream(s.getOutputStream());
while (true) {
System.out.println(dis.readUTF()); 
String tosend = scn.nextLine(); 
dos.writeUTF(tosend);
// If client sends exit,close this connection
// and then break from the while loop 
if (tosend.equals("Exit")) {
System.out.println("Closing this connection : " + s); 
s.close();
System.out.println("Connection closed"); 
break;
}
String received = dis.readUTF(); 
System.out.println(received);
}
scn.close();
dis.close();
dos.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}
