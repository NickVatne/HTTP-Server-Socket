package no.kristiania.pgr200.http;

public class HttpPath {

    private String path;

    public HttpPath(String path) {
        this.path = path;
    }

    public String getPath() {
        int qPos = path.indexOf("?");
        path.substring(0, qPos);
        return path;
    }

    public String[] getPathParts() {
        int qPos = path.indexOf("?");
        String[] pathParts = path.substring(0, qPos).split("/");
        return pathParts;
    }

    public HttpQuery getQuery() {
        int qPos = path.indexOf("?");
        String query = path.substring(qPos+1);
        return new HttpQuery(query);
    }



}
