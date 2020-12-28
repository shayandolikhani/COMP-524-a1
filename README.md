# Java Social Distancing Application
 This application takes user inputs for distance (distance between two people in feet), duration (amount of time spent near each other), and exhalation (arbitrary exhalation 'level'), and based off of a separate data table (which has small, medium, and large values for distance/duration/exhalation, and safe combinations of the three), calculates whether the inputted combination is safe or not safe. There are four modes by which the application can calculate whether the combination is safe or not, and the ability for the user to interact with the application is provided by utilizing the model-view-controller design pattern. If any input is below zero, the program will quit.
 
 
### Given ###
If the exact combination of user inputs is safe, based off of the data table, the program will print Safe, otherwise it will print Not Safe

### Derived ###
If the combination of the three inputs is determined to be safer than at least one of the combinations in the data table, the program will print Safe, otherwise it will print Not Safe

### Interpolated ###
Given either a Distance, Distance/Duration, or Distance/Duration/Exhalation combination of inputs, interpolates the given values and determines if the exact combination of the interpolated values and medium level of other values is Safe, printing Safe if it is or Not Safe otherwise

### Inferred ###
Given the three inputs and a file of training data with Safe/Not Safe combinations, uses Weka Machine Learning to infer whether the given combination is Safe or Not Safe
