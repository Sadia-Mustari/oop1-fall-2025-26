 /* Extract the username (before @) from an email address.*/
 
 public class ExtractName{
    public static void main(String[] args){

        String email = "mdmahibd2004@gmail.com";
        String extract = email.substring(0,9);

        System.out.println("Username: " + email);
    }
    
}