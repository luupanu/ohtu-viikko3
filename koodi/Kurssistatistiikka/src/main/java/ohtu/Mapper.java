package ohtu;

public interface Mapper {
    void setResource(String resource);
    <T> T getMapped(Class<T> classOfT);
}