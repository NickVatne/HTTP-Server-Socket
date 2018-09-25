package no.kristiania.pgr200.http;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = new HttpServer(0);
        try{
            server.start();
            System.out.println(server.getPort());
        } catch (IOException e){
            e.printStackTrace();
        }
        HttpRequest req = new HttpRequest("localhost", server.getPort(), "");
        try{
            req.execute();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
