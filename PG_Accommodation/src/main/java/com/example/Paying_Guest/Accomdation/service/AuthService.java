package com.example.Paying_Guest.Accomdation.service;

import com.example.Paying_Guest.Accomdation.entities.Owner;
import com.example.Paying_Guest.Accomdation.entities.Tenant;
import com.example.Paying_Guest.Accomdation.entities.User;

public interface AuthService {
User registerTenant(User user, Tenant tenant);
User registerOwner(User user, Owner owner);
User registerAdmin(User user);
User login(String email, String password);
}
