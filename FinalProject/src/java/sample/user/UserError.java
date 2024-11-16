/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

/**
 *
 * @author ADMIN
 */
public class UserError {
    private String userIDError;
    private int passwordError;
    private int confirmError;
    private String fullnameError;
    private int roleError;

    public UserError() {
    }

    public UserError(String userIDError, int passwordError, int confirmError, String fullnameError, int roleError) {
        this.userIDError = userIDError;
        this.passwordError = passwordError;
        this.confirmError = confirmError;
        this.fullnameError = fullnameError;
        this.roleError = roleError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public int getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(int passwordError) {
        this.passwordError = passwordError;
    }

    public int getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(int confirmError) {
        this.confirmError = confirmError;
    }

    public String getFullnameError() {
        return fullnameError;
    }

    public void setFullnameError(String fullnameError) {
        this.fullnameError = fullnameError;
    }

    public int getRoleError() {
        return roleError;
    }

    public void setRoleError(int roleError) {
        this.roleError = roleError;
    }
    
    
    
}
