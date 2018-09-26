import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


// INCOMPLETE CLASS
public class HttpPathTest {
    @Test
    public void findParam(){
        HttpPath path = new HttpPath("/echo?status=200");
        HttpQuery query = path.getQuery();

        assertThat(query.toString()).isEqualTo("status=200");
        assertThat(query.getParameter("status")).isEqualTo("200");

    }
    @Test
    public void decodeURLparam(){
        String query = "status=307&Location=http%3A%2F%2Fwww.kristiania.no";
        HttpPath path = new HttpPath("/echo?" + query);

        assertThat(path.getQuery().getParameter("Location")).isEqualTo("http://www.kristiania.no");
        assertThat(path.getQuery().toString()).isEqualTo(query);
    }

}
