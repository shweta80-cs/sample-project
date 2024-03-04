package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.TableToImportInExcel;

public interface TableToImportExcelRepo extends JpaRepository<TableToImportInExcel, Integer> {

}
