# Android 8 AutoCompleteTextView BUGS
In a relatively long form inside a ScrollView, the window SoftInputMode option adjustPan is not working on Android 8, like it worked in previous Android version 7 or lower.
If you setup a form with multiple AutoCompleteTextViews, the ones at the end of the page will show the autocomplete items above the input, sometimes bellow without the user being able to select any of them. 
