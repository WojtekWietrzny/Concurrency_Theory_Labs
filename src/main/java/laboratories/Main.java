package laboratories;

import laboratories.lab1.*;
import laboratories.lab2.MainLab2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        if( args.length > 0){
            String mainName = args[0];
            switch(mainName){
                case "lab1":
                    MainLab1 main1 = new MainLab1();
                    main1.main();
                    break;
                case "lab2":
                    MainLab2 main2= new MainLab2();
                    main2.main();
                    break;
            }

        }



    }
}