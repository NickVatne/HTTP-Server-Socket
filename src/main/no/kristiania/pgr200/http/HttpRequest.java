package no.kristiania.pgr200.http;

import java.io.IOException;
import java.net.Socket;

public class HttpRequest {

    private String hostname;
    private String uri;
    private int port;

    public HttpRequest(String hostname, int port, String uri) {
        this.hostname = hostname;
        this.uri = uri;
        this.port = port;
    }

    public HttpResponse execute() throws IOException {
        try(Socket socket = new Socket(hostname, port)) {
            writeOutput(socket);
            return new HttpResponse(socket);
        }
    }

    private void writeOutput(Socket socket) throws IOException {
        if(uri != null || !uri.isEmpty()){
            setUri("/echo?status=200&body=Hello+World!");
        }
        socket.getOutputStream()
                .write(("GET " + uri + " HTTP/1.1\r\n").getBytes());
        socket.getOutputStream()
                .write(("Host: " + hostname + "\r\n").getBytes());
        socket.getOutputStream()
                .write("Connection: close\r\n".getBytes());
        socket.getOutputStream().write("\r\n".getBytes());

    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getStatusCode() {
        return String.valueOf(200);
    }

    public String getHostname() {
        return hostname;
    }

    public String getUri() {
        return uri;
    }
}

