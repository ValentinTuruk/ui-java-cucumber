Feature: Catalog filters

  Scenario Outline: User should be able to filter TV in the catalog
    Given Open "Home" page
    * Navigate to "Каталог" application section
    * Accept confidentiality agreement
    * Navigate to "Телевизоры" catalog located in "Телевидение" subdepartment of "Электроника" department
    When Set vendor filter: "<vendor>"
    * Set max price filter: "<maxPrice>"
    * Set resolution filter: "<resolution>"
    * Set min diagonal filter: "<minDiagonal>"
    * Set max diagonal filter: "<maxDiagonal>"
    Then Verify all filtered results match vendor: "<vendor>"
    * Verify all filter results match max price: "<maxPrice>"
    * Verify all filter results match resolution: "<resolution>"
    * Verify all filter results match min diagonal: "<minDiagonal>"
    * Verify all filter results match max diagonal: "<maxDiagonal>"

    Examples:
      | vendor  | maxPrice | resolution          | minDiagonal | maxDiagonal |
      | Samsung | 1500     | 1920x1080 (Full HD) | 40          | 50          |
      | LG      | 2000     | 3840x2160 (4K UHD)  | 46          | 55          |