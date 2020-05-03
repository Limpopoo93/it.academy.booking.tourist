package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.RoleRepository;
import it.academy.booking.tourist.request.Role;
import it.academy.booking.tourist.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    @Transactional
    public Role save(Role role) {
        return roleRepository.save(role);
    }
    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }
    @Override
    @Transactional
    public void delete(Role role) {
        roleRepository.delete(role);
    }
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
    @Override
    @Transactional
    public Role saveAndFlush(Role role) {
        return roleRepository.saveAndFlush(role);
    }
}
