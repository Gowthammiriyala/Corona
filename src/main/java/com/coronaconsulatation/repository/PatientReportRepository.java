package com.coronaconsulatation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronaconsulatation.entities.PatientReport;

public interface PatientReportRepository extends JpaRepository<PatientReport, Integer> {

}
