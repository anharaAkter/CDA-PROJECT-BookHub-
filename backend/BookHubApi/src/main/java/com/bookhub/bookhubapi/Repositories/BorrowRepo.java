package com.bookhub.bookhubapi.Repositories;

import com.bookhub.bookhubapi.Models.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepo extends JpaRepository<Borrow,Integer> {
}
