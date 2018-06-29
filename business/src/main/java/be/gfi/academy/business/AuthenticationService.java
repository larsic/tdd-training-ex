package be.gfi.academy.business;

public interface AuthenticationService {

    boolean login(String userName, String password);
}
