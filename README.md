# assignment_two
webAssignment2

This is a Java EE web project that was intianlly supposed to take avantage of the Sring framework.
However Spring has proven to be difficult due to all spring tutorials are evendently done in elcipise,
or insuffent in descripton on how it works. 
As a result this is a standar parcitally compleate (back end is 80% done front end is 20% done). 

Developed in IDE: intellij IDEAS ULTIMATE (Student Licence) 
Uses: MYSQL, Java, CSS, HTML, JSP

Standard layout. The front end has html pages for forms and viewing outputs. Backend uses servlets that call upon functions written in 
spesific classes designed to do functionality such as makeing user or post objects, or manipulateing data then passes appropiate 
data to a reciving JSP (typically the postWall). 

Compleately implimented: 
-Visitor sign up
-Password encryption: Passwords are consistently RSA encryped and decrypted useing custom password classes created based on the tutorial
found here:https://www.jeejava.com/encryption-and-decryption-using-rsa-in-java/ 
-CSURF protcton by x-frame set up in the web XML file 
-posts can have titles
-posts can be marked public or private
-there is a text feild to type posts 
-verrsion control useing GitHub & SourceTree

-login 

partially implimented 
-SQL protection, all SQL code is done by prewriten statements. inside a obejct spespifically for dada manipulation 
-Admin capabilities, Admin pageis created but cannot log in (SQL statment incompleate) and front end iscompleatly unot finished. users
cannot access admin page by regualr login page. 
-postExparation date - users can put in a expiary date into the post form and database does have a expiary feild in 
the posts table, however no mechicim to deleate expired posts is implimented as of yet 
-code injection, Validation is done on posts to ensure that all posts are alphanumeric onnly, almost implimed the samae
on login forms and wrote the validation code for it, jsut needed to impliment it. 
--main wall page will get the 10 most recent post (front end left only) 


-
-


