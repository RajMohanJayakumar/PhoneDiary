public class Contact {
    private String mName;
    private String mEmail;
    private String mPhonenumber;
    private String uuid;

    //Default constructor
    public Contact() {

    }

    //Parameterized constructor for creating objects with values
    public Contact(String mName, String mPhonenumber, String mEmail) {
        this.mName = mName;
        this.mEmail = mEmail;
        this.mPhonenumber = mPhonenumber;
    }

    //Getters and Setters for the private Class Variables

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPhonenumber() {
        return mPhonenumber;
    }

    public void setmPhonenumber(String mPhonenumber) {
        this.mPhonenumber = mPhonenumber;
    }
}
