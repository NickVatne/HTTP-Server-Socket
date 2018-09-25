package no.kristiania.pgr200.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private int port;
    private int actualPort;

    public HttpServer(int port) throws IOException {
        this.port = port;
        start();
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        this.actualPort = serverSocket.getLocalPort();
        new Thread(() -> serverThread(serverSocket)).start();
    }

    public void serverThread(ServerSocket serverSocket) {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();

                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();

                String line = readNextLine(input);
                while (!line.isEmpty()) {
                    System.out.println(line);
                    line = readNextLine(input);
                }

                String body = "Hello world\r\n";

                output.write("HTTP/1.1 200 Ok\r\n".getBytes());
                output.write("X-Server-Name: Kristiania Web Server\r\n".getBytes());
                output.write("Connection: close\r\n".getBytes());
                output.write("Content-Type: text/plain\r\n".getBytes());
                output.write(("Content-Length: " + body.length() + "\r\n").getBytes());
                output.write("\r\n".getBytes());
                output.write(body.getBytes());

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private String readNextLine(InputStream input) throws IOException {
        StringBuilder line = new StringBuilder();

        int character;

        while ((character = input.read()) != -1) {
            if (character == '\r') {
                input.read();
                break;
            }
            line.append((char) character);
        }

        return line.toString();
    }

    public int getPort() {
        return actualPort;
    }
}