package resttests;

import lombok.*;

@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode

public class LoginObject {

    private String email;
    private String password;


    public LoginObject(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
