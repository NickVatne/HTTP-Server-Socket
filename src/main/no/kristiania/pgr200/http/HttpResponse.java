package no.kristiania.pgr200.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse extends HttpRequest {

    private InputStream input;
    private String body;
    private int statusCode;
    private Map<String, String> headers = new HashMap<>();


    public HttpResponse(Socket socket) throws IOException {
            input = socket.getInputStream();

            readStatusLine();
            readHeaderLines();
            readBody();
        }

    private void readBody() {
        //TODO
    }

    private void readStatusLine() {
        //TODO
    }

    private void readHeaderLines() {
        //TODO
    }

}

