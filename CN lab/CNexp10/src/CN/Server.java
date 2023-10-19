package CN; 
import java.io.*; 
import java.text.*; 
import java.util.*; 
import java.net.*;
public class Server {
static String blueColorCode = "\u001B[34m";
static String greenColorCode = "\u001B[32m"; 
static String resetColorCode = "\u001B[0m"; 
static String cyanColorCode = "\u001B[36m";
public static void main(String[] args) throws IOException { 
	System.out.println(cyanColorCode + "NAME : DHARSHINI K\nROLL NO : 727722EUCS505\n" + resetColorCode);
ServerSocket ss = new ServerSocket(5057); 
while (true) {
Socket s = null; 
try {
s = ss.accept();
System.out.println("A new client is connected : " + s); 
DataInputStream dis = new DataInputStream(s.getInputStream());
DataOutputStream dos = new DataOutputStream(s.getOutputStream());
System.out.println("Assigning new thread for this client"); 
Thread t = new ClientHandler(s, dis, dos);
t.start();
} catch (Exception e) { 
	s.close(); 
	e.printStackTrace();
}
}
}
}


class ClientHandler extends Thread {
static String blueColorCode = "\u001B[34m";
static String greenColorCode = "\u001B[32m"; 
static String resetColorCode = "\u001B[0m"; 
static String cyanColorCode = "\u001B[36m";
DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd"); 
DateFormat fortime = new SimpleDateFormat("hh:mm:ss");

final DataInputStream dis; 
final DataOutputStream dos; 
final Socket s;
public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) { this.s = s;
this.dis = dis; this.dos = dos;
}
@Override
public void run() {
String received;
String toreturn; 
while (true) {
try {
dos.writeUTF("What do you want?[Date | Time]..\n" + "Type Exit to terminate connection.");
received = dis.readUTF();
if (received.equals("Exit")) {
System.out.println("Client " + this.s + " sends exit..."); 
System.out.println("Closing this connection."); 
this.s.close();
System.out.println("Connection closed");
break;
}
Date date = new Date();


switch (received) { case "Date":
toreturn = cyanColorCode + fordate.format(date) + resetColorCode;

dos.writeUTF(toreturn); break;
case "Time":
toreturn = cyanColorCode + fortime.format(date) +resetColorCode;

dos.writeUTF(toreturn); break;
default:
dos.writeUTF("Invalid input"); break;

}
} catch (IOException e) {
	e.printStackTrace();


}
} 
try {

	this.dis.close();
	
	this.dos.close();
}


catch (IOException e) { 
	e.printStackTrace();
}
}
}

