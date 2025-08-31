Feature: AstroTick Essential_Tools Feature Automation

Background:
Given Open the Chrome Browser
And Load the website URL as 'https://astrotick.com/'

@FreeKundli_Positive
Scenario: TC001 - Free Kundli Feature Positive test flow

And Select a Free kundli Feature
And Enter Name
And Select Gender
And Enter Birth date as '12122015'
And Enter Birth Time as '0433PM'
And Enter Birth Location
When Click on Generate Birth Chart
Then Verify Generate message

@FreeKundli_Negative
Scenario: TC002 - Free Kundli feature Negative test flow by giving invalid Birth date and Time
And Select a Free kundli Feature
And Enter Name
And Select Gender
And Enter Birth date as '015090000'
And Enter Birth Time as '1212AM'
And Enter Birth Location
But Login should fail for FreeKundli

@Numerology_Positive
Scenario: TC003 - Numerology Tool positive test flow
And select a Numerology
And Enter the name as 'Hari'
And Enter the Date of Birth as '12082016'
When Click calculate my numbers
Then Verify message

@Numerology_Negative
Scenario: TC004 - Numerology Tool negative test flow
And select a Numerology
And Enter the name as '1234'
And Enter the Date of Birth as '123090000'
But Login should fail for Numerology

@Kundli_Matching_Positive
Scenario: TC005 - Positive Login for Kundli Matching Feature
And Select a kundli Matching Feature
And Enter Boy Name as 'Prasad'
And Enter Boy BirthDate as '07102000'
And Enter Boy Birth Time as '1100am'
And Enter Boy Birth Location as 'Velachery'
And Enter Girl Name as 'TestTest'
And Enter Girl BirthDate as '20092017'
And Enter Girl Birth Time as '1232PM'
And Enter Girl Birth Location as 'Chennai'
When Click check compatibility

@Kundli_Matching_Negative
Scenario: TC006: Negative test flow for free kundli feature by giving invalid Birth date and Time
And Select a kundli Matching Feature
And Enter Boy Name as 'sasjaksj'
And Enter Boy BirthDate as '45502000'
And Enter Boy Birth Time as '6564PM'
And Enter Boy Birth Location as 'Velachery'
And Enter Girl Name as ''
And Enter Girl BirthDate as '11032016'
And Enter Girl Birth Time as '1112PM'
And Enter Girl Birth Location as 'Chennai'
But Login Should Fail for Kundli Matching

@Daily_Panchang_Positive
Scenario: TC007: Positive test flow for Daily Panchang feature
And Select Daily Panchang Feature
And Entering date as '28082025'
When Click Calculate Panchang


@Daily_Panchang_Negative
Scenario: TC008: Negative test flow for Daily Panchang featureby giving invalid Date
And Select Daily Panchang Feature
And Entering date as '2808200000'
And Entering City
But Should fail for Daily Panchang 


@Daily_Horoscope_Positive
Scenario: TC009: Positive test flow for Daily Panchang feature
And Select a Daily Horoscope feature 
And Select a Mesha Sign
And Select all other signs


@Moon_Sign_Positive
Scenario:TC010: Positive test flow for MoonSign Feature
And Select a Moon Sign Feature
And Enter Your Birth date as '28072025'
And Enter Your Birth Time as '1257PM'
And Enter Your Birth Place as 'Bangalore'
When click Check Moon Sign


@Moon_Sign_Negative
Scenario:TC011: Negative test flow for MoonSign Feature by Giving invalid Birthdate
And Select a Moon Sign Feature
And Enter Your Birth date as '28112000'
And Enter Your Birth Time as '1257PM'
When Enter Your Born Place as 'example'
But Should fail for MoonSign

@Nakshatra_Finder_Positive
Scenario: TC012: Positive test flow for Nakshatra Finder
And Select a Nakshatra Finder feature
And Give the Birth Date as '07102000'
And Give the Birth time as '1100AM'
And Give the Birth place as 'Chennai'
When Click on the Find Nakshatra
Then Verify Success Message

@Nakshatra_Finder_Negative
Scenario: TC013: Positive test flow for Nakshatra Finder
And Select a Nakshatra Finder feature
And Give the Birth Date as '071040000'
And Give the Birth time as '1100AM'
And Give the Birth place as 'Chennai'
But Should fail in submission for Nakshatra Finder


@Dasha_Calci_Positive
Scenario:TC014 Positive test flow for Dasha Calculator
And Select a Dasha Calculator feature
And Enter Your Fullname as 'Soniya'
And Enter your DOB as '12111999'
And Enter Your TOB as '0345AM'
And Enter your POB as 'Chennai'
When Click Calculate Dasha Periods


@Dasha_Calci_Negative
Scenario:TC015 Negativve test flow for Dasha calculator by providing wrong inputs!
And Select a Dasha Calculator feature
And Enter Your Fullname as ''
And Enter your DOB as '12112018'
And Enter Your TOB as '0215AM'
And Enter your POB as 'Chennai'
Then Should fail in showing result of Dasha calci!



@Lagna_Calci_Positive
Scenario:TC016 Positive test flow for Lagna Calculator
And Select a Lagna Calculator feature
And Enter your DOB in lagna as '12112000'
And Enter Your TOB in lagna as '1234PM'
And Enter your POB in lagna as 'Chennai'
When Click Calculate Lagna Periods


@Lagna_Calci_Negative
Scenario:TC017 Negative test flow for Lagna Calculator
And Select a Lagna Calculator feature
And Enter your DOB in lagna as '1211200000'
And Enter Your TOB in lagna as '1234PM'
And Enter your POB in lagna as 'Chennai'
Then Calculate lagna should fail


@Dosham_Detector_Positive
Scenario: TC018: Positive test flow for Dosham Detector
And Select a Dosham Detector feature
And Give the name in Dosham as 'Rambo'
And Give the Gender in Dosham as 'Male'
And Give the Birth Date in Dosham as '07102000'
And Give the Birth time in Dosham as '1100AM'
And Give the Birth place in Dosham as 'Chennai'
When Click on the Detect Dosham
#Then Verify Success Message for Dosham Feature


@Dosham_Detector_Negative
Scenario: TC019: Negative test flow for Dosham Detector
And Select a Dosham Detector feature
And Give the name in Dosham as 'Rambo'
And Give the Gender in Dosham as ''
And Give the Birth Date in Dosham as '07102000'
And Give the Birth time in Dosham as '1223AM'
And Give the Birth place in Dosham as 'Chennai'
But Detect Dosham should be Fail


@Sade_Sati_Positive
Scenario: TC020: Positive test flow for Sade Sati
And Select a Sade Sati Feature
And Give the name in SadeSati as 'Irungha Bhai'
And Give the Gender in SadeSati as 'Male'
And Give the Birth Date in SadeSati as '02112020'
And Give the Birth time in SadeSati as '1155PM'
And Give the Birth place in SadeSati as 'Singapore'
When Click on the calculate Sade Sati


@Sade_Sati_Negative
Scenario: TC021: Negative test flow for Sade Sati
And Select a Sade Sati Feature
And Give the name in SadeSati as 'Irungha Bhai'
And Give the Gender in SadeSati as 'Male'
And Give the Birth Date in SadeSati as ''
And Give the Birth time in SadeSati as '1155PM'
And Give the Birth place in SadeSati as 'Singapore'
Then Calculate Sade Sati should fail


@Lal_Kitab_Positive
Scenario: TC022: Positive test flow for lal Kitab
And Select a LalKitab Feature
And Give the name in LalKitab as 'Aadhik'
And Give the Birth Date in LalKitab as '17121999'
And Give the Birth time in LalKitab as '1155PM'
And Give the Birth place in LalKitab as 'Chennai'
When Click on the generate lal kitab report

@Lal_Kitab_Negative
Scenario: TC023: Positive test flow for lal Kitab
And Select a LalKitab Feature
And Give the name in LalKitab as ''
And Give the Birth Date in LalKitab as '11021999'
And Give the Birth time in LalKitab as '1224PM'
And Give the Birth place in LalKitab as 'Chennai'
Then Report generation shoud fail for Lal Kitab


@Baby_Name_Generator_Positive
Scenario: TC024: Positive test flow for Baby Name Generator feature
And Select a Babyname Generator Feature
And Give the Birth Date in Babyname feature as '11072025'
And Give the Birth time in Babyname feature as '1155PM'
And Give the Birth place in Babyname feature as 'Taiwan'
And select the Gender in BabyName feature
When Click on the Suggest Report
Then Verify success message for baby name feature


@Baby_Name_Generator_Negative
Scenario: TC025: Negative test flow for Baby Name Generator feature
And Select a Babyname Generator Feature
And Give the Birth Date in Babyname feature as '2008202535'
And Give the Birth time in Babyname feature as '1155PM'
And Give the Birth place in Babyname feature as 'Taiwan'
And select the Gender in BabyName feature
But verify error message for baby name feature



@Lucky_Number_Calculator_Positive
Scenario: TC026: Positive test flow for LuckyNumber Calculator
And Select a Lucky Nmber Feature
And Give the name in LN as 'Rolex'
And Give the Gender in LN as 'Male'
And Give the Birth Date in LN as '02111990'
And Give the Birth time in LN as '0340PM'
And Give the Birth place in LN as 'Chennai'
When Click on the Generate Lucky Numbers
Then verify success message in lucky number feature




@Lucky_Number_Calculator_Negative
Scenario: TC027: Negative test flow for LuckyNumber Calculator
And Select a Lucky Nmber Feature
And Give the name in LN as 'Leo'
And Give the Gender in LN as ''
And Give the Birth Date in LN as '02112020'
And Give the Birth time in LN as '1155PM'
And Give the Birth place in LN as 'Chennai'
But Should throw error while click the Generate Button



