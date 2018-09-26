import java.io.IOException;

public class HttpMainClient {

    public static void main(String[] args) throws IOException {
        HttpEchoServer server = new HttpEchoServer(10080);
        HttpRequ request = new HttpRequ("Localhost", server.getPort(), "/echo?status=200&body=Hello+World!");
        HttpResp response = request.execute();
        System.out.println("NicosClient: \n\n"+response.toString());


    }
}
