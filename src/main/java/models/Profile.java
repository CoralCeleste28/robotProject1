package models;

public class Profile {

    private String userId = "";
    private String firstName = "";
    private String lastName = "";
    private String email = "";

    private String billingAddress = "";

    private String billingAddressLine;
    private String billingAddressCity;
    private String billingAddressState;
    private String billingAddressZipCode;
    private String billingAddressCountry;

    public void BillingAddress() { }

    public void BillingAddress(String billingAddressLine, String billingAddressCity, String billingAddressState, String billingAddressZipCode, String billingAddressCountry) {
        this.billingAddressLine = billingAddressLine;
        this.billingAddressCity = billingAddressCity;
        this.billingAddressState = billingAddressState;
        this.billingAddressZipCode =billingAddressZipCode;
        this.billingAddressCountry = billingAddressCountry;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    private String deliveryAddress = "";

    private String deliveryAddressLine;
    private String deliveryAddressCity;
    private String deliveryAddressState;
    private String deliveryAddressZipCode;
    private String deliveryAddressCountry;

    public void deliveryAddress() { }

    public void deliveryAddress(String deliveryAddressLine, String deliveryAddressCity, String deliveryAddressState, String deliveryAddressZipCode, String deliveryAddressCountry) {
        this.deliveryAddressLine = deliveryAddressLine;
        this.deliveryAddressCity = deliveryAddressCity;
        this.deliveryAddressState = deliveryAddressState;
        this.deliveryAddressZipCode = deliveryAddressZipCode;
        this.deliveryAddressCountry = deliveryAddressCountry;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Profile(){

    }

    public Profile(String userId, String firstName, String lastName, String email, String billingAddress, String deliveryAddress){

        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.billingAddress = billingAddress;
        this.deliveryAddress = deliveryAddress;
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public String getBillingAddressLine() {
        return billingAddressLine;
    }

    public String getBillingAddressCity() {
        return billingAddressCity;
    }

    public String getBillingAddressState() {
        return billingAddressState;
    }

    public String getBillingAddressZipCode() {
        return billingAddressZipCode;
    }

    public String getBillingAddressCountry() {
        return billingAddressCountry;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getDeliveryAddressLine() {
        return deliveryAddressLine;
    }

    public String getDeliveryAddressCity() {
        return deliveryAddressCity;
    }

    public String getDeliveryAddressState() {
        return deliveryAddressState;
    }

    public String getDeliveryAddressZipCode() {
        return deliveryAddressZipCode;
    }

    public String getDeliveryAddressCountry() {
        return deliveryAddressCountry;
    }

    //Setters

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBillingAddressLine(String billingAddressLine) {
        this.billingAddressLine = billingAddressLine;
    }

    public void setBillingAddressCity(String billingAddressCity) {
        this.billingAddressCity = billingAddressCity;
    }

    public void setBillingAddressState(String billingAddressState) {
        this.billingAddressState = billingAddressState;
    }

    public void setBillingAddressZipCode(String billingAddressZipCode) {
        this.billingAddressZipCode = billingAddressZipCode;
    }

    public void setBillingAddressCountry(String billingAddressCountry) {
        this.billingAddressCountry = billingAddressCountry;
    }

    public void setDeliveryAddressLine(String deliveryAddressLine) {
        this.deliveryAddressLine = deliveryAddressLine;
    }

    public void setDeliveryAddressCity(String deliveryAddressCity) {
        this.deliveryAddressCity = deliveryAddressCity;
    }

    public void setDeliveryAddressState(String deliveryAddressState) {
        this.deliveryAddressState = deliveryAddressState;
    }

    public void setDeliveryAddressZipCode(String deliveryAddressZipCode) {
        this.deliveryAddressZipCode = deliveryAddressZipCode;
    }

    public void setDeliveryAddressCountry(String deliveryAddressCountry) {
        this.deliveryAddressCountry = deliveryAddressCountry;
    }
}
