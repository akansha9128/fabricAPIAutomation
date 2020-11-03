package com.ydv.identity.user;

import com.ydv.BaseFields;

public class User extends BaseFields {


    private String registrationSite;
    private String[] roleIds;

    //private  Phone[] phone;
    private String[] provider;
    private String isActive;

    public String getRegistrationSite() {
        return registrationSite;
    }

    public void setRegistrationSite(String registrationSite) {
        this.registrationSite = registrationSite;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }
}
