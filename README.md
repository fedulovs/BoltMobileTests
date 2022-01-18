<code><img height="100" src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Bolt_logo.png/200px-Bolt_logo.png"></code>

# Bolt mobile automation project
### UI tests for bolt app https://play.google.com/store/apps/details?id=ee.mtakso.client

## Technology Stack:

<code><img height="30" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg"></code>
<code><img height="30" src="https://starchenkov.pro/qa-guru/img/skills/Selenide.svg"></code>
<code><img height="30" src="https://starchenkov.pro/qa-guru/img/skills/Appium.svg"></code>
<code><img height="30" src="https://starchenkov.pro/qa-guru/img/skills/JUnit5.svg"></code>
<code><img height="30" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jenkins/jenkins-original.svg"></code>
<code><img height="30" src="https://starchenkov.pro/qa-guru/img/skills/Allure_Report.svg"></code>
<code><img height="30" src="https://starchenkov.pro/qa-guru/img/skills/Browserstack.svg"></code>
<code><img height="30" src="https://starchenkov.pro/qa-guru/img/skills/Selenoid.svg"></code>


## Description

Project contains Appium tests on first two screens Android application.
The following screens are covered 

1. Login page
2. Select country page

## Tests

This suite doesn't pretend to be exaustive

1. Open login page
2. Open countries list
3. Enter wrong phone number
4. Go back from countries list
5. Search country in countries list
6. Check empty list placeholder
7. Open Facebook

## Job settings

Test could be launched from Jenkins with 3 device farm options: 

* local
* selenoid
* browserstack

![jenkins settings](./images/JobSettings.png)

## Allure report

Each test has screenshot and page source attached

![allure report](./images/AllureReport.png)

