package no.kristiania.pgr200.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class HttpRequest {
	
	private String path;
	private String host;
	private int port;
	
	public HttpRequest(String path, String host, int port){
		this.path = path;
		this.host = host;
		this.port = port;
	}

	public HttpRequest execute() throws IOException {
		try(Socket socket = new Socket(host, port)) {
			socket.getOutputStream()
					.write(("GET " + path + " HTTP/1.1\r\n").getBytes());
			socket.getOutputStream()
					.write(("Host: " + host + "\r\n").getBytes());
			socket.getOutputStream()
					.write("Connection: close\r\n".getBytes());
			socket.getOutputStream().write("\r\n".getBytes());


			return new HttpResponse(socket);
		}

	/*public void writeRequest(OutputStream ) throws IOException {
		output.write(("GET " + path + "HTTP/1.1\r\n").getBytes());
		output.write(("GET " + host + "\r\n").getBytes());
		output.write("\r\n\r\n".getBytes());
	}*/
	}

	public String getStatusCode() {
		return String.valueOf(200);
	}
}
