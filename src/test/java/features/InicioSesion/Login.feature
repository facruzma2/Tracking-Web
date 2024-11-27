Feature: Inicio sesión aplicativo Tracking
  como usuario administrador de Trackin
  quiero iniciar sesión en mi cuenta de tracking
  para poder operar en el aplicativo

  @smoke2
  Scenario Outline:inicio sesión correcto
    Given que el usuario abre el aplicativo por primera vez accediendo al login
    When digita usuario "<usuario>" y clave "<password>" validos
    And dar click en el boton login
    Then se abre pantalla home dashboard del aplicativo con accesos segun su perfil
    Examples:
      |usuario             |password       |
      |felcmna.23@gmail.com|FaP!kLE#Pw4g5  |
