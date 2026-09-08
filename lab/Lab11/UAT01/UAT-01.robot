*** Settings ***
Library    SeleniumLibrary

*** Variables ***
${BROWSER}    chrome
${URL}    http://sampleapp.tricentis.com

*** Test Cases ***
Go To Browser
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window

    Wait Until Element Is Visible   id=nav_automobile   timeout=10s
    Click Link    id=nav_automobile

    Input Nav_automobile

    Input Enterinsurantdata

    Input Enterproductdata

    Input Selectpriceoption

    Input Send Quote

    [Teardown]    Close Browser

*** Keywords ***
Input Nav_automobile
    Wait Until Element Is Visible    id=make   timeout=10s
    Select From List By Label   id=make    BMW
    Input Text    id=engineperformance    110
    Input Text    id=dateofmanufacture    09/09/2020
    Select From List By Label   id=numberofseats    5
    Select From List By Label   id=fuel    Electric Power
    Input Text    id=listprice    30000
    Input Text    id=licenseplatenumber    CKK1234
    Input Text    id=annualmileage    10000

    Wait Until Element Is Visible    id=nextenterinsurantdata    timeout=10s
    Click Button    nextenterinsurantdata
Input Enterinsurantdata
    Wait Until Element Is Visible    id=firstname   timeout=10s
    Input Text    id=firstname    Wichai
    Input Text    id=lastname    Sandee
    Input Text    id=birthdate    01/31/1990
    Click Element    xpath=//input[@id='gendermale']/parent::label
    Input Text    id=streetaddress    KKU
    Select From List By Label   id=country    Thailand
    Input Text    id=zipcode    40002
    Input Text    id=city    Khon Kaen
    Select From List By Label   id=occupation    Employee
    Click Element    xpath=//input[@id='other']/parent::label

    Wait Until Element Is Visible    id=nextenterproductdata    timeout=10s
    Click Button    nextenterproductdata
Input Enterproductdata
    Wait Until Element Is Visible    id=startdate   timeout=10s
    Input Text    id=startdate    10/10/2026
    Select From List By Label   id=insurancesum    7.000.000,00
    Select From List By Label   id=meritrating    Bonus 1
    Select From List By Label   id=damageinsurance    No Coverage
    Click Element    xpath=//input[@id='EuroProtection']/parent::label
    Select From List By Label   id=courtesycar    Yes

    Wait Until Element Is Visible    id=nextselectpriceoption    timeout=10s
    Click Button    nextselectpriceoption
Input Selectpriceoption
    Wait Until Element Is Visible    xpath=//input[@id='selectsilver']/parent::label   timeout=10s
    Click Element    xpath=//input[@id='selectsilver']/parent::label

    Wait Until Element Is Visible    id=nextsendquote    timeout=10s
    Click Button    nextsendquote
Input Send Quote
    Wait Until Element Is Visible    id=email   timeout=10s
    Input Text    id=email    wichai.sandee@gmail.com
    Input Text    id=phone    0049201123456
    Input Text    id=username    wichai.sandee
    Input Text    id=password    SecretPassword123!
    Input Text    id=confirmpassword    SecretPassword123!
    Input Text    id=Comments    Please contact via email only

    Wait Until Element Is Visible    id=sendemail    timeout=10s
    Click Button    sendemail
