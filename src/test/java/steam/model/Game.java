package steam.model;


import java.util.Objects;

public class Game {
    private String discount;
    private String price;

    public Game() {

    }

    public Game(String discount, String price) {
        this.discount = discount;
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(discount, game.discount) &&
                Objects.equals(price, game.price);
    }

    @Override
    public String toString() {
        return "Game{" +
                "discount='" + discount + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(discount, price);
    }
}
