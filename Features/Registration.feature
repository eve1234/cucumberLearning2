Feature: This file has registration Tests

Scenario: Verify that User is able to register
	Given User goes to http://demoqa.com/registration/
	When User fills in the given details registration form
		#One dirmentional dataset cos' its one coloum
				#|Virender|
				#|Singh|
				#|07876546655|
				#|testuser0001|
				
			#One dirmentional dataset cos' its one coloum
			|phoneNumber | 07876546655|
			|fristName   | Virender|
			|userName    | testuser0001|
			|lastName    | Singh|
			