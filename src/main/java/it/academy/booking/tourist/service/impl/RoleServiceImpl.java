package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.RoleRepository;
import it.academy.booking.tourist.request.Role;
import it.academy.booking.tourist.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role save(Role role){
        return roleRepository.save(role);
    }

    public Optional<Role> findById(Long id){
        return roleRepository.findById(id);
    }

    public void delete(Role role){
        roleRepository.delete(role);
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public Role saveAndFlush(Role role){
        return roleRepository.saveAndFlush(role);
    }
}
