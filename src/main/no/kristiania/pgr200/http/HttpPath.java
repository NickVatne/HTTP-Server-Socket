package no.kristiania.pgr200.http;

public class HttpPath {

    private String path;
    private int qPos = path.indexOf("?");

    public HttpPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path.substring(0, qPos);
    }

    public String[] getPathParts() {
        String[] pathParts = path.substring(0, qPos).split("/");
        return pathParts;
    }

    public HttpQuery getQuery() {
        String query = path.substring(qPos+1);
        return new HttpQuery(query);
    }



}
