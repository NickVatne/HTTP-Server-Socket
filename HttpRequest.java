import java.net.Socket;

import org.omg.CORBA.portable.OutputStream;

public class HttpRequest {
	
	private String path;
	private String host;
	private int port;
	
	public HttpRequest(String path, String host, int port) {
		this.path = path;
		this.host = host;
		this.port = port;
	}
	
	public HttpRequest execute() {
		try(Socket socket = new Socket(host, port);
		socket.getOutputStream();
		return new HttpResponse();)
	}
	
	public void writeRequest(OutputStream output) {
		output.write(("GET " + path + "HTTP/1.1\r\n").getBytes());
		output.write(("GET " + host + "\r\n").getBytes());
		output.write("\r\n\r\n".getBytes());
	}
	
}
