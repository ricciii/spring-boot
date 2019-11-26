// package com.ecc.exercises.springexercise.service;

// import com.ecc.exercises.springexercise.model.dto.ContactTypeDto;

// import java.text.ParseException;
// import java.util.List;
// import java.util.Locale;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.format.Formatter;
// import org.springframework.stereotype.Component;

// @Component
// public class ContactTypeDtoFormatter implements Formatter<ContactTypeDto> {

//     private final ContactService contactService;

//     @Autowired
//     public ContactTypeDtoFormatter(ContactService contactService) {
//         this.contactService = contactService;
//     }

//     @Override
//     public String print(ContactTypeDto typeDto, Locale locale) {
//         return typeDto.getName();
//     }

//     @Override
//     public ContactTypeDto parse(String text, Locale locale) throws ParseException {
//         List<ContactTypeDto> typeDtos = contactService.getContactTypeDtosAsList();
//         for (ContactTypeDto typeDto : typeDtos) {
//             if (typeDto.getName().equals(text)) {
//                 return typeDto;
//             }
//         }
//         throw new ParseException("type not found: " + text, 0);
//     }
// }
