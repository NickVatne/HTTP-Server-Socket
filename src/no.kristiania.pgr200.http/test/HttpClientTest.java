import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import static org.assertj.core.api.Assertions.assertThat;

public class HttpClientTest {

    @Test
    public void shouldReadStatusCode() throws IOException {
        HttpRequ request = new HttpRequ("urlecho.appspot.com", 80, "/echo?status=200");
        HttpResp response = request.execute();

        assertThat(response.getStatusCode()).isEqualTo(200);
    }

    @Test
    public void shouldReadOtherStatusCodes() throws IOException {
        HttpRequ request = new HttpRequ("urlecho.appspot.com", 80, "/echo?status=404");
        HttpResp response = request.execute();

        assertThat(response.getStatusCode()).isEqualTo(404);
    }

    @Test
    public void shouldReadResponseHeaders() throws IOException {
        HttpRequ request = new HttpRequ("urlecho.appspot.com",
                80, "/echo?status=307&Location=http%3A%2F%2Fwww.google.com");
        HttpResp response = request.execute();

        assertThat(response.getStatusCode()).isEqualTo(307);
        assertThat(response.getHeader("Location")).isEqualTo("http://www.google.com");
    }

    @Test
    public void shouldReadResponseBody() throws IOException {
        HttpRequ request = new HttpRequ("urlecho.appspot.com",
                80, "/echo?body=Hello+world!");
        HttpResp response = request.execute();

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo("Hello world!");
    }


    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 10080)) {
            socket.getOutputStream()
                    .write("GET /echo?status=307&Location=http%3A%2F%2Fwww.google.com HTTP/1.1\r\n".getBytes());
            socket.getOutputStream()
                    .write("Host: urlecho.appspot.com\r\n".getBytes());
            socket.getOutputStream()
                    .write("Connection: close\r\n".getBytes());
            socket.getOutputStream().write("\r\n".getBytes());

            InputStream input = socket.getInputStream();

            int c;
            while ((c = input.read()) != -1) {
                System.out.print((char) c);
            }

        }
    }

}