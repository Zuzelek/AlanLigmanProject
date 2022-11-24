import javax.swing.*;
import java.util.ArrayList;

public class Rent {
    ArrayList<Game> games = new ArrayList<>();
    private boolean borrowed;

    public Rent(){
        this.borrowed = false;
    }
    public void setBorrowed(){
        this.borrowed = true;
    }
    public void setReturned(){
        this.borrowed = false;
    }
    public boolean isBorrowed(){
        return this.borrowed;
    }

    }

