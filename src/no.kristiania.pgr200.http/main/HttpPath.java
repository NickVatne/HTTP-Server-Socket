// INCOMPLETE CLASS

public class HttpPath {

    private String path;

    public HttpPath(String path) {
        this.path = path;
    }
    public String getPath(){
        if(!path.contains("?")){
            return path;
        }
        return path.substring(0, findQPos());
    }

    private int findQPos() {
        return path.indexOf("?");
    }

    public HttpQuery getQuery(){
        if(!path.contains("?")){
            return null;
        }
        return new HttpQuery(path.substring(findQPos()+1));
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getPath());
        if (getQuery()!= null){
            stringBuilder.append("?");
            stringBuilder.append(getQuery());
        }
        return stringBuilder.toString();
    }
}

