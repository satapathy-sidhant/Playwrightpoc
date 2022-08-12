package main.actors;

public interface Actors<T> {

    static Provider janeDoe() {
        return Provider.Builder.withName("Jane", "Doe").withUsername("jdoe").build();
    }

    public T build();

}