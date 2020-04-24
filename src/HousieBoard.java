import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HousieBoard {
    Map<Integer,Boolean> houseieBoard = new HashMap<>();

    public Map<Integer, Boolean> getHouseieBoard() {
        return houseieBoard;
    }

    public void setHouseieBoard(Map<Integer, Boolean> houseieBoard) {
        this.houseieBoard = houseieBoard;
    }

    public HousieBoard() {
        for(int i =1;i<=90;i++){
            houseieBoard.put(i,false);
        }
    }

    public Integer play(){
        SecureRandom secureRandom = new SecureRandom();
        int i = secureRandom.nextInt(90) + 1;
        while (houseieBoard.get(i)){
            i = secureRandom.nextInt(90) + 1;
        }
        houseieBoard.put(i,true);
        return i;
    }

    public void displayHousieBoard(){
        houseieBoard.forEach((key,value) -> {
            if(key % 10 == 0){
                System.out.println();
            }
            if(value){
                System.out.print(" " +key + " ");
            }
        });
    }
}
