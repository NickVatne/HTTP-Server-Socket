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
	
	public void writeRequest(OutputStream output) {
		output.write(("GET " + path + "HTTP1.1\r\n").getBytes());
	}
	
}
