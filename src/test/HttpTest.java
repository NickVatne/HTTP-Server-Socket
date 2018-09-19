

public class HttpTest {

	@Test
	public void shouldExecuteRequest() throws IOException {
		HttpRequest request = new HttpRequest("urlecho.appspot.com", 80, "/echo?status=200");
		HttpResponse response = request.execute();
		
		assertThat(response.getStatusCode()).isEqualTo(200);
		
	}
}
