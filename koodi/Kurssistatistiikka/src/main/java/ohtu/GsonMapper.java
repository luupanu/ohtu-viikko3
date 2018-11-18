package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class GsonMapper implements Mapper {
    String resource;

    public GsonMapper(String url) {
        setResource(url);
    }

    public <T> T getMapped(Class<T> myClass) {
        String body = null;
        try {
            body = Request.Get(resource).execute().returnContent().asString();
        } catch (IOException e) {
            System.out.println("error fetching resource from " + resource);
        }
        Gson mapper = new Gson();
        Object returnable = mapper.fromJson(body, myClass);
        return myClass.cast(returnable);
    }

    public void setResource(String url) {
        this.resource = url;
    }
}