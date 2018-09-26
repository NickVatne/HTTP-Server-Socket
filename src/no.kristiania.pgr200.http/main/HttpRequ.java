import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class HttpRequ {

    private String hostname;
    private int port;
    private String path;

    public HttpRequ(String hostname, int port, String path) {
        this.hostname = hostname;
        this.port = port;
        this.path = path;
    }

    public HttpResp execute() throws IOException {
        try (Socket socket = new Socket(hostname, port)) {
            writeRequest(socket.getOutputStream());
            return new HttpResp(socket);
        }
    }

    public void writeRequest(OutputStream output) throws IOException {
        output.write(("GET " + path + " HTTP/1.1\r\n").getBytes());
        output.write("Connection: close\r\n".getBytes());
        output.write(("Host: " + hostname + "\r\n").getBytes());
        output.write("\r\n\r\n".getBytes());
        output.flush();
    }

}