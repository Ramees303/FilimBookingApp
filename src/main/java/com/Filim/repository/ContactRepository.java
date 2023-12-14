package com.Filim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Filim.Entity.ContactUs;

@Repository
public interface ContactRepository extends JpaRepository<ContactUs, Integer> {

}
