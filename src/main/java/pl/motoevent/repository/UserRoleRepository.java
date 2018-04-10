package pl.motoevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.motoevent.entity.UserRole;

public interface UserRoleRepository extends JpaRepository <UserRole, Long>{

//    public UserRole findOneByUsername(String username);
}
