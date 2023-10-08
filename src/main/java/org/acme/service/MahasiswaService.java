package org.acme.service;

import java.util.List;
import java.util.UUID;

import org.acme.dto.request.MahasiswaRequest;
import org.acme.model.Mahasiswa;
import org.acme.repository.MahasiswaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MahasiswaService {

    @Inject
    MahasiswaRepository mahasiswaRepository;

    public List<Mahasiswa> findAll() {
        return mahasiswaRepository.listAll();

        // List<Mahasiswa> mahasiswaList = mahasiswas.get(0)
        // return mahasiswaList;
    }
    
    @Transactional  
    public Mahasiswa save(MahasiswaRequest request) {

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setId(UUID.randomUUID().toString());
        mahasiswa.setName(request.getName());
        mahasiswa.setEmail(request.getEmail());
        mahasiswa.setIsMale(request.getIsMale());
        mahasiswa.setJob(request.getJob());

        mahasiswaRepository.persist(mahasiswa);

        return mahasiswa;
    }

    @Transactional
    public boolean deleteById(String id) {
        return mahasiswaRepository.deleteById(id);
    }

    @Transactional
    public Boolean updateById(String id, MahasiswaRequest requestBody) {

        Boolean isMahasiswaUpdated = true;
        try {
            Mahasiswa mahasiswa = mahasiswaRepository.findById(id);

        if (mahasiswa == null) {
            isMahasiswaUpdated = false;
            throw new EntityNotFoundException("Mahasiswa not found with ID: " + id);
        }

        if(requestBody.getName() != null) mahasiswa.setName(requestBody.getName());
        if(requestBody.getEmail() != null) mahasiswa.setEmail(requestBody.getEmail());
        if(requestBody.getJob() != null) mahasiswa.setJob(requestBody.getJob());
        if(requestBody.getIsMale() != null) mahasiswa.setIsMale(requestBody.getIsMale());

        mahasiswaRepository.persist(mahasiswa);

        return isMahasiswaUpdated;

        } catch (Exception e) {
            // TODO: handle exception
            return isMahasiswaUpdated;
        }
    }
    
}
