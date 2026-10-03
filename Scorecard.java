public class Scorecard {
    private final boolean[] results;
    private int recordedCount;
    private final int totalQuestions;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recordedCount < totalQuestions) {
            results[recordedCount] = correct;
            recordedCount++;
        }
        // else: ignored, no more room
    }

    // Only the computed score is exposed, never the array itself.
    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println(sc.getScore()); // 3
    }
}