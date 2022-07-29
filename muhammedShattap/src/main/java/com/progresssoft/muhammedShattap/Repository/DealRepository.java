package com.progresssoft.muhammedShattap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progresssoft.muhammedShattap.entity.Deal;

@Repository
public interface DealRepository extends JpaRepository <Deal,String> {

}
