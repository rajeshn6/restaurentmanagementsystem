package cts.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cts.rms.dto.Users;

public interface UsersRepository extends JpaRepository<Users,Integer>{
    public Users findByEmail(String email);//select * from users where email=?
}
