package SystemDesign.SnakeAndLadder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@EqualsAndHashCode
public class Player {
        private String PlayerName;
        private int id;
        Player(String PlayerName , int id){
            this.PlayerName = PlayerName;
            this.id = id;
        }
}
