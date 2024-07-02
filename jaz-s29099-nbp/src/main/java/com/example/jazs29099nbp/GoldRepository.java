package com.example.jazs29099nbp;


import com.example.jazs29099nbp.Model.GoldPriceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoldRepository extends JpaRepository<GoldPriceRecord, Long>
{
}
