public class PasswordValidator {
    private String password;

    public PasswordValidator(String password) {
        this.password = password;
    }
    
    
    public String validate() {
        boolean length = false;
        boolean uppercase = false;
        boolean lowercase = false;
        boolean digit = false;
        boolean containsT = false;
        boolean containsAmpersand = false;

        if (this.password.length() >= 6 && this.password.length() <= 13) {
            length = true;
        }
        
        for (char ch: this.password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                uppercase = true;
            }
            if (Character.isLowerCase(ch)) {
                lowercase = true;
            }
            if (Character.isDigit(ch)) {
                digit = true;
            }
            if (ch == 'T') {
                containsT = true;
            }
            if (ch == '&') {
                containsAmpersand = true;
            }
        }
        
        if (length && uppercase && lowercase && digit && !containsT && !containsAmpersand) {
            return "Password validated";
        }
        else return "Password not validated";
    }
}


