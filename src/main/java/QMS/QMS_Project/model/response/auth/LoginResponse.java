package QMS.QMS_Project.model.response.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LoginResponse {
    private Boolean status = false;
    private String statusCode = "";
    private LoginData data = null;

    public LoginResponse(Boolean status, String statusCode, LoginData data) {
        this.status = status;
        this.statusCode = statusCode;
        this.data = data;
    }
    public LoginResponse(Boolean status, String statusCode) {
        this.status = status;
        this.statusCode = statusCode;
        this.data = null;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
