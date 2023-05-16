package com.umudugudu.Service;

import com.umudugudu.Model.Umudugudu;
import com.umudugudu.Repository.UmuduguduRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UmuduguduService {


    @Autowired
    UmuduguduRepository umuduguduRepository;

    public void save(Umudugudu booking) {
        umuduguduRepository.save(booking);
    }

    public List<Umudugudu> listAll() {
        return umuduguduRepository.findAll();
    }

    public Optional<Umudugudu> findClientById(Long id) {
        return umuduguduRepository.findById(id);
    }



}
