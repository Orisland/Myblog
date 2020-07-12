package JavaBean;

public class user {

    private String name;
    private String password;
    private int power;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return  "用户名:" + name + "  密码:" + password +"  权限:" + power+"\r";
    }
}
