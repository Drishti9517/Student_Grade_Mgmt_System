import java.util.ArrayList;

public class GradeCalculator {
    public static float avg(ArrayList<Float> marks) {
        float n = marks.size();
        float sum = 0;
        for(int i=0; i<marks.size(); i++) {
            sum += marks.get(i);
        }
        return sum/n;
    }

    public static float max(ArrayList<Float> marks) {
        float max = Integer.MIN_VALUE;
        for(int i=0; i<marks.size(); i++) {
            if(marks.get(i) > max) {
                max = marks.get(i);
            }
        }
        return max;
    }

    public static float min(ArrayList<Float> marks) {
        float min = Integer.MAX_VALUE;
        for(int i=0; i<marks.size(); i++) {
            if(marks.get(i) < min){
                min = marks.get(i);
            }
        }
        return min;
    }
}
