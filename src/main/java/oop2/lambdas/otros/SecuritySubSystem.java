package oop2.lambdas.otros;

public class SecuritySubSystem {
    public boolean checkPermission(String userId) {
        if (userId.equals("1")) {
            return true;
        }
        return false;
    }
}
