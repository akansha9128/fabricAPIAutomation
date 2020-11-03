package com.ydv.utils;

import com.ydv.identity.permission.Permission;
import com.ydv.identity.permission.Query;
import com.ydv.identity.role.Role;

import java.util.List;

public class ResultWrapper {

    Query query;
    List<Permission> result;
    List<Role> roles;

    public Query getQuery() {
        return query;
    }
    public void setQuery(Query query) {
        this.query = query;
    }
    public List<Permission> getResult() {
        return result;
    }
    public void setResult(List<Permission> result) {
        this.result = result;
    }

    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles=roles;
    }

}
