package com.backend.banksphs.clientdeclaration.clientrepository;

import com.backend.banksphs.clientdeclaration.cliententity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long > {

    //Select * From Client where Id_num = ?
    @Query("SELECT c FROM Client c WHERE c.idNum = ?1")
    Optional<Client> findClientByIdNumber(Long idNum);


}
