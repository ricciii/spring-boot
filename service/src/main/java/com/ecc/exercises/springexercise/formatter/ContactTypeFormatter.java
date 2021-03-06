// package com.ecc.exercises.springexercise.service;

// import com.ecc.exercises.springexercise.model.ContactType;

// import java.text.ParseException;
// import java.util.List;
// import java.util.Locale;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.format.Formatter;
// import org.springframework.stereotype.Component;

// @Component
// public class ContactTypeFormatter implements Formatter<ContactType> {

//     private final ContactService contactService;


//     @Autowired
//     public ContactTypeFormatter(ContactService contactService) {
//         this.contactService = contactService;
//     }

//     @Override
//     public String print(ContactType type, Locale locale) {
//         return type.getName();
//     }

//     @Override
//     public ContactType parse(String text, Locale locale) throws ParseException {
//         List<ContactType> types = contactService.getContactTypesAsList();
//         for (ContactType type : types) {
//             if (type.getName().equals(text)) {
//                 return type;
//             }
//         }
//         throw new ParseException("type not found: " + text, 0);
//     }
// }
