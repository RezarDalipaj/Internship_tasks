public class Question {
    private String question;
    private Survey survey;
    private int questionNr;
    Question(String q, Survey s, int quest){
        setQuestion(q);
        setSurvey(s);
        setQuestionNr(quest);
    }

    public String getQuestion() {
        return question;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public int getQuestionNr() {
        return questionNr;
    }

    public void setQuestionNr(int questionNr) {
        this.questionNr = questionNr;
    }
}

