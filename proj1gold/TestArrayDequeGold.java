import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGold {
    @Test
    public void randomTest(){
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        int size = 0;
        String message = "";
        for (int i = 0; i < 1000; i++) {
            int randomadd = StdRandom.uniform(1000);
            Integer expected = 1, actuall = 1;
            if (size == 0) {
                int randomnumber = StdRandom.uniform(2);
                if (randomnumber == 0) {
                    solution.addFirst(randomadd);
                    student.addFirst(randomadd);
                    size++;
                    message += "addFirst(" + randomadd + ")\n";
                } else if (randomnumber == 1) {
                    solution.addLast(randomadd);
                    student.addLast(randomadd);
                    size++;
                    message += "addLast(" + randomadd + ")\n";
                }
            }
            else {
                int randomnumber = StdRandom.uniform(4);
                if (randomnumber == 0) {
                    size--;
                    expected = solution.removeFirst();
                    actuall = student.removeFirst();
                    message += "removeFirst\n";
                }
                else if (randomnumber == 1) {
                    solution.addFirst(randomadd);
                    student.addFirst(randomadd);
                    size++;
                    message += "addFirst(" + randomadd + ")\n";
                }
                else if (randomnumber == 2) {
                    size--;
                    expected = solution.removeLast();
                    actuall = student.removeLast();
                    message += "removeLast\n";
                }
                else {
                    solution.addLast(randomadd);
                    student.addLast(randomadd);
                    size++;
                    message += "addLast(" + randomadd + ")\n";
                }
                assertEquals(message, expected, actuall);
            }
        }
    }
}
