package com.example.Paying_Guest.Accomdation.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Paying_Guest.Accomdation.dto.OwnerRegisterRequest;
import com.example.Paying_Guest.Accomdation.dto.TenantRegisterRequest;
import com.example.Paying_Guest.Accomdation.entities.Owner;
import com.example.Paying_Guest.Accomdation.entities.Tenant;
import com.example.Paying_Guest.Accomdation.entities.User;
import com.example.Paying_Guest.Accomdation.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
private final AuthService authService;
public AuthController(AuthService authService) {
this.authService = authService;
}
@PostMapping("/register/tenant")
public User registerTenant(@RequestBody TenantRegisterRequest request) {
User user = new User();
user.setFullName(request.getFullName());
user.setEmail(request.getEmail());
user.setPassword(request.getPassword());
Tenant tenant = new Tenant();
tenant.setAge(request.getAge());
tenant.setCity(request.getCity());
tenant.setPreferredLocality(request.getPreferredLocality());
return authService.registerTenant(user, tenant);
}
@PostMapping("/register/owner")
public User registerOwner(@RequestBody OwnerRegisterRequest request) {
User user = new User();
user.setFullName(request.getFullName());
user.setEmail(request.getEmail());
user.setPassword(request.getPassword());
Owner owner = new Owner();
owner.setAge(request.getAge());
owner.setContactNumber(request.getContactNumber());
return authService.registerOwner(user, owner);
}
@PostMapping("/register/admin")
public User registerAdmin(@RequestBody User user) {
return authService.registerAdmin(user);
}
@PostMapping("/login")
public User login(@RequestParam String email, @RequestParam String password) {
return authService.login(email, password);
}
}

