public class Game {
    private String title;
    private int releaseYear;
    private String gameCategory;
    private float price;

    //4 Argument Constructor
    public Game(String title, int releaseYear, String gameCategory, float price)
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
    public void setReleaseYear(int releaseYear){
        this.releaseYear = releaseYear;
    }
    public void setGameCategory(String gameCategory){
        this.gameCategory = gameCategory;
    }
    public void setPrice(float price){
        this.price = price;
    }
    //Accessor methods
    public String getTitle(){
        return title;
    }
    public int getReleaseYear(){
        return releaseYear;
    }
    public String getGameCategory() {
        return gameCategory;
    }
    public float getPrice(){
        return price;
    }
    public String toString(){
        return "Game Title: "+getTitle() +
                "\nRelease Year: "+getReleaseYear() +
                "\nGame Category: "+getGameCategory() +
                "\nPrice: "+getPrice();
    }
}
