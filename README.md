![projectBanner](https://user-images.githubusercontent.com/78764928/114941034-9ddb6a80-9e10-11eb-9259-a75801262b22.png)
# _Reservo App_
***

The Reservo app simplifies the process of making a reservation at a restaurant. The app is built purely in Kotlin which allows some of the most up to date functions available while remaining available to most devices by supporting a minimum of Android 5.1 Lollipop.

Currently only available for Android.

# _Features_
- Reservo makes it easy for customers! This app allows them to:
- Choose a specific date and time to reserve
- Specify the number of guests attending
- See the dining room layout and choose a table
- Review their confirmed reservations

# _Installation Instructions_
Begining with downloading the application apk [here](https://github.com/JordanS11/final-project/blob/fbccfad09e3bd17a1b35d9b6347d86c9e9989dfe/app/release/reservo.apk). Once the file is on your device, navigate to your device's system **Settings** and find **Security**. In Security, find **Install unknown apps** setting and set it to 'allow'.
This setting may alternatively be found in the **Privacy** settings on your device, depending on the operating system installed.  

After this step is completed, simply use your devices default file navigating app to find your **Downloads** folder where the _Reservo_ apk was downloaded to and tap it to begin the install!

# _Operating Instructions_
When navigating through the _Reservo_ app, it is a guided process. The first screen is the menu screen, and there are two buttons: one to create a reservation and one to check current reservations. Checking the reservation will show the date, time, number of guests and table number from a previously scheduled reservation, if one was not made then a message is displayed that there is no reservation. 

Choosing make a reservation brings the user to the date choosing screen that has a month/day/year and hour/minute picker as well as a guest number drop down menu for the specifications of the reservation. A button to confirm these choices is then available to bring up an example dining room layout with 6 tables. The dining room layout allows the user to choose where in a restaurant they would like to be seated, as an added level of custom reservations that can be made using this app. 

Upon choosing a table, the user is brought to a full confirmation screen. This confirmation screen lists the date, time and number of guests that the user has chosen with two options of cancelling and confirming them. Both options return back to the first menu screen, however when the confirm button is pressed, the reservation can be viewed under the 'My Reservation' button.

# _Manifest_
##### APK
For installation, the .apk file can be found at [app/release/reservo.apk](https://github.com/JordanS11/final-project/blob/fbccfad09e3bd17a1b35d9b6347d86c9e9989dfe/app/release/reservo.apk)
##### Kotlin Files
Found in the [main java directory](https://github.com/JordanS11/final-project/tree/main/app/src/main/java/com/northernwebtech/comp2430finalproject)
- MainActivity.kt - Used for inflating the fragments.
- ShowReservationFragment.kt - Displays a review of a confirmed reservation.
- ConfirmationFragment.kt - Allows verification of user input of number of guests, date and time.
- DateFragment.kt - Allows the user to define the number of guests, date and time.
- FloorplanFragment.kt
- MenuFragment.kt
##### XML Files
The XML files are used for the visual layout of each fragment. The naming of these files relate to the kotlin files they are made to display. All layout XML files are found in the [/main/res/layout](https://github.com/JordanS11/final-project/tree/main/app/src/main/res/layout) folder.
- activity_main.xml
- confirmation_layout.xml
- date_layout.xml
- floorplan_layout.xml
- guest_spinner.xml
- menu_layout.xml
- show_reservation.xml
# _Copyright Information_
None! _Reservo_ is open source so the use and reproduction of this application is unlimited!

# _Feedback_
Feedback is always welcome, whether errors are encountered or if you have an idea to improve the app, it can be sent to me via email at jscott11@lakeheadu.ca!

# _Bugs List_


When navigating back from the table selection screen to the date choice screen, if the number of guests is not chosen again the number of guests displayed in the confirmation screen will be blank.

When navigating back from the check reservation screen, the reservation is deleted.

# _Credit_
"See you soon!" image taken from, www.pngkey.com




