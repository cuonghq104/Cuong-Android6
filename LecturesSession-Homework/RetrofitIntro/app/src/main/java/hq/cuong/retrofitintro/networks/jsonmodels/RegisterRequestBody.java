package hq.cuong.retrofitintro.networks.jsonmodels;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Cuong on 12/6/2016.
 */

public class RegisterRequestBody {

    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("DayOfBirth")
    @Expose
    private Integer dayOfBirth;
    @SerializedName("MonthOfBirth")
    @Expose
    private Integer monthOfBirth;
    @SerializedName("YearOfBirth")
    @Expose
    private Integer yearOfBirth;

    /**
     *
     * @return
     * The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     * The Phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     * The customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     *
     * @param customerName
     * The CustomerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The Email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     * The Password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     * The dayOfBirth
     */
    public Integer getDayOfBirth() {
        return dayOfBirth;
    }

    /**
     *
     * @param dayOfBirth
     * The DayOfBirth
     */
    public void setDayOfBirth(Integer dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    /**
     *
     * @return
     * The monthOfBirth
     */
    public Integer getMonthOfBirth() {
        return monthOfBirth;
    }

    /**
     *
     * @param monthOfBirth
     * The MonthOfBirth
     */
    public void setMonthOfBirth(Integer monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    /**
     *
     * @return
     * The yearOfBirth
     */
    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    /**
     *
     * @param yearOfBirth
     * The YearOfBirth
     */
    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public RegisterRequestBody(String phone, String customerName, String email, String password, Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth) {
        this.phone = phone;
        this.customerName = customerName;
        this.email = email;
        this.password = password;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "RegisterRequestBody{" +
                "phone='" + phone + '\'' +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", monthOfBirth=" + monthOfBirth +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    public String toJson() {
        return "RegisterRequestBody{" +
                "phone='" + phone + '\'' +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", monthOfBirth=" + monthOfBirth +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
