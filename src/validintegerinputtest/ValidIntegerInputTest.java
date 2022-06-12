package validintegerinputtest;

public class ValidIntegerInputTest {

    public static void main(String[] args) {
        class InvalidResponseException extends Exception {
        }
        String input;
        Boolean validResponse = false;
        do {
            input = Input.getString("whole number value: ");
            do {
            try{
                if (isInteger(input))
                { // convert the input String to a whole number
                Integer value = Integer.parseInt(input);
                System.out.println(value + " is an integer");
                validResponse = true;}
                else //if (!isInteger(input))
                    throw new InvalidResponseException();
            } catch(InvalidResponseException error){
                System.out.println("invalid response");
            }
            } while (!validResponse);
        } while (Repeat.repeat());
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
