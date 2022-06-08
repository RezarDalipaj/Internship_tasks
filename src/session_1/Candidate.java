package session_1;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Candidate {
    private String firstName;
    private String lastName;
    private String email;
    private int phone;
    private int nrSurveys;
    private Survey [] survs = new Survey[10];
    Candidate(String fname, String lname){
        setFirstName(fname);
        setLastName(lname);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    public void takeSurvey(Survey survey){
        this.addSurvey(survey);
        survey.addCandidate(this);
        System.out.println("Welcome to our survey "+survey.getTitle()+", "+this.getFirstName());
        System.out.println("Package1.Survey topic: " + survey.getTopic());
        System.out.println("Package1.Survey description: " + survey.getDescription()+"\n");
        Answer [] answers = new Answer[survey.getNrQuestions()];
        for(int i=0;i< survey.getNrQuestions();i++){
            System.out.println(survey.getQuestions(i).getQuestionNr()+1 + ". "+survey.getQuestions(i).getQuestion());
            System.out.println("a) Agree\nb) Slightly Agree\nc) Slightly Disagree\nd) Disagree\n");
            Scanner reader = new Scanner(System.in);
            System.out.println("Pergjigja " + (i+1)+":");
            String ans = reader.nextLine();
            if(ans.equalsIgnoreCase("A"))
            {
                answers [i] = new Answer(survey,this,i,"Agree");
                survey.addAnswer(answers[i]);
            }
            else if(ans.equalsIgnoreCase("B"))
            {
                answers [i] = new Answer(survey,this,i,"Slightly Agree");
                survey.addAnswer(answers[i]);
            }
            else if(ans.equalsIgnoreCase("C"))
            {
                answers [i] = new Answer(survey,this,i,"Slightly Disagree");
                survey.addAnswer(answers[i]);
            }
            else if(ans.equalsIgnoreCase("D"))
            {
                answers [i] = new Answer(survey,this,i,"Disagree");
                survey.addAnswer(answers[i]);
            }
            else{
                answers [i] = new Answer(survey,this,i,"");
                survey.addAnswer(answers[i]);
            }
        }
        System.out.println("\nPackage1.Survey completed!");
    }

    public int getNrSurveys() {
        return nrSurveys;
    }
    public void addSurvey(@NotNull Survey s){
        this.survs[getNrSurveys()]=s;
        this.nrSurveys++;
    }
}
