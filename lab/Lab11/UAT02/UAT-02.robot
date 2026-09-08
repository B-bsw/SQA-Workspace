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
    Wait Until Element Is Visible    id=nextenterinsurantdata    timeout=10s
    Click Button    nextenterinsurantdata
Input Enterinsurantdata
    Wait Until Element Is Visible    id=nextenterproductdata    timeout=10s
    Click Button    nextenterproductdata
Input Enterproductdata
    Wait Until Element Is Visible    id=nextselectpriceoption    timeout=10s
    Click Button    nextselectpriceoption
Input Selectpriceoption
    Wait Until Element Is Visible    id=nextsendquote    timeout=10s
    Click Button    nextsendquote
Input Send Quote
    Wait Until Element Is Visible    id=sendemail    timeout=10s
    Click Button    sendemail
