package com.deviot.cropmasterbackend.advisory.domain.Services.contact;

import com.deviot.cropmasterbackend.advisory.domain.model.entities.Contact;
import com.deviot.cropmasterbackend.advisory.domain.model.queries.contact.GetContactByIdQuery;
import com.deviot.cropmasterbackend.advisory.domain.model.queries.contact.GetContactsByFarmerIdQuery;
import com.deviot.cropmasterbackend.advisory.domain.model.queries.contact.GetContactsBySpecialistIdQuery;

import java.util.List;

public interface IContactQueryService {
    List<Contact> handle(GetContactsByFarmerIdQuery getContactsByFarmerIdQuery);
    List<Contact> handle(GetContactsBySpecialistIdQuery getContactsBySpecialistIdQuery);
    Contact handle(GetContactByIdQuery getContactByIdQuery);
}
