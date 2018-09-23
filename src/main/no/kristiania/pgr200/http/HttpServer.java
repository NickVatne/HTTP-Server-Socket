package no.kristiania.pgr200.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    //Oppretter en socket som lytter på angitt port & Starter en Thread som kjører serverStart til den gitte porten.
    public static void main(String[] args) throws IOException, InterruptedException {
        try (ServerSocket serverSocket = new ServerSocket(10080)){
            Thread thread = new Thread(() -> {
                try {
                    serverStart(serverSocket);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            thread.join();

        }

    }

    private static void serverStart(ServerSocket serverSocket){
        while (true){
            try{
                Socket socket = serverSocket.accept();

                StringBuilder requestL = new StringBuilder();

                int c;
                while ((c = socket.getInputStream().read()) != -1) {
                    if (c == '\r') {
                        break;
                    }
                    requestL.append((char)c);
                }
                System.out.print(requestL.toString());

                String statusCode = "200";
                String body = "Hello World!";
                String location = "http://wwww.google.com";

                socket.getOutputStream().write(("HTTP/1.1 " + statusCode + " OK\r\n").getBytes());
                socket.getOutputStream().write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
                if (location != null) {
                    socket.getOutputStream().write(("Location: " + location + "\r\n").getBytes());
                }
                socket.getOutputStream().write("Server: Mikaels Innlevering Server.!!\r\n".getBytes());
                socket.getOutputStream().write(("Content-Length: " + body.length() + "\r\n").getBytes());
                socket.getOutputStream().write("\r\n".getBytes());
                socket.getOutputStream().write((body + "\r\n").getBytes());
                socket.getOutputStream().flush();
        } catch (IOException e){
            e.printStackTrace();}
        }

    }

}
