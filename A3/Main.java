
/*
//1) open file
//read file
check validation
convert text to ieee {
        1.
new file
write ieee in new file
save
 */


package First;

 import java.io.*;
 import java.nio.file.Files;
 import java.util.Scanner;

public class Main {


//        public static void copyFile(BufferedReader br, PrintWriter pr) throws IOException {
//    BufferedReader b = new BufferedReader(new FileReader("Latex1.bib"));
//        String s = null;
//        while(s != null){
//            pr.println(s);
//            s = br.readLine();
//        }
//    }
    public static void main(String[] args) {
/**
 * scanner takes name of the file
 */
//        Scanner kb = new Scanner(System.in);
//        String filePath;
//        System.out.println("Enter the name of the file. ");
//        filePath= kb.nextLine();
//        File f = new File(filePath);
//         if(!f.exists() || !f.isDirectory()){
//             System.out.println("File does not exist");
//             System.exit(0);
//         }
//
//        try{
//    BufferedReader b = new BufferedReader(new FileReader(filePath));
//
//        } catch(FileNotFoundException e){
//
//                  System.out.println("File does not exist");
//                  System.exit(0);
//        }
         String filePath = "/Users/kimiagoodarzi/Desktop/Comp249_F22_Assg3-Part1_Needed-Files (2)/";

        /**
         * make file for IEEE and ACM and NJ
         */
        try {
            for (int i = 1; i <= 10; i++) {

            File file = new File(filePath+ "IEEE" + i+ ".json");
                    if(!file.createNewFile()){
                        System.exit(-1);
                    }
                    File fileAcm = new File(filePath+ "ACM" + i+ ".json");
                if(!fileAcm.createNewFile()){
                    System.exit(-1);
                }
                File fileNj = new File(filePath+ "NJ" + i+ ".json");
                if(!fileNj.createNewFile()){
                    System.exit(-1);
                }
                /**
                 * print the information to the files and save them
                 */
                    PrintWriter i3Pr = new PrintWriter(new FileWriter(file),true);
                    PrintWriter acm = new PrintWriter(new FileWriter(fileAcm),true);
                PrintWriter nj = new PrintWriter(new FileWriter(fileNj),true);


/**
 * check the validation of the file
 */
                BufferedReader b = new BufferedReader(new FileReader(filePath + "Latex" + i + ".bib"));
                try {
                    Article.processFilesForValidation(b, i3Pr, acm, nj);

                }
                /**
                 * catch the FileInvalidException exception if file is invalid
                 */
                catch(FileInvalidException e){
                    System.out.println(e.getMessage());
                    System.out.println("Could not open file : " + "Latex"+ i+ ".bib" );
                    file.delete();
                    fileAcm.delete();
                    fileNj.delete();


                }
                    i3Pr.close();
                    b.close();




            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file you want to open: ");
        String fos ;
        fos = filePath + sc.nextLine();
        try{
            BufferedReader b = new BufferedReader(new FileReader(fos));
            String s;
            while((s= b.readLine()) != null){
                System.out.println(s);
            }

        }
        catch(FileNotFoundException e){
            System.out.println("File doesn't exist");
        }
        catch (java.io.IOException e){
            System.out.println("Invalid file");
        }


    }


    }

//    Scanner [] files = new Scanner [10];
//    int counter =0;
//try {
//    for (int i =0 ; i<files.length; i++){
//
//        files[i] = new Scanner (FileInputStream(pathname))
//
//    counter++
//    }
//}
//catch (IOException e ){
//    System.out.print("the file does not exist ")
//        for (int jj=0 ; jj<counter; j++)
//            files[jj].close;
//        }

