import javax.sound.midi.*;

public class CTCIJukeBox{

    public static void main(String[] args) {
        System.out.println("About to play some music!");
        Player player = new Player();
        player.play("C D E F G A B");
    }

}