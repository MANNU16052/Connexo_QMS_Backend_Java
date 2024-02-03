package QMS.QMS_Project.model.response.auth;

import com.google.gson.Gson;

public class LoginData {
    private String token = "";
    private String tokenExpiration = "";
    private String userName = "";
    private String Email = "";

    public LoginData(String token, String tokenExpiration, String userName, String email) {
        this.token = token;
        this.tokenExpiration = tokenExpiration;
        this.userName = userName;
        Email = email;
    }

    @Override
    public String toString() {
        return  new Gson().toJson(this);
    }
}
