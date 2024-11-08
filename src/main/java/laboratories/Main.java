package laboratories;

import laboratories.lab1.*;
import laboratories.lab2.MainLab2;
import laboratories.lab3.MainLab3;
import laboratories.lab4.MainLab4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        if( args.length > 0){
            String mainName = args[0];
            switch(mainName){
                case "lab1":
                    String option1 = args[1];
                    MainLab1 main1 = new MainLab1();
                    main1.main(option1);

                    break;
                case "lab2":
                    MainLab2 main2= new MainLab2();
                    String option2 = args[1];
                    main2.main(option2);
                    break;
                case "lab3":
                    MainLab3 main3 = new MainLab3();
                    String option3 = args[1];
                    main3.main(option3);
                    break;
                case "lab4":
                    MainLab4 main4 = new MainLab4();
                    String option4 = args[1];
                    main4.main(option4);
                    break;
            }

        }



    }
}