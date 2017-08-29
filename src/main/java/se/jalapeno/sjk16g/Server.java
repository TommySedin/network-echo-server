package se.jalapeno.sjk16g;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class Server 
{
	public static void main( String[] args ) throws IOException
	{
		System.out.println( "Hello Server!" );

		ServerSocket socket = new ServerSocket(12345);
		
		while(true) {
			System.out.println( "Waiting for client..." );
			Socket client = socket.accept();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
						client.getInputStream()
					, "UTF-8")
				);
			BufferedWriter writer = new BufferedWriter(
										new OutputStreamWriter(
											client.getOutputStream()
										, "UTF-8")
										);
			System.out.println( "Reading message from client" );
			String msg = reader.readLine();
			System.out.println( "Sending message: " + msg);
			writer.write(msg);
			writer.flush();
			client.close();
		}
	}
}
