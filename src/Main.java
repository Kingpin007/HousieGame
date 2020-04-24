import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        HousieBoard housieBoard = new HousieBoard();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of players ");
        int n = sc.nextInt();
        List<Player> players = new ArrayList<>();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.println("Enter player name : ");
            String name = sc.nextLine();
            players.add(new Player(name,new HousieTicket()));
        }
        System.out.println("Will begin game now");
        while(!isAnyPlayerWinner(players)){
            Integer playNumber = housieBoard.play();
            System.out.println("Number for this round is : "+playNumber);
            for (Player player : players) {
                player.play(playNumber);
            }
            String command = sc.nextLine();
            while(command.contains("display")){
                if(command.contains("display-player")){
                    String[] s = command.split(" ");
                    String playerName = s[1];
                    for (Player player : players) {
                        if(player.getName().equalsIgnoreCase(playerName)){
                            player.displayHousieTicket();
                        }
                    }
                }
                else if(command.contains("display-board")){
                    housieBoard.displayHousieBoard();
                }
                command = sc.nextLine();
            }
        }
        Thread.sleep(1000);
        String command = sc.nextLine();
        while(command.contains("display")){
            if(command.contains("display-player")){
                String[] s = command.split(" ");
                String playerName = s[1];
                for (Player player : players) {
                    if(player.getName().equalsIgnoreCase(playerName)){
                        player.displayHousieTicket();
                    }
                }
            }
            else if(command.contains("display-board")){
                housieBoard.displayHousieBoard();
            }
            command = sc.nextLine();
        }
    }

    private static boolean isAnyPlayerWinner(List<Player> players) {
        for (Player player : players) {
            if(player.getStatus().equals(PlayerStatus.WINNER)){
                System.out.println(player.getName() + " is the winner !!");
                player.displayHousieTicket();
                return true;
            }
            if(player.getStatus().equals(PlayerStatus.ROW1)){
                System.out.println(player.getName() + " row1 completed !!");
                player.displayHousieTicket();
            }
            if(player.getStatus().equals(PlayerStatus.ROW2)){
                System.out.println(player.getName() + " row2 completed !!");
                player.displayHousieTicket();
            }
            if(player.getStatus().equals(PlayerStatus.ROW3)){
                System.out.println(player.getName() + " row3 completed !!");
                player.displayHousieTicket();
            }
            if(player.getStatus().equals(PlayerStatus.ROW2ROW3)){
                System.out.println(player.getName() + " row2row3 completed !!");
                player.displayHousieTicket();
            }
            if(player.getStatus().equals(PlayerStatus.ROW1ROW3)){
                System.out.println(player.getName() + " row1row3 completed !!");
                player.displayHousieTicket();
            }
            if(player.getStatus().equals(PlayerStatus.ROW1ROW2)){
                System.out.println(player.getName() + " row1row2 completed !!");
                player.displayHousieTicket();
            }
        }
        return false;
    }
}
