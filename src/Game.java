import java.io.Serializable;

public class Game implements Serializable {
    private String title;
    private String releaseYear;
    private String gameCategory;
    private String price;
    public Game() {
    this("Unknown","Not given","Unknown","Unknown");
    }

    //4 Argument Constructor
    public Game(String title, String releaseYear, String gameCategory, String price)
    {
        setTitle(title);
        setReleaseYear(releaseYear);
        setGameCategory(gameCategory);
        setPrice(price);
    }
    //Mutator methods
    public void setTitle(String title) {
        this.title = title;
    }
    public void setReleaseYear(String releaseYear){
        this.releaseYear = releaseYear;
    }
    public void setGameCategory(String gameCategory){
        this.gameCategory = gameCategory;
    }
    public void setPrice(String price){
        this.price = price;
    }
    //Accessor methods
    public String getTitle(){
        return title;
    }
    public String getReleaseYear(){
        return releaseYear;
    }
    public String getGameCategory() {
        return gameCategory;
    }
    public String getPrice(){
        return price;
    }
    public String toString(){
        return "Game Title: "+getTitle() +
                "\nRelease Year: "+getReleaseYear() +
                "\nGame Category: "+getGameCategory() +
                "\nPrice: "+getPrice();
    }
}
