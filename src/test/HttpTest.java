import no.kristiania.pgr200.http.HttpRequest;
import no.kristiania.pgr200.http.HttpResponse;
import no.kristiania.pgr200.http.HttpServer;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


import java.io.IOException;

public class HttpTest {

    private static HttpServer server;

    @BeforeClass
    public static void main(String[] args) throws IOException {
        server = new HttpServer(0);
        server.start();
    }

	@Test
	public void shouldExecuteRequest() throws IOException {
		HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, "/echo?status=200");
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(200);
		
	}
	@Test
	public void shouldReadResponseCode() throws Exception{
		HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, "/echo");
		HttpResponse response = request.execute();

		assertThat(response.getStatusCode()).isEqualTo(200);
	}
	@Test
	public void shouldReadBody() throws Exception{
		HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, "/echo?body=Hello+World!");
		HttpResponse response = request.execute();

		assertThat(response.getBody()).isEqualTo("Hello World!");
	}
	@Test
	public void shouldReadResponseCodeTest() throws Exception{
		HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, "/echo?status=404");
		HttpResponse response = request.execute();

		assertThat(response.getStatusCode()).isEqualTo(404);

	}
	@Test
    public void shouldEchoResponseBody() throws IOException{
        HttpRequest request = new HttpRequest("Localhost", server.getPort(), "/echo?body=Hello+World!");
        HttpResponse response = request.execute();

        assertThat(response.getStatusCode().isEqualTo(200));
        assertThat(response.getBody().isEqualTo("Hello World!");
    }
}
