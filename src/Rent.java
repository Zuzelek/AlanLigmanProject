import javax.swing.*;
import java.util.ArrayList;

public class Rent {
    ArrayList<Game> games = new ArrayList<>();

    public void addGame(){
        games.add(new Game());
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
