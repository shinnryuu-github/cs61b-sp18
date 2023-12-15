import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGold {
    @Test
    public void randomTest(){
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        int count = 0, size = 0;
        String[] message = new String[200];
        for (int i = 0; i < 100; i++){
            int randomnumber = StdRandom.uniform(4);
            Integer expected, actuall;
            if (randomnumber == 0){
                solution.addFirst(i);
                student.addFirst(i);
                size++;
                message[count++] = "addFirst(" + i + ")";
            }
            else if (randomnumber == 1){
                solution.addLast(i);
                student.addLast(i);
                size++;
                message[count++] = "addLast(" + i + ")";
            }
            else if (randomnumber == 2 && size != 0) {
                size--;
                expected = solution.removeFirst();
                actuall = student.removeFirst();
                message[count++] = "removeFirst";
                String realmessage = "";
                for (i = 0; i < count; i++)
                    realmessage += message[i] + "\n";
                assertEquals(realmessage, expected, actuall);
            }
            else if (randomnumber == 2 && size == 0) {
                solution.addFirst(i);
                student.addFirst(i);
                size++;
                message[count++] = "addFirst(" + i + ")";
            }
            else if (randomnumber == 3 && size != 0) {
                size--;
                expected = solution.removeLast();
                actuall = student.removeLast();
                message[count++] = "removeLast";
                String realmessage = "";
                for (i = 0; i < count; i++)
                    realmessage += message[i] + "\n";
                assertEquals(realmessage, expected, actuall);
            }
            else {
                solution.addLast(i);
                student.addLast(i);
                size++;
                message[count++] = "addLast(" + i + ")";
            }
        }
    }
}
