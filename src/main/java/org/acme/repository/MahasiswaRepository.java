package org.acme.repository;

import org.acme.model.Mahasiswa;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MahasiswaRepository implements PanacheRepositoryBase<Mahasiswa, String> {
    
}
