package Package1;

import org.jetbrains.annotations.NotNull;

public class Survey {
    private Question[] questions = new Question[40];
    private Answer[][] answers = new Answer[100][40];
    private Candidate[] candidates = new Candidate[100];
    private int[] noAnswer = new int[40];
    private String title;
    private String topic;
    private String description;
    private int nrQuestions;
    private int nrAnswers;
    private int actualQuestion;
    private int nrCandidates;
    private int aAnswers;
    private int bAnswers;
    private int cAnswers;
    private int dAnswers;

    //    String [] answers = new String [40];
    Survey(String title, String topic, String desc) {
        setTitle(title);
        setTopic(topic);
        setDescription(desc);
    }

    public int getNrQuestions() {
        return this.nrQuestions;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

//    public void setAnswers(String answer, int i) {
//        this.answers[i] = answer;
//    }
//
//    public String getAnswers(int i) {
//        return answers[i];
//    }

    public Question getQuestions(int i) {
        return questions[i];
    }

    public void addQuestion(@NotNull Question q) {
        int k = 0;
        if (q.getSurvey() == this) {
            for (int i = 0; i < this.getNrQuestions(); i++) {
                if (questions[i].getQuestion().equalsIgnoreCase(q.getQuestion())) {
                    k = 1;
                }
            }
            if (k != 1) {
                this.questions[q.getQuestionNr()] = q;
                this.nrQuestions++;
            } else {
                System.out.println("Kjo pyetje ekziston\n");
            }
        }
    }

    public void addAnswer(@NotNull Answer a) {
        if (a.getSurv() == this) {
            if (this.actualQuestion == this.getNrQuestions()) {
                this.actualQuestion = 0;
            }
            this.answers[this.getNrCandidates() - 1][this.actualQuestion] = a;
            if (this.answers[this.getNrCandidates() - 1][this.actualQuestion].getAnswer().equalsIgnoreCase("Agree")) {
                this.aAnswers++;
            } else if (this.answers[this.getNrCandidates() - 1][this.actualQuestion].getAnswer().equalsIgnoreCase("Slightly Agree")) {
                this.bAnswers++;
            } else if (this.answers[this.getNrCandidates() - 1][this.actualQuestion].getAnswer().equalsIgnoreCase("Slightly Disagree")) {
                this.cAnswers++;
            } else if (this.answers[this.getNrCandidates() - 1][this.actualQuestion].getAnswer().equalsIgnoreCase("Disagree")) {
                this.dAnswers++;
            } else
                this.noAnswer[actualQuestion]++;
            this.nrAnswers++;
            this.actualQuestion++;
        }
    }

    public void mostGivenAnswer() {
        int maximum = this.aAnswers;
        if (this.bAnswers > maximum) {
            maximum = bAnswers;
        }
        if (this.cAnswers > maximum) {
            maximum = cAnswers;
        }
        if (this.dAnswers > maximum) {
            maximum = dAnswers;
        }
        if (maximum == aAnswers) {
            System.out.println("\nPergjigja me e shpeshte ne survey " + this.getTitle() + ": Agree");
        } else if (maximum == bAnswers) {
            System.out.println("\nPergjigja me e shpeshte ne survey " + this.getTitle() + ": Slightly Agree");
        } else if (maximum == cAnswers) {
            System.out.println("\nPergjigja me e shpeshte ne survey " + this.getTitle() + ": Slightly Disagree");
        } else {
            System.out.println("\nPergjigja me e shpeshte ne survey " + this.getTitle() + ": Disagree");
        }
    }

    public void printSurveyResults() {
        System.out.println("\nResults for survey " + this.getTitle() + "\n");
        for (int i = 0; i < getNrQuestions(); i++) {
            int agree = 0;
            int slightlyAgree = 0;
            int slightlyDisagree = 0;
            int disagree = 0;
            int no = 0;
            System.out.println("Results for question #" + (i + 1) + ". " + questions[i].getQuestion() + ":\n");
            for (int j = 0; j < getNrCandidates(); j++) {
                try {
                    if (answers[j][i].getAnswer().equalsIgnoreCase("Agree")) {
                        agree++;
                    } else if (answers[j][i].getAnswer().equalsIgnoreCase("Slightly Agree")) {
                        slightlyAgree++;
                    } else if (answers[j][i].getAnswer().equalsIgnoreCase("Slightly Disagree")) {
                        slightlyDisagree++;
                    } else if (answers[j][i].getAnswer().equalsIgnoreCase("Disagree")) {
                        disagree++;
                    } else {
                        no++;
                    }
                } catch (NullPointerException e) {
                    System.out.println("kot");
                }
            }
            System.out.println("Numer of candidates who chose Agree: " + agree);
            System.out.println("Numer of candidates who chose Slightly Agree: " + slightlyAgree);
            System.out.println("Numer of candidates who chose Slightly Disagree: " + slightlyDisagree);
            System.out.println("Numer of candidates who chose Disagree: " + disagree);
            System.out.println("Numer of candidates who didnt answer: " + no + "\n");
        }
    }

    public int getNrAnswers() {
        return this.nrAnswers;
    }

    public int getNrCandidates() {
        return nrCandidates;
    }

    public void addCandidate(@NotNull Candidate c) {
        this.candidates[getNrCandidates()] = c;
        this.nrCandidates++;
    }

    public void printAnswersCandidate(Candidate c) {
        int k = -5;
        int j;
        for (j = 0; j < getNrCandidates(); j++) {
            if (answers[j][0].getCand() == c) {
                k = j;
                break;
            }
        }
        if (k == j) {
            System.out.println("\nResponses of candidate " + c.getFirstName() + " in survey " + this.getTitle() + "\n");
            for (int l = 0; l < getNrQuestions(); l++) {
                System.out.println("Package1.Question #" + (l + 1) + "." + questions[l].getQuestion());
                if (answers[k][l].getAnswer() == "")
                    System.out.println("Package1.Candidate " + c.getFirstName() + " hasnt answered this question");
                else
                    System.out.println("Package1.Candidate " + c.getFirstName() + " response: " + answers[k][l].getAnswer());
            }
        } else
            System.out.println("Package1.Candidate " + c.getFirstName() + " hasnt taken this survey");
    }

    public int[] getNoAnswer() {
        return noAnswer;
    }

    public void removeQuestion(String q) {
        int exists = -1;
        int i;
        if (this.getNrQuestions()==10){
            System.out.println("\nPackage1.Survey "+this.getTitle()+" has a minimum number of questions. Cant remove question");
            return;
        }
        for (i = 0; i < getNrQuestions(); i++) {
            if (questions[i].getQuestion().equalsIgnoreCase(q)) {
                exists = 1;
                break;
            }
        }
        if (exists == 1) {
            for (int j = i; j < getNrQuestions() - 1; j++) {
                questions[j] = questions[j + 1];
            }
            questions[getNrQuestions()] = null;
            this.nrQuestions--;
            System.out.println("Package1.Question: " + q + " is deleted");
        } else
            System.out.println("This question is not in this survey");
    }

    public void printSurvey() {
        System.out.println("Package1.Survey title: " + this.getTitle());
        System.out.println("Package1.Survey topic: " + this.getTopic());
        System.out.println("Package1.Survey description: " + this.getDescription() + "\n");
        for (int i = 0; i < this.getNrQuestions(); i++) {
            System.out.println((i + 1) + ". " + this.questions[i].getQuestion());
            System.out.println("a) Agree\nb) Slightly Agree\nc) Slightly Disagree\nd) Disagree\n");
        }
    }
    public void addQuest(String q){
        Question question = new Question(q,this,getNrQuestions());
        this.addQuestion(question);
    }
    public void removeUnneccessaryQuestsions(){
        for (int i=0;i<getNrQuestions();i++){
            if (noAnswer[i]>getNrCandidates()/2)
                removeQuestion(questions[i].getQuestion());
        }
    }
}
