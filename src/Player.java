public class Player {
    private String name;
    private HousieTicket housieTicket;
    private PlayerStatus status;

    public HousieTicket getHousieTicket() {
        return housieTicket;
    }

    public void setHousieTicket(HousieTicket housieTicket) {
        this.housieTicket = housieTicket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    public Player(String name, HousieTicket housieTicket, PlayerStatus status) {
        this.name = name;
        this.housieTicket = housieTicket;
        this.status = status;
    }

    public Player(String name, HousieTicket housieTicket){
        this.name = name;
        this.housieTicket = housieTicket;
        this.status = PlayerStatus.PLAYING;
        displayHousieTicket();
    }

    public PlayerStatus play(Integer playingNumber){
        if(housieTicket.getSetOfNumbers().contains(playingNumber)){
            housieTicket.getSetOfNumbers().remove(playingNumber);
            housieTicket.getRow1().remove(playingNumber);
            housieTicket.getRow2().remove(playingNumber);
            housieTicket.getRow3().remove(playingNumber);
        }
        if(housieTicket.getSetOfNumbers().isEmpty()){
            status = PlayerStatus.WINNER;
        }
        else if(housieTicket.getRow1().isEmpty()){
            status = PlayerStatus.ROW1;
            if(housieTicket.getRow2().isEmpty()){
                status = PlayerStatus.ROW1ROW2;
            }
            else if(housieTicket.getRow3().isEmpty()){
                status = PlayerStatus.ROW1ROW3;
            }
        }
        else if(housieTicket.getRow2().isEmpty()){
            status = PlayerStatus.ROW2;
            if(housieTicket.getRow3().isEmpty()){
                status = PlayerStatus.ROW2ROW3;
            }
        }
        else if(housieTicket.getRow3().isEmpty()){
            status = PlayerStatus.ROW3;
        }
        return status;
    }

    public void displayHousieTicket(){
        for (Integer integer : housieTicket.getRow1()) {
            System.out.print(" " + integer + " ");
        }
        System.out.println();
        for (Integer integer : housieTicket.getRow2()) {
            System.out.print(" " + integer + " ");
        }
        System.out.println();
        for (Integer integer : housieTicket.getRow3()) {
            System.out.print(" " + integer + " ");
        }
        System.out.println();
    }
}
