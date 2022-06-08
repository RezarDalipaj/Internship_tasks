package session_1;

public class Answer {
    private Survey surv;
    private Candidate cand;
    int questionNr;
    private String answer;
    Answer(Survey s, Candidate c, int quest, String ans){
        setSurv(s);
        setCand(c);
        setQuestionNr(quest);
        setAnswer(ans);
    }

    public Survey getSurv() {
        return surv;
    }

    public Candidate getCand() {
        return cand;
    }

    public int getQuestionNr() {
        return questionNr;
    }

    public String getAnswer() {
        return answer;
    }

    public void setSurv(Survey surv) {
        this.surv = surv;
    }

    public void setCand(Candidate cand) {
        this.cand = cand;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestionNr(int questionNr) {
        this.questionNr = questionNr;
    }
}

