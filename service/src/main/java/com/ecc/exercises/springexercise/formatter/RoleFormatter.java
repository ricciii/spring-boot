// package com.ecc.exercises.springexercise.service;

// import com.ecc.exercises.springexercise.service.RoleService;

// import com.ecc.exercises.springexercise.model.Role;

// import java.text.ParseException;
// import java.util.List;
// import java.util.Locale;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.format.Formatter;
// import org.springframework.stereotype.Component;

// @Component
// public class RoleFormatter implements Formatter<Role> {

//     private final RoleService roleService;


//     @Autowired
//     public RoleFormatter(RoleService roleService) {
//         this.roleService = roleService;
//     }

//     @Override
//     public String print(Role role, Locale locale) {
//         return role.getRole();
//     }

//     @Override
//     public Role parse(String text, Locale locale) throws ParseException {
//         List<Role> roles = roleService.getRolesAsList();
//         for (Role role : roles) {
//             if (role.getRole().equals(text)) {
//                 return role;
//             }
//         }
//         throw new ParseException("type not found: " + text, 0);
//     }
// }
