package Config.Utilities;

public class HelpfulShizzle {


    /**
     * Generates random words
     * @return random word
     */
    public static String wordGenerator(){
        String alphaNumericString = "0123456789"
                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz";
        StringBuilder stringBuilder = new StringBuilder(6);
        for (int i = 0; i < 6; i++){
            int index = (int) (alphaNumericString.length()
                    * Math.random());
            stringBuilder.append(alphaNumericString.charAt(index));
        } return stringBuilder.toString();
    }

}