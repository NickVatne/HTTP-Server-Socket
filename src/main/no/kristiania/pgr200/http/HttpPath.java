package no.kristiania.pgr200.http;

public class HttpPath {

    private String path;

    public HttpPath(String path) {
        this.path = path;
    }

    public String pos() {
        int qPos = path.indexOf("?");
        return path.substring(0, qPos);
    }



}
