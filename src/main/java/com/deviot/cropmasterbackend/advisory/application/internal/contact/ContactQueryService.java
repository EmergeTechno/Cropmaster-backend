package com.deviot.cropmasterbackend.advisory.application.internal.contact;

import com.deviot.cropmasterbackend.advisory.domain.Services.contact.IContactQueryService;
import com.deviot.cropmasterbackend.advisory.domain.model.entities.Contact;
import com.deviot.cropmasterbackend.advisory.domain.model.queries.contact.GetContactByIdQuery;
import com.deviot.cropmasterbackend.advisory.domain.model.queries.contact.GetContactsByFarmerIdQuery;
import com.deviot.cropmasterbackend.advisory.domain.model.queries.contact.GetContactsBySpecialistIdQuery;
import com.deviot.cropmasterbackend.advisory.infrastructure.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactQueryService implements IContactQueryService {
    private final ContactRepository contactRepository;


    @Override
    public List<Contact> handle(GetContactsByFarmerIdQuery getContactsByFarmerIdQuery) {
        List<Contact> contacts=contactRepository.findContactsByFarmerId(getContactsByFarmerIdQuery.farmerId());
        return contacts;
    }

    @Override
    public List<Contact> handle(GetContactsBySpecialistIdQuery getContactsBySpecialistIdQuery) {
        List<Contact> contacts=contactRepository.findContactsBySpecialistId(getContactsBySpecialistIdQuery.specialistId());
        return contacts;
    }

    @Override
    public Contact handle(GetContactByIdQuery getContactByIdQuery) {
        Optional<Contact> contact=contactRepository.findById(getContactByIdQuery.contactId());
        if(contact.isPresent()){
            return contact.get();
        }else {
            return null;
        }
    }
}
