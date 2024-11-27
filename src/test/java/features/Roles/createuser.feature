Feature: Crear Usuario Para Aduanas
  como usuario de tracking
  quiero crear un usuario con rol de aduanas
  para poder operar solo aduanas en tracking

  @smoke
  Scenario Outline: creacion usuario rol aduanas
    Given que el usuario abre el aplicativo por primera vez accediendo al login
    And digita usuario "<usuario>" y clave "<password>" validos
    And dar click en el boton login
    And desde el menu principal accede a configuracion y usuarios
    When se da clic en el boton crear usuario
    And se llena el formulario email "<usuaduanas>" y clave "<claveaduanas>"
    And se selecciona custom provider con provider serices de aduanas
    And se dar click en submit
    Then se crea el usuario de rol aduanas con acceso a tracking
    Examples:
      |usuario             |password       |usuaduanas|claveaduanas|
      |felcmna.23@gmail.com|FaP!kLE#Pw4g5  |fcruz+ad  |Clave1234*  |


  @smoke
  Scenario Outline: validar permisos usuario rol aduanas en tracking
    Given que el usuario abre el aplicativo por primera vez accediendo al login
    And digita usuario "<usuario>" y clave "<password>" validos rol aduanas
    And dar click en el boton login
    Then el usuario visualiza los paquetes con ruta de aduanas
    And solo tiene acceso a administrar eventos AD de aduanas
    Examples:
      |usuario             |password       |
      |felcmna.23@gmail.com|Clave1234*     |