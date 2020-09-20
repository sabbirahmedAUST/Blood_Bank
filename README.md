# Rokto Sondhan
Rokto Sondhan is an app for finding & donating Blood in emergency situations according to your location.


# What does this app do?
It is an open source Android application that allows people to search for Blood around their location.It also
provides emergency ambulence service,Reminds donor about his next donation.

# Libraries this app uses:

1. Firebase - https://firebase.google.com/ 


# Setup

It is encouraged to use latest version of Andriod Studio (4.0 or above) & sdk version 29

1. Clone or download this repo.
2. This app runs off a Firebase backend. You will need to generate your firebase backend. To do this, navigate to https://firebase.google.com/ and sign up. 
   Or follow the following steps:
   
   #Connection to Firebase
   	I. Go to Tools -> Firebase
    
	<img src="img/f1.png"/>
  
	II. A firebase window will pop up.Go to Realtime Database. Now Connect to firebase.
  
	<img src="img/f2.png" />
  
	III. In your default browser Google Signin page will appear.
   Use email: developer.aust@gmail.com
		     password: developer@aust39 
  
	<img src="img/f3.png" />
  
	     
	IV. Success message will be shown for signing in.
  
       <img src="img/f4.png" />
       
  V. Now check Firebase is connected.You are good to go.
  
	    <img src="img/f5.png" />
      
			 
3. Now sync the project. Build & Run.It should be good to go.



# What if my andriod studio isn't upto date/ Showing error?
You have to follow given steps to run project successfuly.

1.First open the project directry.Delete gradle,gradlew files shown in the picture

 <img src="img/p1.png" />
 
2.Now open any running application of Andriod Studio in your device.
  Check both build.gradle files for tools.build:gradle,compileSdkVersion & buildToolsVersion.
  The project you want to run must have same values.
  
  <img src="img/p2.png" /> 
  <img src="img/p3.png" />
  
3.Now open the project directry again.Open build.gradle & another gradle filers from app folder(app-> build.gradle) with Nodepad++
  Edit the values of tools.build:gradle,compileSdkVersion & buildToolsVersion as your ruuning version.
  
 <img src="img/p4.png" />
 <img src="img/p5.png" />
 
4.Now open the project in Andiod Studio.The problem should be solved. 





