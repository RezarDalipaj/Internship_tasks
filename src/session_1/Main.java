package session_1;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int nr = 0;
        Survey[] surveys = new Survey[25];
        String check;
        do {
            System.out.println("Creating survey...");
            System.out.println("Title of the survey:");
            String titlee = read.nextLine();
            System.out.println("Topic of the survey:");
            String topicc = read.nextLine();
            System.out.println("Description of the survey:");
            String descc = read.nextLine();
            System.out.println("Please enter the number of questions for the survey(10-40):");
            int quests=0;
            int ok = 0;
            do {
                try {
                    quests = read.nextInt();
                    ok = 1;
                }
                catch (InputMismatchException e){
                    System.out.println("You should input a number");
                    read.nextLine();
                }
            }while (ok!=1);
            if (quests >= 10 && quests <= 40) {
                read.nextLine();
                Question[] questsionss = new Question[quests];
                surveys[nr] = new Survey(titlee, topicc, descc);
                for (int i = 0; i < quests; i++) {
                    System.out.println("Package1.Question #" + (i + 1) + ":");
                    String actualquest = read.nextLine();
                    questsionss[i] = new Question(actualquest, surveys[nr], i);
                    surveys[nr].addQuestion(questsionss[i]);
                    try {
                        if (surveys[nr].getQuestions(i).getQuestion() != actualquest) {
                            i--;
                        }
                    } catch (NullPointerException e) {
                        i--;
                    }
                }
                System.out.println("Package1.Survey created successfully");
//                System.out.println("Printing survey\n");
//                surveys[nr].printSurvey();

            } else {
                read.nextLine();
                System.out.println("Package1.Survey couldnt be created (requires 10-40 questions)");
            }
            System.out.println("Press 0 to stop adding surveys (other to add more)");
            nr++;
            check = read.nextLine();
        } while (!(check.equalsIgnoreCase("0")));
        String k;
        int nr_c = 0;
        Candidate[] candidates = new Candidate[100];
        do {
            System.out.println("Creating candidate");
            System.out.println("Package1.Candidate first name:");
            String fname = read.nextLine();
            System.out.println("Package1.Candidate last name:");
            String lname = read.nextLine();
            candidates[nr_c] = new Candidate(fname, lname);
            int l = 0;
            String ctrl;
            do {
                System.out.println("Press 1 to take the survey " + surveys[l].getTitle() + " (other to skip it)");
                ctrl = read.nextLine();
                if (!(ctrl.equalsIgnoreCase("1"))) {
                    l++;
                    continue;
                }
                candidates[nr_c].takeSurvey(surveys[l]);
                l++;
            } while (l < nr);
            nr_c++;
            System.out.println("Press 0 to stop adding candidates (other to add more)");
            k = read.nextLine();
        } while (!(k.equalsIgnoreCase("0")));
        for (int p = 0; p < nr; p++) {
            surveys[p].mostGivenAnswer();
            surveys[p].printSurveyResults();
            for (int x = 0; x < nr_c; x++) {
                surveys[p].printAnswersCandidate(candidates[x]);
            }
        }
        int max = candidates[0].getNrSurveys();
        int imax = 0;
        for (int i = 1; i < nr_c; i++) {
            if (candidates[i].getNrSurveys() > max) {
                max = candidates[i].getNrSurveys();
                imax = i;
            }
        }
        System.out.println("\nThe candidate with the most surveys:\n" + candidates[imax].getFirstName());
        System.out.println("\nEnter the survey title where you want to add a question");
        String survAdd = read.nextLine();
        System.out.println("\nEnter the question you want to add");
        String add = read.nextLine();
        int exsists = -1;
        int a=-1;
        int m;
        for (m=0;m<nr;m++){
            if (surveys[m].getTitle().equalsIgnoreCase(survAdd)){
                exsists = 1;
                a=m;
                break;
            }
        }
        if (exsists == 1){
            surveys[a].addQuest(add);
            surveys[a].printSurvey();
        }
        else {
            System.out.println("\nThis survey does not exist");
        }
        System.out.println("\nEnter the survey title where you want to remove a question");
        String survRemove = read.nextLine();
        System.out.println("\nEnter the question you want to remove");
        String remove = read.nextLine();
        int exs = -1;
        int j;
        int t=-1;
        for (j=0;j<nr;j++){
            if (surveys[j].getTitle().equalsIgnoreCase(survRemove)){
                exs = 1;
                t=j;
                break;
            }
        }
        if (exs == 1){
            surveys[t].removeQuestion(remove);
            surveys[t].printSurvey();
        }
        else {
            System.out.println("\nThis survey does not exist");
        }

        for (int i=0;i<nr;i++){
            System.out.println("\nRemoving unneccessary questions from survey "+surveys[i].getTitle()+"\n");
            surveys[i].removeUnneccessaryQuestsions();
            surveys[i].printSurvey();
        }
    }
}
