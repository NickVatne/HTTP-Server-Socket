import no.kristiania.pgr200.http.HttpRequest;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


import java.io.IOException;

public class HttpTest {

	@Test
	public void shouldExecuteRequest() throws IOException {
		HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, "/echo?status=200");
		HttpRequest response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(200);*/
		
	}
}
