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


    public boolean borrowGame() {
        for(Game g : games){
            if(g.isBorrowed()){
                g.setToBorrowed();
                return true;
            }
            else{
                continue;
            }

        }
        JOptionPane.showMessageDialog(null,"This game has already been borrowed","Borrowed",JOptionPane.ERROR_MESSAGE);
        return false;
    }
    public boolean returnGame(){
        for(Game g : games){
            if(g.isBorrowed()){
                g.setToReturned();
                return true;
            }
            else{
                continue;
            }
        }
        JOptionPane.showMessageDialog(null,"Please try again later","Return error",JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
