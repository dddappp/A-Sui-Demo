package org.test.suitestproj1.sui.contract.repository;

import org.test.suitestproj1.sui.contract.SuiPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuiPackageRepository extends JpaRepository<SuiPackage, String> {
    
}
