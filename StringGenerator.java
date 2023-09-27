import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringGenerator {
    private boolean upperCase = true;
    private boolean lowerCase = true;
    private boolean numbers = true;
    private boolean symbols = true;

    private final int[] UPPER = {65, 90};
    private final int[] LOWER = {97, 122};
    private final int[] SYMBOL = {33, 47};
    private final int[] NUMBER = {48, 57};

    private final Pattern validChars = Pattern.compile("[u|l|n|s]+");//Match strings that only contain these chars

    public boolean checkInputForValidCharacters(String userInput){

        Matcher matchValidChars = validChars.matcher(userInput.toLowerCase());
        if(matchValidChars.matches())
            return true;

        return false;
    }
    public void setBools(String userInput){

        if(userInput.toLowerCase().contains("u"))
            upperCase = true;
        else
            upperCase = false;

        if(userInput.toLowerCase().contains("l"))
            lowerCase = true;
        else
            lowerCase = false;

        if(userInput.toLowerCase().contains("n"))
            numbers = true;
        else
            numbers = false;

        if(userInput.toLowerCase().contains("s"))
            symbols = true;
        else
            symbols = false;
    }

    public String genString(int len) throws NegativeArraySizeException {
        StringBuilder sb = new StringBuilder(len);

        while(sb.length() != len){
            int rand = (int)(Math.floor(Math.random()*4));
            switch(rand){
                case 0:
                    if (upperCase){
                        sb.append(randomChar(UPPER[0],UPPER[1]));
                    }
                    break;
                case 1:
                    if (lowerCase){
                        sb.append(randomChar(LOWER[0],LOWER[1]));
                    }
                    break;
                case 2:
                    if (numbers){
                        sb.append(randomChar(NUMBER[0],NUMBER[1]));
                    }
                    break;
                case 3:
                    if (symbols){
                        sb.append(randomChar(SYMBOL[0],SYMBOL[1]));
                    }
                    break;
            }
        }
        return sb.toString();
    }


    public char randomChar(int lo, int hi) {
        //Make inclusive [lo-hi] range
        //Cast to int then to char
        return (char)((int) Math.floor(Math.random() * (hi + 1 - lo) + lo));
    }
}
