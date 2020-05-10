package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.Role;

import java.util.List;

public interface RoleService {
    Role save(Role role);

    Role findById(Long id);

    void delete(Role role);

    List<Role> findAll();

    Role saveAndFlush(Role role);
}
