import java.security.SecureRandom;
import java.util.*;

public class HousieTicket {
    private List<Integer> row1 = new ArrayList<>();
    private List<Integer> row2 = new ArrayList<>();
    private List<Integer> row3 = new ArrayList<>();
    private Set<Integer> setOfNumbers = new HashSet<>();

    public List<Integer> getRow1() {
        return row1;
    }

    public void setRow1(List<Integer> row1) {
        this.row1 = row1;
    }

    public List<Integer> getRow2() {
        return row2;
    }

    public void setRow2(List<Integer> row2) {
        this.row2 = row2;
    }

    public List<Integer> getRow3() {
        return row3;
    }

    public void setRow3(List<Integer> row3) {
        this.row3 = row3;
    }

    public Set<Integer> getSetOfNumbers() {
        return setOfNumbers;
    }

    public void setSetOfNumbers(Set<Integer> setOfNumbers) {
        this.setOfNumbers = setOfNumbers;
    }

    public HousieTicket(){
        Random secureRandom = new Random();
        for(int i=0;i<5;i++){
            Integer n1 = secureRandom.nextInt(90) + 1;
            while(setOfNumbers.contains(n1)){
                n1 = secureRandom.nextInt(90) + 1;
            }
            setOfNumbers.add(n1);
            Integer n2 = secureRandom.nextInt(90) + 1;
            while(setOfNumbers.contains(n2)){
                n2 = secureRandom.nextInt(90) + 1;
            }
            setOfNumbers.add(n2);
            Integer n3 = secureRandom.nextInt(90) + 1;
            while(setOfNumbers.contains(n3)){
                n3 = secureRandom.nextInt(90) + 1;
            }
            setOfNumbers.add(n3);
            row1.add(n1);
            row2.add(n2);
            row3.add(n3);
        }
        row1.sort(Comparator.naturalOrder());
        row2.sort(Comparator.naturalOrder());
        row3.sort(Comparator.naturalOrder());
    }
}
