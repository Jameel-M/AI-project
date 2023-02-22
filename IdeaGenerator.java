package org.example;

import java.util.Scanner;
//عشان اخذ الميثود الي ف داتا بيس
public class IdeaGenerator extends dataBase {
    private  dataBase dataBase;
    // هنا ما خليته فاينال لانه فيه افكار تنضاف لها
    private final Scanner scanner;

    public IdeaGenerator() {
        dataBase = new dataBase();
        scanner = new Scanner(System.in);
    }
        //الميثود الاساسي الي اشتغل فيه البرنامج
    public void run() {
        System.out.println("Hello, I am a generator of ideas for you.");
        while(true){
            System.out.println("1. run 2. devMode 3. exit");
            int answer = scanner.nextInt();
            if(answer == 1){
                while (true) {
                    scanner.nextLine();
                    System.out.println("What do you need?");
                    String input = scanner.nextLine().toLowerCase();
                    String[] words = input.split(" ");
                    if (inputCheck(words)) {
                        String field = getField(words);
                      if (field != null) {
                            String finalOutput = getStatementStarters() + getAnswer(input); //جمل افتتاحية  \ جمل الجواب
                            System.out.println(finalOutput);
                            break;
                        } else {
                            System.out.println("Sorry, I can't help you.");  // اذا م حصل جواب للشي الي طلب عنه ف اللست  
                        }
                    }  else {
                        dataBase.getErrorMessages();
                        break;
                    
                    }
                }
            }

            //خيار للمستخدم يضيف كلمة ف اللست يستخدمها 
            else if(answer == 2){
                System.out.println("enter word for statement starter");
                String ask = scanner.next();
                addAskSynonyms(ask);
                System.out.println("enter word for statement keyword");
                String idea = scanner.next();
                addIdeas(idea);
            }
            else if(answer == 3){
                System.out.println("Thank You For using app <3");
                break;
            }
            else{
                System.out.println("wrong input"); //اذا ادخل رقم غلط راح يعيد البرنامج 
            }
        }
        scanner.close();
        System.exit(0);
    }
    // هذا الميثود عشان يتأكد اذا المستخدم ادخل جملة يبغى يسال فيها عن حاجة

    // i want some project in security
    private boolean inputCheck(String[] words) {
        boolean wantToFlag = false;
        boolean ideaTypeFlag = false;
        for (String word : words) {
            for (String synonym : askSynonyms) {
                if (word.contains(synonym)) {
                    wantToFlag = true;
                    break;
                }
            }
            // check for synonyms of "ideas"
            for (String synonym : ideas) {
                if (word.contains(synonym)) {
                    ideaTypeFlag = true;
                    break;
                }
            }
        }
        return wantToFlag && ideaTypeFlag;
    }
    //هنا البرنامج يشوف المجال مثال: الذكاء الاصطناعي او تطبيقات الجوال
    private String getField(String[] words) {
        for (String word : words) {
            return getField(word);
        }
        return null;
    }
    // الشرط  عشان يدور ف اللست كامل واذا زاد اللآي حيروح للي بعده
    private String getField(String field) {
        String idea = "";
        for(int i = 0; i < field.length(); i++) {
            for (String s : synonym.get(i)) {
                if (s.contains(field)) {
                    idea = s;
                    break;
                }
            }
        }
        if(idea.equals("")){
            return "not found";
        }
        else{
            return idea;
        }
    }
}
