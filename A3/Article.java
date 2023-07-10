

// if String null =>exit
package First;

import java.io.*;



public class Article {


    public static void processFilesForValidation(BufferedReader b, PrintWriter ieeePr, PrintWriter acmPr, PrintWriter njPr) throws FileInvalidException, IOException{
        int counter=1;
        String s;
        String title = null;
        String author = null;
        String journal= null;
        String volume= null;
        String page = null;
        String number = null;
        String month= null ;
        String year= null;
        String ieeeStyle=null;
        String doi= null;
        String authorAcm= null;
        String titleAcm = null;
        String acmStyle= null;
        String volumeAcm = null;
        String naturalJournalStyle = null;
        String njAuthor = null;
        String authorIe=null;


        while((s = b.readLine()) != null ) {


            if (s.startsWith("}")) {
                if(author == null || title== null  || journal==null || volume==null || number ==null || page==null || month ==null || year == null || doi == null ){

                    throw new FileInvalidException("File is invalid.");

                }
                ieeeStyle = authorIe.trim() + ". " + title.trim()+ ", " + journal.trim() + ", " + volume.trim() + ", " + number.trim() + ", " + "p. " + page.trim()+ ", " + month.trim()+ " " + year.trim()+ ". ";

                acmStyle = "[" +   counter + "]" + "   " + authorAcm.trim()+ " " + titleAcm.trim() + ". "+  journal.trim() + ". " + volumeAcm.trim() +", "+ number.trim() + " (" + year.trim() + "), " + page.trim()+ ". "  + doi.trim()+ ".";

                naturalJournalStyle = njAuthor.trim() + ". " + title.trim() + ". "+ volumeAcm.trim()+ ", "+ page.trim()+ "("+ year.trim()+").";

                ieeePr.println(ieeeStyle);
                acmPr.println(acmStyle);
                njPr.println( naturalJournalStyle);
                counter++;

            }
/**
 * get the substring fpr title
 */
                if (s.startsWith("title")) {

                    title = s.substring(7, s.length() - 3);
                    if(title.equals("")){
                        throw new FileInvalidException("Invalid year");

                    }
//                    System.out.println(" \""+   title + "\" ");
                     titleAcm= s.substring(7, s.length() - 3);





                }
            /**
             * get the substring for author
             */
            if (s.startsWith("author")) {

                    author = s.substring(8, s.length() - 3);
                    if(author.equals("")){
                        throw new FileInvalidException("Invalid year");

                    }
                /**
                 * replace and with , for IEEE style
                 */
                authorIe= author.replace(" and", ",");
//                    System.out.println(author);

                    String and = "and";
                    if(author.indexOf(and) != -1) {
                        String acm = author.substring(0, author.indexOf(and));
                        authorAcm = acm + " et al.";
                        njAuthor = author.replace("and", "&");
                    }else{
                        authorAcm = author;
                        njAuthor = author;
                    }
                }
            /**
             * get the journal substrin g
             */
                if (s.startsWith("journal")) {
                    journal = s.substring(9, s.length() - 3);
//                    System.out.println(journal);
                    if(journal.equals("")){
                        throw new FileInvalidException("Invalid year");

                    }
                }
                if (s.startsWith("volume")) {
                    String st = s.substring(8, s.length() - 3);
                    volume = "vol. " + st;
                    volumeAcm= st;
//                    System.out.println("vol. "+ volume);
                    if(volume.equals("")){
                        throw new FileInvalidException("Invalid year");

                    }
                }
                if (s.startsWith("number")) {
                    number = "no. " + s.substring(8, s.length() - 3);
//                System.out.println("no. "+ number);
                    if(number.equals("")){
                        throw new FileInvalidException("Invalid year");

                    }
                }
                if (s.startsWith("page")) {
                    page = s.substring(7, s.length() - 3);
//                    System.out.println("p. "+ page);
                    if(page.equals("")){
                        throw new FileInvalidException("Invalid page");

                    }

                }
                if (s.startsWith("month")) {
                    month = s.substring(7, s.length() - 2);
//                System.out.println(month);
                    if(month.equals("")){
                        throw new FileInvalidException("Invalid month");

                    }
                }
                if (s.startsWith("year")) {
                    year = s.substring(6, s.length() - 3);
                  if(year.equals("")){
                      throw new FileInvalidException("Invalid year");

                  }
                }
                if(s.startsWith("doi")){
                    doi = "DOI:https://doi.org/" +s.substring(5, s.length()- 3 );
                    if(doi.equals("")){
                        throw new FileInvalidException("Invalid doi");

                    }
                }



            }





    }



}
