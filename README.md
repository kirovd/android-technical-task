# android-technical-task
# android-technical-task
This is my first Kotlin application that I have created in Android Studio.


## Part A - Fix current bugs

### Bug 1 - Layout does not look as expected

The way I fixed this bug was to connect each textfield/textedits together. Such as; et_email with the image_ogo, et_password with et_email, e_name with et_password and button with e_name.

### Bug 2 - Validation is incorrect

To fix this bug I had to remove the error message (else { til_name.error = getString(R.string.et_name)}) so that the name should be optional. I the other two already gave the error message if the user enters invalid fields.

### Bug 3 - Animation is looping incorrectly

I fixed this bug by writing (app:lottie_loop="true") in the activity_login.xml <com.airbnb.lottie.LottieAnimationView/>.


## Part B - Add 2 new screens

### Screen 2 - User accounts screen

Display "Hello {name} only if they provided it on previous screen" 
------> I had some bugs creating this while I write this code  e_name.setText("Hello " + e_name.getText().toString() + "!") it perfectly shows the Hello and the name entered by the user in the Optional field instead of showing it into the next screen. Therefore, writing this command code  name.setText("Hello " + e_name.getText().toString() + "!") the application closes when the user presses the log_in_button.

Show the 'TotalPlanValue' of a user'
------> I have perfectly demonstrated the TotalPlanValue in the "user" activity and xml as provided in the screenshots.

Show the accounts the user holds, e.g. ISA, GIA, LISA, Pension ///  Show all of those account's 'PlanValue'  ///   Show all of those account's 'Moneybox' total.
------> I have perfectly demonstrated the accounts that the user holds and its exactly in the same order and same creation as the screenshots. 

### Screen 3 - Individual account screen

Show the 'Name' of the account  ///   Show the account's 'PlanValue' ///   Show the accounts 'Moneybox' total   ///   Allow a user to add to a fixed value (e.g. £10) to their moneybox total.
-----> I have perfectly demonstrated the "individual account screen" where people can view their "NAME, PlanValue, Moneybox and can add a fixed value of £10 to their moneybox total. -Design Only.

 ## API

I have connected the application with the internet. Therefore, it shows an pop-up message if the user is offline and it tells them to check their connection. As for the API, I tried in various of ways to GET the https://api-test01.moneyboxapp.com/ api that was provided by the company but still had some issues during the process of calling the API.
